package com.cdzy.xmshop.service.api;

import com.cdzy.xmshop.utils.ResultVO;

public interface CartsApiService {
	
	public ResultVO getCarts(int usersId);
	
	public ResultVO selectById(int goodsId,int usersId);
	
	public ResultVO insertCarts(int amount,int usersId,int goodsId);
	
	public ResultVO updateAmount(int amount,int id,int usersId);
	
	public ResultVO removeCartsById(int id);
	
	public ResultVO listCartsByIds(String ids);
	
}
