package com.cdzy.xmshop.service.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdzy.xmshop.dao.GoodsMapper;
import com.cdzy.xmshop.entity.Goods;
import com.cdzy.xmshop.utils.ResultVO;

@Service
public class GoodsApiServiceImpl implements GoodsApiService {
	
	@Autowired
	private GoodsMapper goodsMapper;

	
	public ResultVO getAllGoodss() {
		List<Goods> list = goodsMapper.getAllGoodss();
		if (list==null) {
			return new ResultVO(10001,"失败");
		} else {
			return new ResultVO(10000,"成功",list);
		}
	}

	
	public ResultVO getGoodsById(int id) {
		Goods goods = goodsMapper.selectById(id);
		if (goods==null) {
			return new ResultVO(10001,"失败");
		} else {
			return new ResultVO(10000,"成功",goods);
		}
	}

}
