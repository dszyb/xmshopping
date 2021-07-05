package com.cdzy.xmshop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdzy.xmshop.dao.OrdersMapper;
import com.cdzy.xmshop.entity.OrdersVO;
import com.github.pagehelper.PageHelper;

@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	private OrdersMapper ordersMapper;

	
	public List<OrdersVO> getAllOrders(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return ordersMapper.getAllOrders(pageNum, pageSize);
	}

	
	public List<OrdersVO> queryReName(int pageNum, int pageSize, String receiverName) {
		PageHelper.startPage(pageNum, pageSize);
		return ordersMapper.queryReName(pageNum, pageSize, receiverName);
	}

}
