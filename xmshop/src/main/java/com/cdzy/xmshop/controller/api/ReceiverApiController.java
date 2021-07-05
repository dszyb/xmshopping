package com.cdzy.xmshop.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdzy.xmshop.service.api.ReceiverApiService;
import com.cdzy.xmshop.utils.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="收货地址管理接口模板")
@RestController
@RequestMapping("api/v1")
public class ReceiverApiController {
	
	@Autowired
	private ReceiverApiService receiverApiService;
	
	@ApiOperation("查询全部收货地址信息")
	@GetMapping("/receiver/getAllReceiver")
	public ResultVO getAllReceiver(){
		ResultVO resultVO = receiverApiService.getAllReceivers();
		return resultVO;
	}
	
	@ApiOperation("根据用户id查询收货地址信息")
	@GetMapping("/receiver/getReceiverById/{usersId}")
	public ResultVO getReceiverById(@PathVariable("usersId")int usersId){
		ResultVO resultVO = receiverApiService.selectReceiverById(usersId);
		return resultVO;
	}
	
	@ApiOperation("添加收货地址信息")
	@PostMapping("/receiver/insertReceiver")
	public ResultVO insertReceiver(int usersId,String receiverName,String receiverPhone,String receiverProvince,String receiverCity,String receiverDistrict,String receiverAddress){
		ResultVO resultVO = receiverApiService.insertReceivers(usersId, receiverName, receiverPhone, receiverProvince, receiverCity, receiverDistrict, receiverAddress);
		return resultVO;
	}
	
	@ApiOperation("修改收货地址信息")
	@PostMapping("/receiver/updateReceiver")
	public ResultVO updateReceiver(String receiverName,String receiverPhone,String receiverProvince,String receiverCity,String receiverDistrict,String receiverAddress,int receiverId){
		ResultVO resultVO = receiverApiService.updateReceivers(receiverName, receiverPhone, receiverProvince, receiverCity, receiverDistrict, receiverAddress, receiverId);
		return resultVO;
	}
	
}
