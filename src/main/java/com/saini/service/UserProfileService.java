package com.saini.service;

import java.util.List;

import com.saini.model.UserProfile;

public interface UserProfileService {
	 
    UserProfile findById(int id);
 
    UserProfile findByType(String type);
     
    List<UserProfile> findAll();
     
}