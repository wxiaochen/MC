package com.fruit.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Power")
public class Power {
	private String powerId;
	private String powerName;
	private String powerUrl;
	private String parentId;
	private Set<Role> roles = new HashSet<Role>(0);
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getPowerId() {
		return powerId;
	}

	public void setPowerId(String powerId) {
		this.powerId = powerId;
	}

	public String getPowerName() {
		return powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

	public String getPowerUrl() {
		return powerUrl;
	}

	public void setPowerUrl(String powerUrl) {
		this.powerUrl = powerUrl;
	}
	
	@ManyToMany(mappedBy="powers")
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
}
