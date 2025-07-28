package com.scm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
  //user create and login using java code with in memory service
  //spring uses user detail service whenever you login it uses userdetailservice to fetch user
 // service has a method load user by user name then matches fethced user password and current user password
//	@Bean
//	public UserDetailsService userDetailsService(){
//		 inMemoryUserDetailsManager is implementation of usersDeatailsService
//		UserDetails user1=User
//				.withDefaultPasswordEncoder()
//				.username("admin")
//				.password("1234")
//				.roles("ADMIN","USER")
//				.build();
//		UserDetails user2=User
//				.withDefaultPasswordEncoder()
//				.username("user1234")
//				.password("user1234")
////				.roles()
//				.build();
//		var inMemoryUserDetailsManager=new InMemoryUserDetailsManager(user1,user2);
//		return inMemoryUserDetailsManager; 
//		
//	} 
	
	 //DaoAuthentication provider has all the methods with which i can register my service
	 //spring recommends making userDetails for all methods of users
	// so we make our User class implements UserDetails so we can its obj(User) in its place;  
	
	@Autowired
	private SecurityCustomUserDetailService userDetailsService;
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		//user details provider object
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		//password encoder object
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}

}
