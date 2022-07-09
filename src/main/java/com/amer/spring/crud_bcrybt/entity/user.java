package com.amer.spring.crud_bcrybt.entity;

import java.util.Collection;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class user {

	
	
	@Id
	@Column(name = "username")
	private String userName ;
	
	@Column(name = "password")
	private String password ;
	
	@Column(name = "enabled")
	private int enabled=1 ;


	
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	
	public user(String username, String password, int enabled) {
		this.userName = username;
		this.password = password;
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "user [username=" + userName + ", password=" + password + ", enabled=" + enabled + "]";
	}
	
	public user() {
	}
	
	
}
