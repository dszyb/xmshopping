package com.cdzy.xmshop.service.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdzy.xmshop.dao.CartsMapper;
import com.cdzy.xmshop.entity.Carts;
import com.cdzy.xmshop.utils.ResultVO;

@Service
public class CartsApiServiceImpl implements CartsApiService {
	
	@Autowired
	private CartsMapper cartsMapper;
	
	public ResultVO getCarts(int usersId) {
		List<Carts> list=cartsMapper.getCarts(usersId);
		ResultVO resultVO = new ResultVO(10000,"�ɹ�",list);
		return resultVO;
	}
	
	public ResultVO selectById(int goodsId, int usersId) {
		Carts carts = cartsMapper.selectById(goodsId, usersId);
		if (carts!=null) {
			return new ResultVO(10000,"�ɹ�",carts);
		} else {
			return new ResultVO(10001,"ʧ��");
		}
	}

	public ResultVO insertCarts(int amount,int usersId,int goodsId) {
		Carts carts = cartsMapper.selectById(goodsId, usersId);
		if (carts!=null) {
			updateAmount(amount,carts.getId(), usersId);
			return new ResultVO(10000,"�ɹ�");
		}else{
			cartsMapper.insertCarts(amount, usersId, goodsId);
			return new ResultVO(10000,"�ɹ�");
		}
	}
	
	public ResultVO updateAmount(int amount, int id,int usersId) {
		int i = cartsMapper.updateAmount(amount, id,usersId);
		if (i>0) {
			return new ResultVO(10000,"�ɹ�");
		} else {
			return new ResultVO(10001,"ʧ��");
		}
	}

	public ResultVO removeCartsById(int id) {
		int i = cartsMapper.removeCartsById(id);
		if (i>0) {
			return new ResultVO(10000,"�ɹ�");
		} else {
			return new ResultVO(10001,"ʧ��");
		}
	}

	
	public ResultVO listCartsByIds(String ids) {
		String[] arr=ids.split(",");
		List<Integer> cartsIds = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			cartsIds.add(Integer.parseInt(arr[i]));
		}
		List<Carts> list=cartsMapper.selectCartsByIds(cartsIds);
		if (list!=null) {
			return new ResultVO(10000,"�ɹ�",list);
		} else {
			return new ResultVO(10001,"ʧ��");
		}
	}

}
