package com.cdzy.xmshop.service;

import java.util.List;
import com.cdzy.xmshop.entity.Goods;

public interface GoodsService {
	
	public List<Goods> getAllGoods(int pageNum,int pageSize);
	
	public Goods selectById(int id);
	
	public int insertGoods(Goods goods);
	
	public int updateGoods(Goods goods);
	
	public int deleteGoods(int id);
	
	public List<Goods> queryName(int pageNum,int pageSize,String name);
	
}
