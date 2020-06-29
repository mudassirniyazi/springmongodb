package com.example.springboot.mongodb.SpringbootMongocrudoperations.response;

public class ResponseEntityMessage { private Integer statusCode;

private Integer userId;

private  String message;

public Integer getStatusCode() {
	return statusCode;
}
public void setStatusCode(Integer statusCode) {
	this.statusCode = statusCode;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

public ResponseEntityMessage() {
	
}

public ResponseEntityMessage(Integer statusCode, Integer userId, String message) {
	super();
	this.statusCode = statusCode;
	this.userId = userId;
	this.message = message;
}
}
