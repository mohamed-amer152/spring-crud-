package com.amer.spring.crud_bcrybt.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.amer.spring.crud_bcrybt.entity.user;

public interface userservice extends UserDetailsService{
	
	public void save (user u);
	
	public user search(String username);

}
