package com.fruit.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fruit.entity.Fruit;
import com.fruit.entity.Logininfo;
import com.fruit.entity.Power;
import com.fruit.user.service.LoginUserServiceImpl;
import com.fruit.user.service.PackUpMenuServiceImpl;
import com.google.gson.Gson;

@Controller
@RequestMapping("loginuser")
public class LoginUserController {

	@Resource
	private LoginUserServiceImpl loginUserServiceImpl;

	@RequestMapping("login")
	public String login(@RequestParam("loginName") String name, @RequestParam("password") String password,
			HttpSession session) {

		Logininfo li = this.loginUserServiceImpl.login(name, password);

		if (li != null) {

			// 将该用户的权限名称显示在页面右上角
			session.setAttribute("loginRole", li.getRole().getRoleName());
			session.setAttribute("loginName", name);
			
			//将该用户的权限封装成一个map
			HashMap<Power, List> menus = PackUpMenuServiceImpl.packUpMenu(li);			
			
			//将菜单作为参数传递给product.jsp页面
			session.setAttribute("menus", menus);
			return "index";
		} else {
			return "login";
		}
	}
	
	@RequestMapping("update")
	public String toUpdate(@RequestParam("oldpwd")String oldpwd,
			@RequestParam("newpwd")String newpwd,@RequestParam("rnewpwd")String rnewpwd,HttpServletRequest request){
		
		String loginName = request.getParameter("loginName");
		
		Logininfo l = this.loginUserServiceImpl.getLogininfo(loginName);
		
		if (newpwd.equals(rnewpwd)) {
			Logininfo li = new Logininfo();
			li.setPassword(newpwd);
			li.setLoginName(l.getLoginName());
			li.setRole(l.getRole());
			this.loginUserServiceImpl.updateLogininfo(li);
			return "product";
		}else {
			return "updatePwd";
		}
	}
	
	
	@RequestMapping("checkname")
	@ResponseBody
	public String checkNameExist(HttpServletRequest request){
		String name = request.getParameter("loginName");
		List<Logininfo>list = new ArrayList<Logininfo>();
		Logininfo l1 = new Logininfo();
		l1.setLoginName("aa");
		l1.setPassword("11");
		Logininfo l2 = new Logininfo();
		l2.setLoginName("bb");
		l2.setPassword("22");
		list.add(l1);
		list.add(l2);
		Gson gson = new Gson();
		return gson.toJson(list);
	}

}
