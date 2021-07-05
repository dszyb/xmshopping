package com.cdzy.xmshop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.cdzy.xmshop.entity.Orders;
import com.cdzy.xmshop.entity.OrdersVO;

@Repository
public interface OrdersMapper {
	
	@Select("select count(*) from orders")
	public int selectCountOrders();
	
	@Select("select count(*) from orders where status=#{status}")
	public int selectCountOrdersByStatus(int status);
	
	@Select("select count(*) from orders where users_id=#{usersId}")
	public int selectCountOrdersByUsersId(@Param("usersId")int usersId);
	
	@Select("select o.orders_id,o.total,o.`status`,r.receiver_name,r.receiver_phone,o.create_time from orders o,receiver r where o.receiver_id=r.receiver_id")
	public List<OrdersVO> getAllOrders(int pageNum,int pageSize);
	
	@Select("select o.orders_id,o.total,o.`status`,o.create_time,o.users_id,o.receiver_id,r.receiver_name,r.receiver_phone,r.receiver_address "+
	"from orders o join receiver r on o.receiver_id=r.receiver_id where o.users_id=#{usersId}")
	public List<Orders> getOrdersByUId(int usersId);
	
	@Insert("insert into orders(orders_id,total,status,create_time,users_id,receiver_id) values(#{ordersId},#{total},#{status},#{createTime},#{usersId},#{receiverId})")
	public int insertOrders(Orders orders);
	
	@Select("select o.*,r.receiver_name,r.receiver_phone,r.receiver_province,r.receiver_city,r.receiver_district,r.receiver_address "+
	"from orders o join receiver r on o.receiver_id=r.receiver_id where o.orders_id=#{ordersId}")
	public Orders selectByOId(String ordersId);
	
	@Update("update orders set status=#{status} where orders_id=#{ordersId}")
	public int updateOrdersStatus(@Param("status")int status,@Param("ordersId")String ordersId);
	
	@Delete("delete from orders where orders_id=#{ordersId}")
	public int deleteOrders(String ordersId);
	
	@Select("select * from orders o join receiver r on o.receiver_id=r.receiver_id where r.receiver_name like concat('%',#{receiverName},'%')")
	public List<OrdersVO> queryReName(int pageNum,int pageSize,@Param("receiverName")String receiverName);
	
}