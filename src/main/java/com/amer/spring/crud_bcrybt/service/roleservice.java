package com.amer.spring.crud_bcrybt.service;

import java.util.List;

import com.amer.spring.crud_bcrybt.entity.roles;

public interface roleservice {
	
	public void save (roles r);
	
	public List<roles> search(String username);

}
