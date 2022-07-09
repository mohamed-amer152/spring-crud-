package com.amer.spring.crud_bcrybt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amer.spring.crud_bcrybt.dao.rolesdao;
import com.amer.spring.crud_bcrybt.entity.roles;
@Service
public class roleserviceimpl implements roleservice {

	@Autowired
	private rolesdao repo ;
	
	@Override
	public void save(roles r) {
       repo.save(r);
	}

	@Override
	public List<roles> search(String username) {
		Optional<roles> rlist = repo.findById(username);
		List<roles> rl = new ArrayList<roles>();
		rl.add(rlist.get());
		return rl;
	}

}
