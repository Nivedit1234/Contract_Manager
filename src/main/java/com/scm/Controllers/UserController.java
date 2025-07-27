package com.scm.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;


@Controller
@RequestMapping("/user")
public class UserController {
     
    //user dashboard page

    @GetMapping("/dashboard")
    public String userDashBoard(Model model) {
        System.out.println("user dashboard running");
        return "user/dashboard";
    }

    //user profile page
    @GetMapping("/profile")
    public String userProfile(Model model) {
        System.out.println("user profile running");
        return "user/profile";
    }
    //user add contacts page
     
    //user view contacts

    //user edit contacts


    //user delete contacts
    
}
