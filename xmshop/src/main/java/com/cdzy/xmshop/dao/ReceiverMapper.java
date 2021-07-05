package com.cdzy.xmshop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.cdzy.xmshop.entity.Receiver;

@Repository
public interface ReceiverMapper {
	
    @Select("select * from receiver")
    public List<Receiver> getAllReceiver(int pageNum,int pageSize);
    
    @Select("select * from receiver")
    public List<Receiver> getAllReceivers();
    
    @Select("select * from receiver where users_id=#{usersId}")
    public List<Receiver> selectById(int usersId);
    
    @Select("select * from receiver where receiver_id=#{receiverId}")
    public Receiver selectByRId(int receiverId);
    
    @Insert("insert into receiver(users_id,receiver_name,receiver_phone,receiver_province,receiver_city,receiver_district,receiver_address) values(#{usersId},#{receiverName},#{receiverPhone},#{receiverProvince},#{receiverCity},#{receiverDistrict},#{receiverAddress})")
    public int insertReceiver(@Param("usersId")int usersId,@Param("receiverName")String receiverName,@Param("receiverPhone")String receiverPhone,@Param("receiverProvince")String receiverProvince,@Param("receiverCity")String receiverCity,@Param("receiverDistrict")String receiverDistrict,@Param("receiverAddress")String receiverAddress);
    
    @Update("update receiver set receiver_name=#{receiverName},receiver_phone=#{receiverPhone},receiver_province=#{receiverProvince},receiver_city=#{receiverCity},receiver_district=#{receiverDistrict},receiver_address=#{receiverAddress} where receiver_id=#{receiverId}")
    public int updateReceiver(@Param("receiverName")String receiverName,@Param("receiverPhone")String receiverPhone,@Param("receiverProvince")String receiverProvince,@Param("receiverCity")String receiverCity,@Param("receiverDistrict")String receiverDistrict,@Param("receiverAddress")String receiverAddress,@Param("receiverId")int receiverId);
    
    @Select("select * from receiver where receiver_province like concat('%',#{receiverProvince},'%')")
    public List<Receiver> queryProvince(int pageNum,int pageSize,@Param("receiverProvince")String receiverProvince);
    
}