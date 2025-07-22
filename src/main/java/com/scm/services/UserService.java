package com.scm.services;

import java.util.List;
import java.util.Optional;

import com.scm.entities.User;
//user service has all the methods for executing business logic of user
///uder repo has all methods that will interact with database
//we will use user repo inside services 
//then services will be used inside controllers 

public interface UserService {
    User saveUser(User user);
    //optional is data type helps you get user based id user exists we can get it else we can throw error  
    Optional<User> getUserById(int id);
    Optional<User> updateUser(User user);
    void deleteUser(String id);
    boolean isUserExist(String emailId);
    boolean isUserExistByEmail(String email);
    List<User> getAllUsers();

}
