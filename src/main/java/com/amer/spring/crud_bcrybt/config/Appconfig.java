package com.amer.spring.crud_bcrybt.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.amer.spring.crud_bcrybt.service.userservice;

@Configuration
@EnableWebSecurity
public class Appconfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private DataSource datasource;
	@Lazy
	@Autowired
	private userservice uservice ;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.jdbcAuthentication().dataSource(datasource);
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/student/search").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
				.antMatchers("/student/list").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
				.antMatchers("/student/saveform").hasRole("MANAGER").antMatchers("/student/save").hasRole("MANAGER")
				.antMatchers("/student/updateform").hasRole("MANAGER").antMatchers("/student/delete").hasRole("ADMIN")
				.antMatchers("/resources/**").permitAll().and().formLogin().loginPage("/login")
				.loginProcessingUrl("/auth").permitAll().and().logout().permitAll().and().exceptionHandling()
				.accessDeniedPage("/accessdenied");

	}

	
	
	//beans
		//bcrypt bean definition
		@Bean
		public BCryptPasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

		//authenticationProvider bean definition
		@Bean
		public DaoAuthenticationProvider authenticationProvider() {
			DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
			auth.setUserDetailsService(uservice); //set the custom user details service
			auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
			return auth;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
