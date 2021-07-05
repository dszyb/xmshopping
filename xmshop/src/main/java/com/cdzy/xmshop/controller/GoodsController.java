package com.cdzy.xmshop.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.cdzy.xmshop.entity.Goods;
import com.cdzy.xmshop.service.GoodsService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/goods")	//相当于http://127.0.0.1:8080/xmshop/goods
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	/**
	 * 分页查询所有商品
	 * @param pageNum 第几页
	 * @param pageSize 每页多少条
	 * @param model
	 * @return
	 */
	@RequestMapping("/getAllGoods")
    public String getAllGoods(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, Model model){
        List<Goods> list = goodsService.getAllGoods(pageNum, pageSize);
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(list);
        model.addAttribute("pageInfos",pageInfo);
        return "goodsManager";
    }
	
	/**
	 * 根据id查询商品信息
	 * @param id 商品id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getGoodsById/{id}",method=RequestMethod.GET)
	public String selectById(@PathVariable("id")int id,HttpSession session){
		Goods goods = goodsService.selectById(id);
		session.setAttribute("goodss",goods);
		return "forward:getAllGoods";
	}
	
	/**
	 * 添加商品
	 * @param cover 商品图片
	 * @param goods
	 * @return
	 * @throws Exception 异常
	 */
	@RequestMapping(value="/insertGoods",method=RequestMethod.POST)
	public String insertGoods(Goods goods,MultipartFile file,HttpServletRequest request) throws Exception{
		String realPath=request.getServletContext().getRealPath("upload");
		String time=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String extension=FilenameUtils.getExtension(file.getOriginalFilename());
		String newFileName=time;
		System.out.println("路径:"+realPath+"/"+newFileName+"."+extension);
		file.transferTo(new File(realPath+"/"+newFileName+"."+extension));
		goods.setCover("../upload/"+newFileName+"."+extension);
		int result=goodsService.insertGoods(goods);
		if (result==1) {
			System.out.println(goods);
			return "redirect:getAllGoods";
		} else {
			return "redirect:getAllGoods";
		}
	}
	
	/**
	 * 修改商品
	 * @param goods
	 * @return
	 * @throws Exception 异常
	 */
	@RequestMapping(value="/updateGoods",method=RequestMethod.POST)
	public String updateGoods(Goods goods) throws Exception{
		int result=goodsService.updateGoods(goods);
		if (result==1) {
			System.out.println(goods);
			return "redirect:/goods/getAllGoods";
		} else {
			return "redirect:/goods/getAllGoods";
		}
	}
	
	/**
	 * 根据id删除商品信息
	 * @param id 商品id
	 * @return
	 */
	@RequestMapping(value="/deleteGoodsById/{id}",method=RequestMethod.GET)
	public String deleteGoods(@PathVariable("id")int id){
		System.out.println(id);
		int result=goodsService.deleteGoods(id);
		if (result==1) {
			return "redirect:/goods/getAllGoods";
		} else {
			return "redirect:/goods/getAllGoods";
		}	
	}
	
	/**
	 * 根据商品名称进行模糊查询
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/queryName",method=RequestMethod.GET)
	public String queryName(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize,@RequestParam("name")String name,HttpSession session){
		System.out.println(name);
		List<Goods> list1 = goodsService.queryName(pageNum, pageSize, name);
		System.out.println(list1);
		PageInfo<Goods> pageInfo = new PageInfo<Goods>(list1);
		if (list1 != null) {
			session.setAttribute("pageInfos",pageInfo);
			return "goodsManager";
		} else {
			return "forward:/goods/getAllGoods";
		}
	}
	
}
