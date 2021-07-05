package com.cdzy.xmshop.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.cdzy.xmshop.entity.OrdersVO;
import com.cdzy.xmshop.service.OrdersService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/orders")	//相当于http://127.0.0.1:8080/xmshop/orders
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	@RequestMapping("/getAllOrders")
	public String getAllOrders(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, Model model){
		List<OrdersVO> list = ordersService.getAllOrders(pageNum, pageSize);
		PageInfo<OrdersVO> pageInfo = new PageInfo<OrdersVO>(list);
		model.addAttribute("pageInfos",pageInfo);
		return "ordersManager";
	}
	
	@RequestMapping(value="/queryReName",method=RequestMethod.GET)
	public String queryReName(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize,@RequestParam("receiverName")String receiverName,HttpSession session){
		List<OrdersVO> list1 = ordersService.queryReName(pageNum, pageSize, receiverName);
		PageInfo<OrdersVO> pageInfo = new PageInfo<OrdersVO>(list1);
		if (list1!=null) {
			session.setAttribute("pageInfos",pageInfo);
			return "ordersManager";
		} else {
			return "forward:/orders/getAllOrders";
		}
	}
}
