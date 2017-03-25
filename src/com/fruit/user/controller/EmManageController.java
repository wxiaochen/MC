package com.fruit.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fruit.entity.Fruit;
import com.fruit.entity.Userinfo;
import com.fruit.framework.Page;
import com.fruit.user.service.EmManageServiceImpl;

@Controller
@RequestMapping("user")
public class EmManageController {
	
	@Resource
	private EmManageServiceImpl emManageServiceImpl;
	
	@RequestMapping("add1")
	public String add(Userinfo u){
		this.emManageServiceImpl.addUser(u);
		return "employee";
	}
	
	@RequestMapping(value="edit1",method=RequestMethod.GET)
	public String toEdit(@RequestParam("userNumber") String userNumber,HttpServletRequest request){
		Userinfo u = this.emManageServiceImpl.getUser(userNumber);
		request.setAttribute("user", u);
		request.setAttribute("action", "edit");
		return "user/form";
	}
	
	@RequestMapping(value="edit1",method=RequestMethod.POST)
	public String edit(Userinfo u,HttpServletRequest request){
		this.emManageServiceImpl.editUserinfo(u);
		return "redirect:list";
	}
	
	@RequestMapping(value="delete1",method=RequestMethod.GET)
	public String delete(@RequestParam("userNumber") String userNumber,HttpServletRequest request){
		this.emManageServiceImpl.dropUser(userNumber);
		return "redirect:list";
	}
	
	@RequestMapping(value="list1")
	public String list(@RequestParam(name="pageNum",defaultValue="1")int pageNum,
				@RequestParam(name="searchParam",defaultValue="")String searchParam,HttpServletRequest request,Model model){
		
		Page<Userinfo> page;
		if (searchParam == null || searchParam.equals("")) {
			page = this.emManageServiceImpl.listUser(pageNum, 6, null);
		}else {
			page = this.emManageServiceImpl.listUser(pageNum, 6, new Object[]{searchParam});
		}
		
		request.setAttribute("page1", page);
		request.setAttribute("searchParam", searchParam);
		return "employee";
	}
}
