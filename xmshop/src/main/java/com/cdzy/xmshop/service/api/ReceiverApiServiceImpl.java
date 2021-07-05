package com.cdzy.xmshop.service.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdzy.xmshop.dao.ReceiverMapper;
import com.cdzy.xmshop.entity.Receiver;
import com.cdzy.xmshop.utils.ResultVO;

@Service
public class ReceiverApiServiceImpl implements ReceiverApiService {
	
	@Autowired
	private ReceiverMapper receiverMapper;

	
	public ResultVO getAllReceivers() {
		List<Receiver> list = receiverMapper.getAllReceivers();
		if (list==null) {
			return new ResultVO(10001,"失败");
		} else {
			return new ResultVO(10000,"成功",list);
		}
	}


	public ResultVO selectReceiverById(int usersId) {
		List<Receiver> list = receiverMapper.selectById(usersId);
		ResultVO resultVO = new ResultVO(10000,"成功",list);
		return resultVO;
	}

	
	public ResultVO insertReceivers(int usersId,String receiverName,String receiverPhone,String receiverProvince,String receiverCity,String receiverDistrict,String receiverAddress) {
		int result=receiverMapper.insertReceiver(usersId,receiverName,receiverPhone,receiverProvince,receiverCity,receiverDistrict,receiverAddress);
		if (result==1) {
			return new ResultVO(10000,"成功");
		} else {
			return new ResultVO(10001,"失败");
		}
	}

	
	public ResultVO updateReceivers(String receiverName,String receiverPhone,String receiverProvince,String receiverCity,String receiverDistrict,String receiverAddress,int receiverId) {
		int result=receiverMapper.updateReceiver(receiverName, receiverPhone, receiverProvince, receiverCity, receiverDistrict, receiverAddress, receiverId);
		if (result==1) {
			return new ResultVO(10000,"成功");
		} else {
			return new ResultVO(10001,"失败");
		}
	}

}
