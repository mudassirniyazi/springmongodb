package com.example.springboot.mongodb.SpringbootMongocrudoperations.model;

import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "master")
public class UserMaster {

	
		@Id
		private int id;
	    private String username;
	    private String password;
	    private String emailid;
	    
	    private List<Project> project;
	    
	    private Address address;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

	

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public List<Project> getProject() {
			return project;
		}

		public void setProject(List<Project> project) {
			this.project = project;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}


		public String getEmailid() {
			return emailid;
		}

		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}
		
		public UserMaster() {
			
		}
		

		public UserMaster(int id, String username, String password, String emailid, List<Project> project,
				Address address) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.emailid = emailid;
			this.project = project;
			this.address = address;
		}

		@Override
		public String toString() {
		    ObjectMapper mapper = new ObjectMapper();
		      String jsonString = "";
		    try {
		      mapper.enable(SerializationFeature.INDENT_OUTPUT);
		      jsonString = mapper.writeValueAsString(this);
		    } catch (JsonProcessingException e) {
		      e.printStackTrace();
		    }
		    
		      return jsonString;
			
			
		}
		
	
	    
	    
	    
	    
	
}
