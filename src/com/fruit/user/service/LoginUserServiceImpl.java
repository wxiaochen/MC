package com.fruit.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fruit.entity.Logininfo;
import com.fruit.user.dao.LoginUserDaoImpl;

@Service
@Transactional(readOnly = true)
public class LoginUserServiceImpl {

	@Resource
	private LoginUserDaoImpl loginUserDaoImpl;

	public Logininfo login(String name, String password) {
		return this.loginUserDaoImpl.findByNameAndPwd(name, password);
	}
	
	@Transactional(readOnly=true)
	public Logininfo getLogininfo(String loginName){
		return this.loginUserDaoImpl.getLogininfo(loginName);
	}
	
	public void updateLogininfo(Logininfo li){
		Logininfo l = this.loginUserDaoImpl.getLogininfo(li.getLoginName());
		
		l.setPassword(li.getPassword());
		
		this.loginUserDaoImpl.updateLogininfo(l);
	}
	
}
