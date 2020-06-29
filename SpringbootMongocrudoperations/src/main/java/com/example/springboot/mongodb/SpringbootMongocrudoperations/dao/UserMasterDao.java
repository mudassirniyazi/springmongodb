package com.example.springboot.mongodb.SpringbootMongocrudoperations.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.mongodb.SpringbootMongocrudoperations.model.UserMaster;

@Repository
public interface UserMasterDao extends MongoRepository<UserMaster,Integer>
{

	
	boolean existsUsersDetailsByEmailId(String emailid);
	
}
