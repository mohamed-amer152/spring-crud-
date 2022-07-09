package com.amer.spring.crud_bcrybt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.amer.spring.crud_bcrybt.entity.roles;
import com.amer.spring.crud_bcrybt.entity.user;
import com.amer.spring.crud_bcrybt.service.roleservice;
import com.amer.spring.crud_bcrybt.service.userservice;

@Controller
public class logincontroller {
	
	@Autowired
	private userservice uservice ;
	
	@Autowired
	private roleservice rservice ;
	
	@GetMapping("/login")
	public String showlog()
	{
		return "view/login";
	}
	
	
	@GetMapping("/accessdenied")
	public String accessdenied()
	{
		return "view/accessdenied";
	}
	
	@PostMapping("/reg")
	public String showreg(Model model)
	{
		user us = new user();
		roles rl = new roles();
		model.addAttribute("user", us);
		model.addAttribute("authority", rl);
		return "view/login";
	}
	
	@GetMapping("/saveuser")
	public String saveuser(@ModelAttribute user us ,@ModelAttribute roles rl)
	{
		user u = uservice.search(us.getUsername());
		if (u == null ) {
			uservice.save(us);
			rservice.save(rl);
			return "view/login";
		} else {
			return "error";
		}
		
	}
	

}
