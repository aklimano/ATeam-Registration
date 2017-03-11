package com.uciext.javaone.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {

					     
		private int studentId;
		private String firstname;
		private String lastname;
		private String emailAddress;
		private List<Student> existingStudent;
		//private List<Courses> courses;
		
		
		//constructor
		public Student(){
			
		}
		
		public Student(int id){
			this.firstname = getFirstname();
			this.lastname = getLastname();
			this.emailAddress = getEmailAddress();
			
		}
		public Student(int id, String first, String last, String email){
			this.studentId = id;
			this.firstname = first;
			this.lastname = last;
			this.emailAddress = email;
			
		}
		
		//Getters and Setters
		
		public int getStudentId() {
			return studentId;
		}
		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		
		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}
		
		public Student getStudent(int StudentId){
			return new Student();
		}
		
		public void getStudentList() throws IOException{
			existingStudent = new ArrayList<Student>();
			try {

		        File file = new File("StudentMaster.txt");

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
			        	String firstReadIn = details[1];
			        	String lastReadIn = details[2];
			        	String emailReadIn = details[3];
			        	Student s = new Student (idReadIn, firstReadIn, lastReadIn, emailReadIn);
		                existingStudent.add(s);
		            	//System.out.println(line);
		            }
		        }	
		       }catch (Exception e) {
			        e.printStackTrace();
			    }
		        
		        for(Student s: existingStudent){
		        	System.out.println(s.toString());
		        }
		
		}
			
		public String toString(){
			StringBuilder str = new StringBuilder();
			str.append("Students in Master file are :" + "\n Student Id: " + studentId +
					"\n First Name: " + firstname + "\n Last Name: " + lastname + "\n Email Address: " + emailAddress +
					"\n");
		    return str.toString();
		}
		//public List<Courses> getCourses() {
		//	return courses;
		//}
		//public void setCourses(List<Courses> courses) {
		//	this.courses = courses;
		//}
		
			
		
		
}
