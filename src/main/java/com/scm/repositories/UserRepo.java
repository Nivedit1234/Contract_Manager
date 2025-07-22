package com.scm.repositories;

import com.scm.entities.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//uder repo has all methods that will interact with database
//userRepo can be directly used under controller but it is not a standard practice 
//sp we will make user service
//The @Repository annotation in Spring is used to indicate that a class is a DAO (Data Access Object) that interacts with the database.
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    // Optional custom method if needed
    //extra methods for db related operations
    //custom query mehtods
    
    
    //custom finder methods
    //all these methods implementation will be done spring data jpa automatically 
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
}

