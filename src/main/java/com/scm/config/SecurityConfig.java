package com.scm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
  //user create and login using java code with in memory service
  //spring uses user detail service whenever you login it uses userdetailservice to fetch user
 // service has a method load user by user name then matches fethced user password and current user password
	@Bean
	public UserDetailsService userDetailsService(){
		// inMemoryUserDetailsManager is implementation of usersDeatailsService
		UserDetails user1=User
				.withDefaultPasswordEncoder()
				.username("admin")
				.password("1234")
				.roles("ADMIN","USER")
				.build();
		UserDetails user2=User
				.withDefaultPasswordEncoder()
				.username("user1234")
				.password("user1234")
//				.roles()
				.build();
		var inMemoryUserDetailsManager=new InMemoryUserDetailsManager(user1,user2);
		return inMemoryUserDetailsManager;
		
		
	} 
}
