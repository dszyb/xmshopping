package com.cdzy.xmshop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdzy.xmshop.dao.CartsMapper;
import com.cdzy.xmshop.entity.Carts;
import com.github.pagehelper.PageHelper;

@Service
public class CartsServiceImpl implements CartsService {
	
	@Autowired
	private CartsMapper cartsMapper;
	
	
	public List<Carts> getAllCarts(int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return cartsMapper.getAllCarts(pageNum, pageSize);
	}

	
	public List<Carts> queryByGId(int pageNum, int pageSize, int goodsId) {
		PageHelper.startPage(pageNum, pageSize);
		return cartsMapper.queryByGId(pageNum, pageSize, goodsId);
	}
	
}
