package com.cdzy.xmshop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdzy.xmshop.dao.UsersMapper;
import com.cdzy.xmshop.entity.Users;
import com.github.pagehelper.PageHelper;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
    private UsersMapper usersMapper;
	
	public List<Users> getAllUsers(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return usersMapper.getAllUsers(pageNum, pageSize);
	}
	
	public int insertUsers(Users users) {
		return usersMapper.insertUsers(users);
	}
	
	public int updateUsers(Users users) {
		return usersMapper.updateUsers(users);
	}
	
	public int deleteUsers(int id) {
		return usersMapper.deleteUsersById(id);
	}
	
	public List<Users> queryAddress(int pageNum, int pageSize, String address) {
		PageHelper.startPage(pageNum, pageSize);
		return usersMapper.queryAddress(pageNum, pageSize, address);
	}

}
