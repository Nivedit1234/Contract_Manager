package com.scm.dao;

import org.springframework.data.repository.CrudRepository;

import com.scm.entities.User;

public interface UserRepository extends CrudRepository<User,Integer>{

}
