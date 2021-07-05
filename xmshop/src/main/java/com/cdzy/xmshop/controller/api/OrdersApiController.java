package com.cdzy.xmshop.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdzy.xmshop.service.api.OrdersApiService;
import com.cdzy.xmshop.utils.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="订单详情接口模板")
@RestController
@RequestMapping("api/v1")
public class OrdersApiController {
	
	@Autowired
	private OrdersApiService ordersApiService;
	
	@ApiOperation("根据用户ID查询订单详情")
	@GetMapping("/orders/getOrders/{usersId}")
	public ResultVO getOrders(@PathVariable("usersId")int usersId){
		ResultVO resultVO = ordersApiService.getOrdersByUId(usersId);
		return resultVO;
	}
	
	@ApiOperation("创建订单")
	@PostMapping("/orders/insertOrders")
	public ResultVO insertOrders(int usersId,String ids,int receiverId,float total){
		ResultVO resultVO = ordersApiService.insertOrders(usersId,ids,receiverId,total);
		return resultVO;
	}
	
	@ApiOperation("根据订单号查看详情")
	@GetMapping("/orders/selectByOId/{ordersId}")
	public ResultVO selectByOId(@PathVariable("ordersId")String ordersId){
		ResultVO resultVO = ordersApiService.selectByOId(ordersId);
		return resultVO;
	}
}
