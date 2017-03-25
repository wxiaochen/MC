package com.fruit.user.dao;

import org.springframework.stereotype.Repository;

import com.fruit.entity.Userinfo;
import com.fruit.framework.BaseDao;
import com.fruit.framework.Page;

@Repository
public class EmManageDaoImpl extends BaseDao<Userinfo, String> {
	
	//增加员工
	public void saveUserinfo(Userinfo ui){
		try {
			this.save(ui);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//查找员工列表
	public Page<Userinfo> findUserinfo(int pageNum, int pageSize,Object[]params){
		String hql;
		if (params != null && params.length >0) {
			hql = "from Userinfo u where u.userNumber like ?";
			
			params[0] = "%" +params[0]+"%";
		}else {
			hql = "from Userinfo";
		}
		
		try {
			Page<Userinfo> page = new Page<Userinfo>();
			page.setCurrentPageNum(pageNum);
			page.setPageSize(pageSize);
			page = this.findByPage(pageNum, pageSize, hql, params);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//根据主键得到某一个员工对象
	public Userinfo getUserinfo(String userNumber){
		try {
			Userinfo u = this.get(userNumber);
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//更新某个员工信息
	public void updateUserinfo(Userinfo u){
		try {
			this.update(u);
			u.getLogininfo().setPassword("123");
			u.getLogininfo().getRole().setRoleId("1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//根据员工的工号删除某个员工信息
	public void deleteUserinfo(String userNumber){
		try {
			this.delete(userNumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
