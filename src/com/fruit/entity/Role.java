package com.fruit.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Role")
public class Role {
	private String roleId;
	private String roleName;
	private Set<Power> powers = new HashSet<Power>(0);
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(
			name="Rolepower",
			joinColumns={@JoinColumn(name="roleId")},
			inverseJoinColumns={@JoinColumn(name="powerId")}
			)
	public Set<Power> getPowers() {
		return powers;
	}

	public void setPowers(Set<Power> powers) {
		this.powers = powers;
	}

}
