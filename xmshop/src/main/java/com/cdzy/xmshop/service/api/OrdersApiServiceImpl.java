package com.cdzy.xmshop.service.api;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdzy.xmshop.dao.CartsMapper;
import com.cdzy.xmshop.dao.GoodsMapper;
import com.cdzy.xmshop.dao.ItemsMapper;
import com.cdzy.xmshop.dao.OrdersMapper;
import com.cdzy.xmshop.dao.ReceiverMapper;
import com.cdzy.xmshop.entity.Carts;
import com.cdzy.xmshop.entity.Goods;
import com.cdzy.xmshop.entity.Items;
import com.cdzy.xmshop.entity.Orders;
import com.cdzy.xmshop.entity.Receiver;
import com.cdzy.xmshop.utils.ResultVO;

@Service
public class OrdersApiServiceImpl implements OrdersApiService {
	
	@Autowired
	private OrdersMapper ordersMapper;
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Autowired
	private CartsMapper cartsMapper;
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Autowired
	private ReceiverMapper receiverMapper;

	public ResultVO getOrdersByUId(int usersId) {
		List<Orders> list = ordersMapper.getOrdersByUId(usersId);
		for (Orders orders : list) {
			List<Items> lItems = itemsMapper.selectList(orders.getOrdersId());
			orders.setItems(lItems);
			for (Items items : lItems) {
				Goods goods = goodsMapper.selectById(items.getGoodsId());
				items.setGoods(goods);
			}
			Receiver receiver = receiverMapper.selectByRId(orders.getReceiverId());
			orders.setReceiver(receiver);
		}
		return new ResultVO(10000,"成功",list);
	}

	
	public ResultVO insertOrders(int usersId,String ids, int receiverId, float total) {
		
		String[] arr=ids.split(",");
		List<Integer> cIntegers=new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			cIntegers.add(Integer.parseInt(arr[i]));
		}
		List<Carts> cList = cartsMapper.selectCartsByIds(cIntegers);
		if (Objects.isNull(cList) || cList.isEmpty()) {
			System.out.println("购物车没有选中要购买的商品");
		}
		
		boolean flag=true;
		int goodsId;
		for (Carts carts : cList) {
			goodsId=carts.getGoodsId();
			Goods goods = goodsMapper.selectById(goodsId);
			carts.setGoods(goods);
			if (carts.getGoods().getQuantity() < carts.getAmount()) {
				flag=false;
				
			}
		}
		
		if (flag) {
			Orders orders = new Orders();
			String orderCode = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			orders.setOrdersId(orderCode);
			orders.setTotal(total);
			orders.setStatus(1);
			orders.setCreateTime(new Date());
			orders.setUsersId(usersId);
			orders.setReceiverId(receiverId);
			ordersMapper.insertOrders(orders);
			
			List<Items> lItems = new ArrayList<Items>();
			for (Carts cs : cList) {
				Items items = new Items();
				items.setPrice(cs.getGoods().getPrice());
				items.setAmount(cs.getAmount());
				items.setOrdersId(orders.getOrdersId());
				items.setGoodsId(cs.getGoodsId());
				lItems.add(items);
				System.out.println("items: "+items);
				goodsMapper.updateQuantity(cs.getAmount(),cs.getGoodsId());
			}
			System.out.println("lItems: "+lItems);
			itemsMapper.insertItems(lItems);
			
			for(int id : cIntegers){
				cartsMapper.removeCartsById(id);
			}
			
			return new ResultVO(10000,"库存充足",lItems);
		} else {
			return new ResultVO(10001,"库存不足");
		}
		
	}

	
	public ResultVO selectByOId(String ordersId) {
		Orders orders = ordersMapper.selectByOId(ordersId);
		if (orders!=null) {
			List<Items> iList = itemsMapper.selectList(orders.getOrdersId());
			for (Items items : iList) {
				items.setGoods(goodsMapper.selectById(items.getGoodsId()));
			}
			orders.setItems(iList);
			return new ResultVO(10000,"成功",orders);
		} else {
			return new ResultVO(10001,"失败");
		}
	}

}
