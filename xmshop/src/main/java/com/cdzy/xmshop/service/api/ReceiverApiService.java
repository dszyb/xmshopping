package com.cdzy.xmshop.service.api;

import com.cdzy.xmshop.utils.ResultVO;

public interface ReceiverApiService {
	
	public ResultVO getAllReceivers();
	
	public ResultVO selectReceiverById(int usersId);
	
	public ResultVO insertReceivers(int usersId,String receiverName,String receiverPhone,String receiverProvince,String receiverCity,String receiverDistrict,String receiverAddress);
	
	public ResultVO updateReceivers(String receiverName,String receiverPhone,String receiverProvince,String receiverCity,String receiverDistrict,String receiverAddress,int receiverId);
	
}
