package com.uciext.javaone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.uciext.javaone.model.Student;

public class StudentProfile  {
	/**
	 * Author:  Joann Ambrose
	 * Date Written: March 8, 2017
	 * Team A
	 */
	
	Student currentStudent; 
	
	public void getStudentProfileDetails() throws IOException{
		try{
			BufferedReader student = new BufferedReader(new FileReader("StudentMaster.txt"));
			System.out.println("Please enter your student id:  ");
			Scanner scnr = new Scanner(System.in);
			String inStudentId = scnr.nextLine();
			
			//split up line of student info read in
			String strStudent = null;
			currentStudent = new Student();
			while((strStudent = student.readLine()) != null){
				String [] stuInfo = strStudent.split(",");
				
				//checks if student id entered equals a student id on master file
				//if it does, parse out info from file and map to Student model
				//System.out.println("stuId parsed from file: " + stuInfo[0] + 
				//		" and student id entered at console: " + inStudentId);
				if(stuInfo[0] != null && stuInfo[0].equals(inStudentId)){
						currentStudent.setStudentId(Integer.parseInt(stuInfo[0]));		
						currentStudent.setFirstname(stuInfo[1]);		
						currentStudent.setLastname(stuInfo[2]);	
						currentStudent.setEmailAddress(stuInfo[3]);		
				}
			}
			//String [] stuInfo = inStudent.split(",");
			
						
			//print out line student information header
			//System.out.println(currentStudent.getStudentId());
			int studentId = currentStudent.getStudentId();
			printStudentDetails(currentStudent);
			
			BufferedReader in = new BufferedReader(new FileReader("RegistrationOutput.txt"));
			String str = null;
	
			List<String> list = new ArrayList<String>();
	
			while((str = in.readLine()) != null){
					list.add(str);
				}
	
			for(String s: list){
				String[] details = s.split(",");
				if(inStudentId.equals(details[0])){
					System.out.println(details[1] + "\t    " + details[2] + "    " + details[3]);
			}
			scnr.close();
			student.close();
			in.close();
		}
			}catch(IOException e){
				e.printStackTrace();
			}	
	}
	
	public void printStudentDetails(Student s){
		//System.out.println("inside print student details, student id is " + s.getStudentId());
		
		//formatting before printing student information
		System.out.println("Student Id:  " + s.getStudentId());
		System.out.println("Student Name:  " + s.getFirstname() + " " + s.getLastname());
		System.out.println();
		System.out.println("*********************************************************");
		System.out.println();
		System.out.println("Course Id   Course Name  \t\t    Course Dates");
	}
}

