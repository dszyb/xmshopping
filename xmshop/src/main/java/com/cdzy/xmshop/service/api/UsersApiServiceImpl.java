package com.cdzy.xmshop.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdzy.xmshop.dao.UsersMapper;
import com.cdzy.xmshop.entity.Users;
import com.cdzy.xmshop.utils.MD5Util;
import com.cdzy.xmshop.utils.ResultVO;

@Service
public class UsersApiServiceImpl implements UsersApiService{
	
	@Autowired
	private UsersMapper usersMapper;

	public ResultVO userResgit(String phone, String password) {
			Users users = usersMapper.queryByPhone(phone);
			if (users==null) {
				String md5Pwd=MD5Util.strToMd5(password);
				int i=usersMapper.registerUsers(phone,md5Pwd);
				if (i>0) {
					return new ResultVO(10000,"注册成功",users);
				}else{
					return new ResultVO(10002,"注册失败");
				}
			}else{
				return new ResultVO(10001,"用户已被注册");
			}
	}

	public ResultVO checkLogin(String phone, String password) {
		Users users = usersMapper.queryByPhone(phone);
		if (users==null) {
			return new ResultVO(10001,"登录失败");
		}else{
			String md5Pwd=MD5Util.strToMd5(password);
			if (md5Pwd.equals(users.getPassword())) {
				return new ResultVO(10000,"登录成功",users);
			}else{
				return new ResultVO(10001,"登录失败,密码错误");
			}
		}
	}

}
