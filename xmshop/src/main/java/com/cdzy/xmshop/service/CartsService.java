package com.cdzy.xmshop.service;

import java.util.List;
import com.cdzy.xmshop.entity.Carts;

public interface CartsService {
	
	public List<Carts> getAllCarts(int pageNum,int pageSize);
	
	public List<Carts> queryByGId(int pageNum,int pageSize,int goodsId);
	
}
