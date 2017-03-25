package com.fruit.user.dao;

import org.springframework.stereotype.Repository;

import com.fruit.entity.Logininfo;
import com.fruit.entity.Userinfo;
import com.fruit.framework.BaseDao;

@Repository
public class PersonalDaoImpl extends BaseDao<Userinfo, String> {

	/**
	 * 根据登录名查找该用户的实际信息
	 * 
	 * @param loginName
	 * @return Userinfo的一个对象
	 */
	public Userinfo findByLoginName(String loginName) {
		try {
			return super.findOne("from Userinfo u where u.loginName=?", new Object[] { loginName });
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
