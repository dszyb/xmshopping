package com.cdzy.xmshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.cdzy.xmshop.entity.Receiver;
import com.cdzy.xmshop.service.ReceiverService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/receiver")
public class ReceiverController {
	@Autowired
	private ReceiverService receiverService;
	
	@RequestMapping("/getAllReceiver")
	public String getAllReceiver(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, Model model){
		List<Receiver> list = receiverService.getAllReceiver(pageNum, pageSize);
		PageInfo<Receiver> pageInfo = new PageInfo<Receiver>(list);
		model.addAttribute("pageInfos",pageInfo);
		return "receiverManager";
	}
	
	@RequestMapping(value="/queryProvince",method=RequestMethod.GET)
	public String queryProvince(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize,@RequestParam("receiverProvince")String receiverProvince,HttpSession session){
		List<Receiver> list1 = receiverService.queryProvince(pageNum, pageSize, receiverProvince);
		PageInfo<Receiver> pageInfo = new PageInfo<Receiver>(list1);
		if (list1!=null) {
			session.setAttribute("pageInfos",pageInfo);
			return "receiverManager";
		} else {
			return "forward:/receiver/getAllReceiver";
		}
	}
	
}
