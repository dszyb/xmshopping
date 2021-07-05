package com.cdzy.xmshop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdzy.xmshop.dao.GoodsMapper;
import com.cdzy.xmshop.entity.Goods;
import com.github.pagehelper.PageHelper;

@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;

	public List<Goods> getAllGoods(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
        return goodsMapper.getAllGoods(pageNum, pageSize);
	}
	
	public Goods selectById(int id) {
		return goodsMapper.selectById(id);
	}

	public int insertGoods(Goods goods) {
		return goodsMapper.insertGoods(goods);
	}

	public int updateGoods(Goods goods) {
		return goodsMapper.updateGoods(goods);
	}
	
	public int deleteGoods(int id) {
		return goodsMapper.deleteGoods(id);
	}
	
	public List<Goods> queryName(int pageNum, int pageSize, String name) {
		PageHelper.startPage(pageNum, pageSize);
		return goodsMapper.queryName(pageNum, pageSize, name);
	}

}
