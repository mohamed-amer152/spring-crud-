package com.amer.spring.crud_bcrybt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="authorities")
public class roles {
	
	@Id
	@Column(name = "username")
	private String username ;
	
	@Column(name = "authority")
	private String authority ;
	
	public roles() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority =authority;
	}

	@Override
	public String toString() {
		return "roles [username=" + username + ", authority=" + authority + "]";
	}

	public roles(String username, String authority) {
		this.username = username;
		this.authority = authority;
	}
	
	

}
