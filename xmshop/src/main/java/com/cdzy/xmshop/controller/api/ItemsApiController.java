package com.cdzy.xmshop.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdzy.xmshop.service.api.ItemsApiService;
import com.cdzy.xmshop.utils.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="订单管理接口模板")
@RestController
@RequestMapping("api/v1")
public class ItemsApiController {
	
	@Autowired
	private ItemsApiService itemsApiService;
	
	@ApiOperation("根据订单号查询订单")
	@GetMapping("/items/getAllItems/{ordersId}")
	public ResultVO getAllItems(@PathVariable("ordersId")String ordersId){
		ResultVO resultVO = itemsApiService.selectList(ordersId);
		return resultVO;
	}
	
}
