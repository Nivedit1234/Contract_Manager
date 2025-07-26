package com.scm.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.scm.entities.User;
import com.scm.forms.UserForm;
// import com.scm.helpers.Message;
// import com.scm.helpers.MesssageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


	@Controller
	public class PageController {
	  
		@Autowired
		private UserService userService;
		
		@GetMapping("/")
	  public String basePage(Model model) {
	       System.out.println("Home page handler");
	       model.addAttribute("name","Nivedit Indras");
		  return "home";
	  }
		
		@GetMapping("/home")
	  public String home(Model model) {
	       System.out.println("Home page handler");
	       model.addAttribute("name","Nivedit Indras");
		  return "home";
	  }

	  @GetMapping("/about")
	  public String about(Model model) {
	       System.out.println("about page handler");
		  return "about";
	  }


	  @GetMapping("/services")
	  public String services(Model model) {
	       System.out.println("services page handler");
		  return "services";
	  }

	  @GetMapping("/register")
	  public String register(Model model) {
		   UserForm userForm=new UserForm();
		   //userForm obj will be going to register page a black object is going to register page
		   //can also add default data
		   model.addAttribute("userForm", userForm);
		   // userForm.setName("Nivedit");
		   userForm.setAbout("this is the about section of me");
	       System.out.println("register page handler");
		  return "register";
	  }

	   @GetMapping("/login")
	  public String login(Model model) {
	       System.out.println("login page handler");
		  return "login";
	  }

	   @GetMapping("/contact")
	  public String contact(Model model) {
	       System.out.println("contact page handler");
		  return "contact";
	  }
	  @PostMapping("/do-register")
	   //userForm object will be created and all the data coming from model attribute will be put into it UserForm  
	  public String doRegister(@Valid @ModelAttribute UserForm userForm,BindingResult rBinding,HttpSession session){
        
		if(rBinding.hasErrors())
		{
			return "register";
		}

		//fetch form data
		 System.out.println(userForm);
		//validate form data
		
		//save to database
        		
		//userForm ---> User
        // User user=User.builder()
		// .name(userForm.getName())
		// .email(userForm.getEmail())
		// .password(userForm.getPassword())
		// .about(userForm.getAbout())
		// .phoneNumber(userForm.getPhoneNumber())
		// .profilePic(null)
		// .build();
        // User savedUser=userService.saveUser(user);

		User user=new User();
		user.setName(userForm.getName());
		user.setEmail(userForm.getEmail());
		user.setPassword(userForm.getPassword());
		user.setAbout(userForm.getAbout());
		user.setPhoneNumber(userForm.getPhoneNumber());
		user.setProfilePic(null);
		 User savedUser=userService.saveUser(user);

		System.out.println("user saved this time: ");

		
		//message "Registration Successfull"

        // Message messageobj=Message.builder()
		// .content("Registration Successful")
		// .type(MesssageType.green)
		// .build();

		// session.setAttribute("message", messageobj);


		//redirect to register page
		System.out.println("Processing Registration");
		return "redirect:/register";

	  }
	}

