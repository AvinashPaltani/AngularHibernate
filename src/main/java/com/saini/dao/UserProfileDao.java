package com.saini.dao;

import java.util.List;

import com.saini.model.UserProfile;


 
public interface UserProfileDao {
 
    List<UserProfile> findAll();
     
    UserProfile findByType(String type);
     
    UserProfile findById(int id);
}