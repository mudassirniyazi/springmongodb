package com.example.springboot.mongodb.SpringbootMongocrudoperations.validate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.example.springboot.mongodb.SpringbootMongocrudoperations.constant.RegexValidation;
import com.example.springboot.mongodb.SpringbootMongocrudoperations.exception.MyException;
import com.example.springboot.mongodb.SpringbootMongocrudoperations.model.UserMaster;
import com.example.springboot.mongodb.SpringbootMongocrudoperations.service.UserMasterService;

@Component
public class Validation {
	
	@Autowired
	UserMasterService userMasterService;
	

    public boolean valid(UserMaster usermaster){
    	MyException customException = new MyException();
        List<String> errors = new ArrayList<>();
       
        
        
        if(!userNameValidator(usermaster.getUsername())){
            errors.add("UserName Not Valid");
        }
        
        if(!passwordValidator(usermaster.getPassword())){
            errors.add("Password Not Valid");
        }
        
        if(!emailIdValidator(usermaster.getEmailid())){
            errors.add("Please Enter Valid EmailId.");
        }

        if(!mobileNoValidator(usermaster.getAddress().getPhone())){
            errors.add("Mobile Number Not Valid");
        }

        if(!pinCodeValidator(usermaster.getAddress().getPincode())) {
        	errors.add("PinCode Invalid");
        }
        
        
        
        if(errors.isEmpty()){
            return true;
        }
        else{
           
            customException.setErrorMessage("Input Json Not Valid");
            customException.setErrors(errors);
            return false;
        }

    }


    /**
     * All specific validator
     */
    public boolean userNameValidator(String userName){
        Pattern userNamePattern = Pattern.compile(RegexValidation.USERNAME);
        return userNamePattern.matcher(userName).matches();
    }

    public boolean passwordValidator(String password){
        Pattern pattern = Pattern.compile(RegexValidation.PASSWORD);
        return pattern.matcher(password).matches();
    }

    public boolean emailIdValidator(String emailId){
        Pattern pattern = Pattern.compile(RegexValidation.EMAIL_ID);
        return (pattern.matcher(emailId).matches() & !userMasterService.existEmailId(emailId));

    }

    public boolean mobileNoValidator(String mobileNo){
        Pattern pattern = Pattern.compile(RegexValidation.MOBILE_NO);
        return pattern.matcher(mobileNo).matches();
    }

    public boolean pinCodeValidator(String pinCode){
        Pattern pattern = Pattern.compile(RegexValidation.PIN_CODE);
        return pattern.matcher(pinCode).matches();
    }
	
	
	
	
}
