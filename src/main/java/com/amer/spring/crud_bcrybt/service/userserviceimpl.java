package com.amer.spring.crud_bcrybt.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.amer.spring.crud_bcrybt.dao.userdao;
import com.amer.spring.crud_bcrybt.entity.roles;
import com.amer.spring.crud_bcrybt.entity.user;

@Service
public class userserviceimpl implements userservice {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private roleservice rs;
	
	
	@Autowired
	private userdao repo;
	@Override
	public void save(user u) {
	  u.setPassword(passwordEncoder.encode(u.getPassword()));	
      repo.save(u);
	}

	@Override
	public user search(String username) {
		Optional<user> u = repo.findById(username);
		user result ;
		if (u.isPresent()) {
			result = u.get();
			return result ;
		} else {
			return null;
		}
		
	}

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user user1 = repo.findByUserName(username);
				
		if (user1 == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user1.getUsername(), user1.getPassword(),
				mapRolesToAuthorities(rs.search(username)));
				
	}
	
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<com.amer.spring.crud_bcrybt.entity.roles> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList());
	}
	
	
	
	
	
	
	
	
}
