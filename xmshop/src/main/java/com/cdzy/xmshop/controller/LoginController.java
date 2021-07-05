package com.cdzy.xmshop.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cdzy.xmshop.service.AdminsService;

@Controller
@RequestMapping("/logins") //相当于http://127.0.0.1:8080/xmshop/logins
public class LoginController {
	
	@Autowired
    private AdminsService adminsService;

	@RequestMapping("/toLogin")
    public String toLogin(){
	    return "login";
    }

	@RequestMapping("/login")
    public String login(HttpSession session,String username, String password, Model model){
	    boolean flag=adminsService.Login(username, password);
	    if (flag){
	        session.setAttribute("userLoginInfo",username);
	        model.addAttribute("adminName",username);
	        return "main";
        }else{
            model.addAttribute("error","用户名或密码错误");
            return "login";
        }
    }

    @RequestMapping("/LoginOut")
    public String loginout(HttpSession session){
	    session.removeAttribute("userLoginInfo");
	    return "redirect:/logins/toLogin";
    }
}
