package com.fruit.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fruit.entity.Userinfo;
import com.fruit.user.dao.PersonalDaoImpl;

@Service
@Transactional(readOnly=true)
public class PersonalServiceImpl {
	
	@Resource
	private PersonalDaoImpl personalDaoImpl;
	
	public Userinfo getUserinfo(String loginName){
		return this.personalDaoImpl.findByLoginName(loginName);		
	}
			
}
