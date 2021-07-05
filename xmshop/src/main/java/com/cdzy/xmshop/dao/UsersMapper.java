package com.cdzy.xmshop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.cdzy.xmshop.entity.Users;

@Repository
public interface UsersMapper {
    
    @Insert("insert into users(phone,password) values(#{phone},#{password})")
    public int registerUsers(@Param("phone") String phone,@Param("password") String password);
    
    @Select("select * from users where phone=#{phone}")
    public Users queryByPhone(String phone);
    
    @Select("select * from users")
    public List<Users> getAllUsers(int pageNum,int pageSize);
    
    @Insert("insert into users(username,password,phone,address) values(#{username},#{password},#{phone},#{address})")
    public int insertUsers(Users users);
    
    @Update("update users set username=#{username},phone=#{phone},address=#{address} where id=#{id}")
    public int updateUsers(Users users);
    
    @Delete("delete from users where id=#{id}")
    public int deleteUsersById(int id);
    
    @Select("select * from users where address like concat('%',#{address},'%')")
    public List<Users> queryAddress(int pageNum,int pageSize,@Param("address")String address);
    
}