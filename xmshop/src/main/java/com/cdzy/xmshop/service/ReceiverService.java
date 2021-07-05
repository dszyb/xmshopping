package com.cdzy.xmshop.service;

import java.util.List;
import com.cdzy.xmshop.entity.Receiver;

public interface ReceiverService {
	
	public List<Receiver> getAllReceiver(int pageNum,int pageSize);
	
	public List<Receiver> queryProvince(int pageNum,int pageSize,String receiverProvince);
	
}
