package com.example.springboot.mongodb.SpringbootMongocrudoperations.exception;

import java.util.List;

public class MyException {
	 

	    private String errorMessage;
	    private List<String> errors;

	    
	    public MyException( String errorMessage){
	
	        this.errorMessage = errorMessage;
	    }

		public MyException() {
			// TODO Auto-generated constructor stub
		}



		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public List<String> getErrors() {
			return errors;
		}

		public void setErrors(List<String> errors) {
			this.errors = errors;
		}
	    
	    
	    
	    
}
