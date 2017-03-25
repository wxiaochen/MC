package com.fruit.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fruit.entity.Userinfo;
import com.fruit.user.service.PersonalServiceImpl;

@Controller
@RequestMapping("personal")
public class PersonalController {

	@Resource
	private PersonalServiceImpl personalServiceImpl;

	@RequestMapping("select")
	public String select(@RequestParam("loginName") String loginName, HttpSession session) {
		Userinfo ui = this.personalServiceImpl.getUserinfo(loginName);

		session.setAttribute("userinfo", ui);
		return "personal";

	}

}
