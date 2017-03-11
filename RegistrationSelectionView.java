package com.uciext.javaone.view;

import java.io.IOException;
import java.util.Scanner;

import com.uciext.javaone.StudentProfile;

public class RegistrationSelectionView {
	/**
	 * Author:  Joann Ambrose
	 * Date Written: 2/22/2017
	 */
	int registrationOption;
	int optionReturned;
	
	public int start() throws IOException{
		int a = displayRegistrationOption();
		return a;
	}
	
	
	public int displayRegistrationOption(){
		System.out.println("      1 -  Student Profile                           ");
		System.out.println("      2 -  Register for Classes                      ");
		System.out.println("      3 -  Exit                                      ");
		System.out.println("                                                     ");
		System.out.println("      Select an option:                              ");
		Scanner scnr = new Scanner(System.in);
		String option = scnr.next(); 
		//scnr.close();
		optionReturned = validateOption(option);
		return optionReturned;
		
	}
	
	public int validateOption(String option){
		switch(option){
		case "1": //System.out.println("You have chosen view registered courses."); 
				  registrationOption = 1;
				  break;
		case "2": //System.out.println("You have chosen to register for a course."); 
				  registrationOption = 2;
				  break;
		case "3": registrationOption = 3;
				  break;
		//case "4": System.out.println("You have chosen to look at your student profile"); break;
		default: System.out.println("Enter a valid option. ");
			return registrationOption = 0;
		}
		return registrationOption;
	}
}
