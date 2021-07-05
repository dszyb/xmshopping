package com.cdzy.xmshop.service.api;

import com.cdzy.xmshop.utils.ResultVO;

public interface GoodsApiService {
	
	public ResultVO getAllGoodss();
	
	public ResultVO getGoodsById(int id);
}
