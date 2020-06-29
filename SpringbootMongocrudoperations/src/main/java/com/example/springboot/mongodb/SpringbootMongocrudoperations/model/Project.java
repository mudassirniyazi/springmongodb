package com.example.springboot.mongodb.SpringbootMongocrudoperations.model;

public class Project {


	private String projectname;
	
	private String projecttype;
	
	private String projectduration;

	private String projectyear;
	
	private String projectdetailks;

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getProjecttype() {
		return projecttype;
	}

	public void setProjecttype(String projecttype) {
		this.projecttype = projecttype;
	}

	public String getProjectduration() {
		return projectduration;
	}

	public void setProjectduration(String projectduration) {
		this.projectduration = projectduration;
	}

	public String getProjectyear() {
		return projectyear;
	}

	public void setProjectyear(String projectyear) {
		this.projectyear = projectyear;
	}

	public String getProjectdetailks() {
		return projectdetailks;
	}

	public void setProjectdetailks(String projectdetailks) {
		this.projectdetailks = projectdetailks;
	}
	
	public Project() {
		
	}
	

	public Project(String projectname, String projecttype, String projectduration, String projectyear,
			String projectdetailks) {
		super();
		this.projectname = projectname;
		this.projecttype = projecttype;
		this.projectduration = projectduration;
		this.projectyear = projectyear;
		this.projectdetailks = projectdetailks;
	}
	
	
	
	
	
	
}
