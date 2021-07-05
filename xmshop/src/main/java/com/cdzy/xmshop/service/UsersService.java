package com.cdzy.xmshop.service;

import java.util.List;
import com.cdzy.xmshop.entity.Users;

public interface UsersService {
	
	public List<Users> getAllUsers(int pageNum,int pageSize);
	
	public int insertUsers(Users users);
	
	public int updateUsers(Users users);
	
	public int deleteUsers(int id);
	
	public List<Users> queryAddress(int pageNum,int pageSize,String address);
	
}
