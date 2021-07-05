package com.cdzy.xmshop.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cdzy.xmshop.service.api.CartsApiService;
import com.cdzy.xmshop.utils.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="购物车接口模板")
@RestController
@RequestMapping("api/v1")
public class CartsApiController {
	
	@Autowired
	private CartsApiService cartsApiService;
	
	@ApiOperation("根据用户ID查询购物车")
	@GetMapping("/carts/getCarts")
	public ResultVO getCarts(int usersId){
		ResultVO resultVO=cartsApiService.getCarts(usersId);
		return resultVO;
	}
	
	@ApiOperation("根据ID集合查询对应的信息")
	@GetMapping("/carts/listCartsByIds")
	public ResultVO listCartsByIds(String ids){
		ResultVO resultVO = cartsApiService.listCartsByIds(ids);
		return resultVO;
	}
	
	@ApiOperation("添加购物车")
	@PostMapping("/carts/insertCarts")
	public ResultVO insertCarts(@RequestParam(defaultValue="1")int amount,int goodsId,int usersId){
		ResultVO resultVO = cartsApiService.insertCarts(amount, usersId, goodsId);
		return resultVO;
	}
	
	@ApiOperation("更新购物车数量")
	@GetMapping("/carts/updateAmount/{amount}/{id}/{usersId}")
	public ResultVO updateAmount(@PathVariable("amount")int amount,@PathVariable("id")int id,@PathVariable("usersId")int usersId){
		ResultVO resultVO = cartsApiService.updateAmount(amount, id,usersId);
		return resultVO;
	}
	
	@ApiOperation("移除单个购物车列表信息")
	@GetMapping("/carts/removeCartsById/{id}")
	public ResultVO removeCartsById(@PathVariable("id")int id){
		ResultVO resultVO = cartsApiService.removeCartsById(id);
		return resultVO;
	}

}
