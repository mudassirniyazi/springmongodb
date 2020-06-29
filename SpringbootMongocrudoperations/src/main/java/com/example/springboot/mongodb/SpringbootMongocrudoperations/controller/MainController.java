package com.example.springboot.mongodb.SpringbootMongocrudoperations.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.mongodb.SpringbootMongocrudoperations.constant.BasicConstant;
import com.example.springboot.mongodb.SpringbootMongocrudoperations.model.UserMaster;
import com.example.springboot.mongodb.SpringbootMongocrudoperations.service.UserMasterService;
import com.example.springboot.mongodb.SpringbootMongocrudoperations.validate.Validation;


@RestController
@RequestMapping(value= "/api/mongo/emp")
public class MainController {


	
	@Autowired
	UserMasterService service;
	
	@Autowired
	Validation validate;
	
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 /**
	  * This method is used to save UserMaster Details	
	  * @param emp
	  * @return
	  */	 
	 
	 	@PostMapping(value= "/save", produces = "Application/json")
	    public  ResponseEntity<Map> create(@RequestBody UserMaster master) 
	 	{
	 		Map<String, Integer> map = null;
	 		 if (validate.valid(master)) {
	 		map = new HashMap<String,Integer>();
	        logger.debug("Saving employees details.");
	        service.createMaster(master);
	        map.put(BasicConstant.successkey,BasicConstant.SUCCESSCODE);
	        return new ResponseEntity<>(map,HttpStatus.CREATED);
	 		 }else {
	 			map = new HashMap<String,Integer>();
	 			map.put(BasicConstant.failurekey,BasicConstant.FAILURECODE);
	 			 return new ResponseEntity<>(map,HttpStatus.EXPECTATION_FAILED);
	 		 }
	    }
	
	/**
	 * This method is used to get the UserMaster Details
	 * @return
	 */	 		 	
	 	
	 	@GetMapping(value= "/getalldata")
	    public Collection<UserMaster> getAll() 
	 	{
	        logger.debug("Getting all  details.");
	        return service.getAlldata();
	    }
	 
	/**
	 * This method is used to get the MAster details by id
	 * @return
	 */
	
	 	@GetMapping(value="/getbyid/{master-id}")
	 	public Optional<UserMaster> getById(@PathVariable(value="master-id") int id)
	 	{
	 		logger.debug("Get the master Details by id");
	 		return service.findUserMasterById(id);
	 	}
	 	
	 	/**
		 * This method is used to get the employee details by id
		 * @return
		 */
	 		 	
	 	@PutMapping(value= "/update/{master-id}",produces = "Application/json")
	 	public ResponseEntity<Map> updateemployee(@PathVariable(value="master-id") int id,@RequestBody UserMaster master)
	 	{
	 		Map<String,String> map = null;
	 		Optional<UserMaster> usermaster=	service.findByMasterid(id);	 	
	 		
	 			try {
	 			 		if(usermaster.isPresent()) {
	 		logger.debug("Updating Employee with master-id", id);
	 		master.setId(id);
			service.updateMaster(master);			
			map = new HashMap<String,String>();
			map.put(BasicConstant.successkey,BasicConstant.SUCCESSMESSAGE);
			return new ResponseEntity<>(map,HttpStatus.CREATED);
	 			 		}else {
	 			 			map.put(BasicConstant.successkey,BasicConstant.SUCCESSMESSAGE);
	 						return new ResponseEntity<>(map,HttpStatus.EXPECTATION_FAILED);	 			 			
	 			 		}
	 			}catch(Exception e)
	 			{
	 				map = new HashMap<String,String>();
	 				map.put(BasicConstant.failurekey,BasicConstant.FAILMESSAGE);
	 				return new ResponseEntity<>(map,HttpStatus.EXPECTATION_FAILED);
	 			}
				
	 			}	
	
//
//
//	 	/**
//		 * This method is used to Delete the employee details by id
//		 * @return
//		 */
//
//	 	@DeleteMapping(value="/delete/{employee-id}")
//	 	public String deleteById(@PathVariable(value="employee-id") int id)
//	 	{
//	 		logger.debug("Deleting employee with employee-id",id);
//	 		service.deleteEmployeeById(id);
//	 		return "Deleted Succesfully";
//	 	}
//	 	
//	 	/**
//		 * This method is used to Delete all the employee details 
//		 * @return
//		 */
//	 	
//	 	
	 	@DeleteMapping(value="/deleteall")
	 	public ResponseEntity<Map> deleteAll() 
	 	{	 		
	 		Map<String,String> map = null;
	 		logger.debug("Deleting all the Employees");
	 		service.deleteAllEmployees();
	 		map = new HashMap<String,String>();
	 		map.put(BasicConstant.successkey, BasicConstant.DELETEMESSAGE);
	 		return new ResponseEntity<>(map,HttpStatus.OK);
	 	}





}
