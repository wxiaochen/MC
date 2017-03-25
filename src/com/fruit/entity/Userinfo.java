package com.fruit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="Userinfo")
public class Userinfo {
	private String userNumber;
	private String loginName;
	private String userName;
	private String entryTime;
	private Integer salary;
	private String tel;
	private Logininfo logininfo;
	
	@Id
	@GenericGenerator(name="foreignkey",strategy="foreign",parameters=@Parameter(value="Logininfo",name="property"))
	@GeneratedValue(generator="foreignkey")
	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@OneToOne
	@PrimaryKeyJoinColumn
	public Logininfo getLogininfo() {
		return logininfo;
	}

	public void setLogininfo(Logininfo logininfo) {
		this.logininfo = logininfo;
	}

}
