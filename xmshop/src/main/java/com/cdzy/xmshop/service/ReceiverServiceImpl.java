package com.cdzy.xmshop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdzy.xmshop.dao.ReceiverMapper;
import com.cdzy.xmshop.entity.Receiver;
import com.github.pagehelper.PageHelper;

@Service
public class ReceiverServiceImpl implements ReceiverService {
	
	@Autowired
	private ReceiverMapper receiverMapper;

	public List<Receiver> getAllReceiver(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return receiverMapper.getAllReceiver(pageNum, pageSize);
	}

	public List<Receiver> queryProvince(int pageNum, int pageSize, String receiverProvince) {
		PageHelper.startPage(pageNum, pageSize);
		return receiverMapper.queryProvince(pageNum, pageSize, receiverProvince);
	}

}
