package com.cdzy.xmshop.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.cdzy.xmshop.entity.Admins;

public interface AdminsMapper {
	
    @Select("select * from admins where username=#{username} and password=#{password}")
    public Admins login(@Param("username") String username,@Param("password") String password);

}
