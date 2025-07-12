package com.scm.Controllers;

import javax.management.AttributeValueExp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.engine.AttributeName;


	@Controller
	public class PageController {
	  
		@RequestMapping("/")
	  public String basePage(Model model) {
	       System.out.println("Home page handler");
	       model.addAttribute("name","Nivedit Indras");
		  return "home";
	  }
		
		@RequestMapping("/home")
	  public String home(Model model) {
	       System.out.println("Home page handler");
	       model.addAttribute("name","Nivedit Indras");
		  return "home";
	  }

	  @RequestMapping("/about")
	  public String about(Model model) {
	       System.out.println("about page handler");
		  return "about";
	  }


	  @RequestMapping("/services")
	  public String services(Model model) {
	       System.out.println("services page handler");
		  return "services";
	  }

	  @RequestMapping("/register")
	  public String register(Model model) {
	       System.out.println("register page handler");
		  return "register";
	  }

	   @RequestMapping("/login")
	  public String login(Model model) {
	       System.out.println("login page handler");
		  return "login";
	  }

	   @RequestMapping("/contact")
	  public String contact(Model model) {
	       System.out.println("contact page handler");
		  return "contact";
	  }
	}

