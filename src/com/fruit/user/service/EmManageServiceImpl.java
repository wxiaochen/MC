package com.fruit.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fruit.entity.Userinfo;
import com.fruit.framework.Page;
import com.fruit.user.dao.EmManageDaoImpl;

@Service
@Transactional(readOnly=false)
public class EmManageServiceImpl {
	
	@Resource
	private EmManageDaoImpl emManageDaoImpl;
	
	public void addUser(Userinfo u){
		this.emManageDaoImpl.saveUserinfo(u);
	}
	
	@Transactional(readOnly=true)
	public Page<Userinfo>listUser(int pageNum,int pageSize,Object[]params){
		return this.emManageDaoImpl.findUserinfo(pageNum, pageSize, params);
	}
	
	@Transactional(readOnly=true)
	public Userinfo getUser(String userNumber){
		return this.emManageDaoImpl.getUserinfo(userNumber);
	}
	
	public void editUserinfo(Userinfo u){
		Userinfo ui = this.emManageDaoImpl.getUserinfo(u.getUserNumber());
		ui.setUserNumber(u.getUserNumber());
		ui.setLoginName(u.getLoginName());
		ui.setUserName(u.getUserName());
		ui.setEntryTime(u.getEntryTime());
		ui.setSalary(u.getSalary());
		ui.setTel(u.getTel());
		this.emManageDaoImpl.updateUserinfo(ui);
	}
	
	//删除员工信息
	public void dropUser(String userNumber){
		this.emManageDaoImpl.deleteUserinfo(userNumber);
	}
}
