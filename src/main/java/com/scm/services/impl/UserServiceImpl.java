package com.scm.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.swing.Spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.scm.entities.User;
import com.scm.helpers.AppConstants;
import com.scm.helpers.ResourceNotFoundException;
import com.scm.repositories.UserRepo;
import com.scm.services.UserService;

//The @Service annotation in Spring is used to mark a class as a service layer component,
 //meaning it holds business logic and acts as a bridge between the controller and repository/DAO layers.
@Service
public class UserServiceImpl implements UserService{

   // The @Autowired annotation in Spring is used for automatic dependency injection 
    //— it tells Spring to automatically inject a bean into another bean where it's needed.
    @Autowired
    private UserRepo userRepo;
   
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        //user id has to be generated
       // String userId=UUID.randomUUID().toString();
       
        //encode the password
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	
    	//set the user role
    	ArrayList<String> roles=new ArrayList<>();
    	roles.add("ROLE_USER");
    	user.setRoleList(roles);

    	return userRepo.save(user);
        
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
         User user2=userRepo.findById(null).orElseThrow(()->new ResourceNotFoundException("User not found"));
         user2.setName(user.getName());
         user2.setEmail(user.getEmail());
         user2.setPassword(user.getPassword());
         user2.setAbout(user.getAbout());
         user2.setPhoneNumber(user.getPhoneNumber());
         user2.setProfilePic(user.getProfilePic());
         user2.setPhoneVerified(user.isPhoneVerified());
         user2.setEmailVerified(user.isEmailVerified());
         user2.setEnable(user.isEnable());
         user2.setProvider(user.getProvider());
         user2.setProviderUserId(user.getProviderUserId());

         //save the user in db
         User save=userRepo.save(user2);
         return Optional.ofNullable(save);

    }

    @Override
    public void deleteUser(String id) {
        User user2=userRepo.findById(null).orElseThrow(()->new ResourceNotFoundException("User not found"));
        userRepo.delete(user2);
    }

    @Override
    public boolean isUserExist(String emailId) {
        User user2=userRepo.findById(null).orElse(null);
        return user2!=null ? true : false;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        User user2=userRepo.findByEmail(email).orElse(null);
        return user2!=null ? true : false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

}
