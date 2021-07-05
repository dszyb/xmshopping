package com.cdzy.xmshop.service.api;

import com.cdzy.xmshop.utils.ResultVO;

public interface UsersApiService {
	
	public ResultVO userResgit(String phone,String password);
	
	public ResultVO checkLogin(String phone,String password);
	
}
