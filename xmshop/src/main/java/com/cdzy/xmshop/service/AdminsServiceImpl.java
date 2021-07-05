package com.cdzy.xmshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdzy.xmshop.dao.AdminsMapper;
import com.cdzy.xmshop.entity.Admins;

@Service
public class AdminsServiceImpl implements AdminsService{
	
	@Autowired
	private AdminsMapper adminsMapper;
	
	public boolean Login(String username, String password) {
		 boolean flag = false;
	       Admins login = adminsMapper.login(username, password);
	        if (login!=null){
	            flag=true;
	        }
	        return flag;
	}
}
