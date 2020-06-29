package com.example.springboot.mongodb.SpringbootMongocrudoperations.service;

import java.util.Collection;
import java.util.Optional;

import com.example.springboot.mongodb.SpringbootMongocrudoperations.model.UserMaster;

public interface UserMasterService {

	public void createMaster(UserMaster master);
	
	public Collection<UserMaster> getAlldata();
	
	public Optional<UserMaster> findUserMasterById(int id);
	
	public boolean existEmailId(String emailId);
	 
	public void updateMaster(UserMaster master);

	public Optional<UserMaster> findByMasterid(int id);
	
	public void deleteAllEmployees() ;
	
}
