package com.cdzy.xmshop.service.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdzy.xmshop.dao.ItemsMapper;
import com.cdzy.xmshop.entity.Items;
import com.cdzy.xmshop.utils.ResultVO;

@Service
public class ItemsApiServiceImpl implements ItemsApiService {
	
	@Autowired
	private ItemsMapper itemsMapper;

	public ResultVO selectList(String ordersId) {
		List<Items> list = itemsMapper.selectList(ordersId);
		if (list!=null) {
			return new ResultVO(10000,"成功",list);
		}else{
			return new ResultVO(10001,"失败");
		}
	}

}
