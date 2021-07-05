package com.cdzy.xmshop.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.cdzy.xmshop.entity.Carts;
import com.cdzy.xmshop.service.CartsService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/carts")	//http://127.0.0.1:8080/xmshop/carts
public class CartsController {
	
	@Autowired
	private CartsService cartsService;
	
	/**
	 * 分页查询购物车全部信息
	 * @param pageNum
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping("/getAllCarts")
	public String getAllCarts(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, Model model){
		List<Carts> list = cartsService.getAllCarts(pageNum, pageSize);
		PageInfo<Carts> pageInfo = new PageInfo<Carts>(list);
		model.addAttribute("pageInfos",pageInfo);
		return "cartsManager";
	}
	
	/**
	 * 根据商品ID进行模糊查询
	 * @param pageNum
	 * @param pageSize
	 * @param goodsId
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/queryGId",method=RequestMethod.GET)
	public String queryByGId(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize,@RequestParam("goodsId")int goodsId,HttpSession session){
		List<Carts> list1 = cartsService.queryByGId(pageNum, pageSize, goodsId);
		PageInfo<Carts> pageInfo = new PageInfo<Carts>(list1);
		if (list1!=null) {
			session.setAttribute("pageInfos",pageInfo);
			return "cartsManager";
		} else {
			return "forward:/carts/getAllCarts";
		}
	}

}
