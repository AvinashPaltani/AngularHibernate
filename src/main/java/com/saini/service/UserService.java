package com.saini.service;

import java.util.List;

import com.saini.model.Users;

public interface UserService {
    
    Users findById(int id);
     
    Users findBySSO(String sso);
     
    void saveUser(Users user);
     
    void updateUser(Users user);
     
    void deleteUserBySSO(String sso);
 
    List<Users> findAllUsers(); 
     
    boolean isUserSSOUnique(Integer id, String sso);
 
}