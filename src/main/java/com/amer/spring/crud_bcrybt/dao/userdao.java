package com.amer.spring.crud_bcrybt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import com.amer.spring.crud_bcrybt.entity.user;

public interface userdao extends JpaRepository<user, String> {

	user findByUserName(String username);

	

}
