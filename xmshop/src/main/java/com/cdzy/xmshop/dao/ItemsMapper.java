package com.cdzy.xmshop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.cdzy.xmshop.entity.Items;

@Repository
public interface ItemsMapper {
    
	@Select("select * from items where orders_id=#{ordersId}")
	public List<Items> selectList(String ordersId);
	
	@Insert({"<script>",
		"insert into items(price,amount,orders_id,goods_id) values",
		"<foreach collection='itemsList' item='item' index='index' separator=','>",
		"(#{item.price},#{item.amount},#{item.ordersId},#{item.goodsId})",
		"</foreach>","</script>"})
	public int insertItems(@Param("itemsList")List<Items> itemsList);
	
}