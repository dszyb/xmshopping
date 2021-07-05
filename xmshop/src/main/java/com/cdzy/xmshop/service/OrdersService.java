package com.cdzy.xmshop.service;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.cdzy.xmshop.entity.OrdersVO;

@Repository
public interface OrdersService {
	
	public List<OrdersVO> getAllOrders(int pageNum,int pageSize);
	
	public List<OrdersVO> queryReName(int pageNum,int pageSize,String receiverName);
	
}
