package com.saini.dao;

import java.util.List;

import com.saini.model.Users;

 
public interface UserDao {
 
    Users findById(int id);
     
    Users findBySSO(String sso);
     
    void save(Users user);
     
    void deleteBySSO(String sso);
     
    List<Users> findAllUsers();
 
}