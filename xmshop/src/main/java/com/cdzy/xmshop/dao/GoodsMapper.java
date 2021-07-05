package com.cdzy.xmshop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.cdzy.xmshop.entity.Goods;

@Repository
public interface GoodsMapper {
	
    @Select("select * from goods")
    public List<Goods> getAllGoods(int pageNum,int pageSize);
    
    @Select("select * from goods")
    public List<Goods> getAllGoodss();
    
    @Select("select * from goods where id=#{id}")
    public Goods selectById(int id);
    
    @Insert("insert into goods(cover,name,price,intro,color,edition,quantity) values(#{cover},#{name},#{price},#{intro},#{color},#{edition},#{quantity})")
    public int insertGoods(Goods goods);
    
    @Update("update goods set price=#{price},quantity=#{quantity},color=#{color},edition=#{edition} where id=#{id}")
    public int updateGoods(Goods goods);
    
    @Update("update goods set quantity=quantity-#{quantity} where id=#{id}")
    public int updateQuantity(@Param("quantity")int quantity,@Param("id")int id);
    
    @Delete("delete from goods where id=#{id}")
    public int deleteGoods(int id);
    
    @Select("select * from goods where name like concat('%',#{name},'%')")
    public List<Goods> queryName(int pageNum,int pageSize,@Param("name")String name);
    
}