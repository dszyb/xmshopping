package com.cdzy.xmshop.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cdzy.xmshop.service.api.UsersApiService;
import com.cdzy.xmshop.utils.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags="用户登录注册接口模板")
@RestController
@RequestMapping("api/v1")
public class UsersApiController {
	
	@Autowired
	private UsersApiService usersApiService;
	
	@ApiOperation("用户登录")
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="string",name="phone",value="用户登录手机号码",required=true),
		@ApiImplicitParam(dataType="string",name="password",value="用户登录密码",required=true)
	})
	@GetMapping("/userLogin")
	public ResultVO login(@RequestParam("phone")String phone,@RequestParam("password")String password){
		ResultVO resultVO = usersApiService.checkLogin(phone, password);
		return resultVO;
	}
	
	@ApiOperation("用户注册")
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="string",name="phone",value="用户注册手机号码",required=true),
		@ApiImplicitParam(dataType="string",name="password",value="用户注册密码",required=true)
	})
	@RequestMapping(value="/userResgit",method=RequestMethod.POST)
	public ResultVO regist(@RequestParam("phone")String phone,@RequestParam("password")String password){
		ResultVO resultVO = usersApiService.userResgit(phone, password);
		return resultVO;
	}
}
