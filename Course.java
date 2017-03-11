package com.uciext.javaone.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Course {
	private int courseId;
	private String courseName;
	private double courseCredit;
	private String courseDay;
	private String courseStrtTime;
	private String courseEndTime;
	private String status;
	private List<Course> existingCourses;
	
	
	public double getCourseCredit() {
		return courseCredit;
	}

	public void setCourseCredit(double courseCredit) {
		this.courseCredit = courseCredit;
	}

	public List<Course> getExistingCourses() {
		return existingCourses;
	}

	public void setExistingCourses(List<Course> existingCourses) {
		this.existingCourses = existingCourses;
	}

	
	
	public Course(){
		courseId = 9999;
		courseName = "Unknown";
		courseCredit = 0.0;
		courseStrtTime = "00:00";
		courseEndTime = "00:00";
		status = "Inactive";
		
	}
	
	public Course(int id, String name, double credits, String day, String strtTime, String endTime, String status){
		this.courseId = id;
		this.courseName = name;
		this.courseCredit = credits;
		this.courseDay = day;
		this.courseStrtTime = strtTime;
		this.courseEndTime = endTime;
		this.status = status;	
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDay() {
		return courseDay;
	}

	public void setCourseDay(String courseDay) {
		this.courseDay = courseDay;
	}

	public String getCourseStrtTime() {
		return courseStrtTime;
	}

	public void setCourseStrtTime(String courseStrtTime) {
		this.courseStrtTime = courseStrtTime;
	}

	public String getCourseEndTime() {
		return courseEndTime;
	}

	public void setCourseEndTime(String courseEndTime) {
		this.courseEndTime = courseEndTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void getCourseList() throws IOException{
		existingCourses = new ArrayList<Course>();
		try {

	        File file = new File("Courses.txt");

	        // if file doesnt exists, then create it
	        if (!file.exists()) {
	            file.createNewFile();
	           System.out.println("Creating a new file"); 
	        }else{
	        	Scanner scnr = new Scanner(file);
	   
	            while(scnr.hasNextLine()){
	            	String line = scnr.nextLine();
	            	String[] details = line.split(",");
	            	int idReadIn = Integer.parseInt(details[0]);
		        	String nameReadIn = details[1];
		        	double creditsReadIn = Double.parseDouble(details[2]);
		        	String dayReadIn = details[3];
		        	String strtReadIn = details[4];
		        	String endReadIn = details[5];
		        	String statusReadIn = details[6];
		        	
		        	Course s = new Course(idReadIn, nameReadIn, creditsReadIn, dayReadIn, strtReadIn, endReadIn, statusReadIn);
	                existingCourses.add(s);
	            	//System.out.println(line);
	            }
	        }	
	       }catch (Exception e) {
		        e.printStackTrace();
		    }
	        
	        for(Course s: existingCourses){
	        	System.out.println(s.toString());
	        }
	
	}
		
	public String toString(){
		StringBuilder str = new StringBuilder();
		if(status.equals("Active")){
		str.append("Courses being offered are: " + "\n Course Id: " + courseId +
				"\n Course Name: " + courseName + " will be held on " + courseDay + " from " + courseStrtTime +
				" to " + courseEndTime);
		}else if(status.equals("Inactive")){
			str.append("These courses will not be offered this quarter: " + "\n Course Id: " + courseId +
					" Course Name: " + courseName);
		}else{
			str.append("Registration for these courses are closed: " + "\n Course Id: " + courseId +
					"\n Course Name: " + courseName + " held on " + courseDay + " from " + courseStrtTime +
					" to " + courseEndTime);
		}
	    return str.toString();
	}
	
}
