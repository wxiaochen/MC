package com.fruit.user.dao;

import org.springframework.stereotype.Repository;

import com.fruit.entity.Logininfo;
import com.fruit.framework.BaseDao;

@Repository
public class LoginUserDaoImpl extends BaseDao<Logininfo, String> {

	/**验证用户名和密码是否正确
	 * 
	 * @param loginName
	 * @param password
	 * @return 一个用户的对象
	 */
	public Logininfo findByNameAndPwd(String loginName, String password) {

		try {
			return super.findOne("from Logininfo li where li.loginName=? and li.password=?",new Object[] { loginName, password });
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	//根据主键得到某个Logininfo对象
	public Logininfo getLogininfo(String loginName){
		try {
			Logininfo li = this.get(loginName);
			return li;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public void updateLogininfo(Logininfo li){
		try {
			this.update(li);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
