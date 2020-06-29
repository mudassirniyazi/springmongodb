package com.example.springboot.mongodb.SpringbootMongocrudoperations.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.mongodb.SpringbootMongocrudoperations.dao.UserMasterDao;
import com.example.springboot.mongodb.SpringbootMongocrudoperations.model.UserMaster;

@Service
public class UserMasterServiceImpl  implements UserMasterService
{
	
	@Autowired
	UserMasterDao dao;
	
	@Override
	public void createMaster(UserMaster master) {
		dao.save(master);
	}

	@Override
	public Collection<UserMaster> getAlldata() {
		   return dao.findAll();	
	}
	
	
	
		@Override
	    public boolean existEmailId(String emailId) {
	        return dao.existsUsersDetailsByEmailId(emailId);
	    }
	
	
	@Override
	public Optional<UserMaster> findUserMasterById(int id) {
		  return dao.findById(id);
		}

//	@Override
//	public void deleteEmployeeById(int id) {
//		 dao.deleteById(id);
//	}


	@Override
	public Optional<UserMaster> findByMasterid(int id) {
		
		Optional<UserMaster> master =	dao.findById(id);
				if(master.isPresent()) {
					return master;
				}
		return master;
	}

	@Override
	public void updateMaster(UserMaster master) {
		dao.save(master);
		
	}

	@Override
	public void deleteAllEmployees() {
		dao.deleteAll();		
	}
//
//	
}
