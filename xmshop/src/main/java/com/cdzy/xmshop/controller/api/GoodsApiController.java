package com.cdzy.xmshop.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdzy.xmshop.service.api.GoodsApiService;
import com.cdzy.xmshop.utils.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="商品管理接口模板")
@RestController
@RequestMapping("api/v1")
public class GoodsApiController {
	
	@Autowired
	private GoodsApiService goodsApiService;
	
	@ApiOperation("查询所有商品")
	@GetMapping("/goods/getAllGoodss")
	public ResultVO getAllGoodss(){
		ResultVO resultVO = goodsApiService.getAllGoodss();
		return resultVO;
	}
	
	@ApiOperation("根据商品id查询商品")
	@GetMapping("/goods/getAllGoodssById/{id}")
	public ResultVO getAllGoodssById(@PathVariable("id")int id){
		ResultVO resultVO = goodsApiService.getGoodsById(id);
		return resultVO;
	}
	
}
