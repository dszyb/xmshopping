package com.cdzy.xmshop.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.cdzy.xmshop.entity.Users;
import com.cdzy.xmshop.service.UsersService;
import com.cdzy.xmshop.utils.MD5Util;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/users")	//相当于http://127.0.0.1:8080/xmshop/users
public class UsersController {
	@Autowired
    private UsersService usersService;
    
	/**
	 * 分页查询所有用户信息
	 * @param pageNum 第几页
	 * @param pageSize 每页条数
	 * @param model
	 * @return
	 */
    @RequestMapping("/getAllUsers")
    public String getAllUsers(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, Model model){
        List<Users> list = usersService.getAllUsers(pageNum, pageSize);
        PageInfo<Users> pageInfo = new PageInfo<Users>(list);
        model.addAttribute("pageInfos",pageInfo);
        return "usersManager";
    }
    
    /**
     * 添加用户
     * @param users
     * @return
     */
    @PostMapping("/insertUsers")
    public String insertUsers(Users users){
    	String md5Pwd=MD5Util.strToMd5(users.getPassword());
    	users.setPassword(md5Pwd);
    	int result = usersService.insertUsers(users);
    	if (result==1) {
			return "redirect:/users/getAllUsers";
		} else {
			return "redirect:/users/getAllUsers";
		}
    }
    
    /**
     * 修改用户
     * @param users
     * @return
     */
    @PostMapping("/updateUsers")
    public String updateUsers(Users users){
    	int result = usersService.updateUsers(users);
    	if (result==1) {
			return "redirect:/users/getAllUsers";
		} else {
			return "redirect:/users/getAllUsers";
		}
    }
    
    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping("/deleteUsersById/{id}")
    public String deleteUsers(@PathVariable("id")int id){
    	int result = usersService.deleteUsers(id);
    	if (result==1) {
			return "redirect:/users/getAllUsers";
		} else {
			return "redirect:/users/getAllUsers";
		}
    }
    
    /**
     * 根据地址进行模糊查询
     * @param pageNum
     * @param pageSize
     * @param address
     * @param session
     * @return
     */
    @RequestMapping(value="/queryAddress",method=RequestMethod.GET)
    public String queryAddress(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize,@RequestParam("address")String address,HttpSession session){
    	List<Users> list1=usersService.queryAddress(pageNum, pageSize, address);
    	PageInfo<Users> pageInfo = new PageInfo<Users>(list1);
    	if (list1!=null) {
    		session.setAttribute("pageInfos",pageInfo);
    		return "usersManager";
		} else {
			return "forward:/users/getAllUsers";
		}
    }
	
}
