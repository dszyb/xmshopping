package com.cdzy.xmshop.service.api;

import com.cdzy.xmshop.utils.ResultVO;

public interface OrdersApiService {
	
	public ResultVO getOrdersByUId(int usersId);
	
	public ResultVO insertOrders(int usersId,String ids,int receiverId,float total);
	
	public ResultVO selectByOId(String ordersId);
	
}
