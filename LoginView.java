package com.uciext.javaone.view;

import java.io.File;
import java.util.Scanner;

public class LoginView {
	/**
	 * Author:  Joann Ambrose
	 * Date Written: 2/22/2017
	 */
	 
	private static int loginCounter = 1;
	boolean isUserValid = false;	
	
	public boolean displayLogin(){
		
		String user = "";
		String password = "";
		Scanner scnr = new Scanner(System.in);
		System.out.print("Enter your username: ");
		user = scnr.nextLine();
		System.out.print("Enter your password: ");
		password = scnr.nextLine();
		
		validateUserInfo(user, password);	
		return isUserValid;
	}
	
			
	public void validateUserInfo(String user, String password){
		
		String fileUser = "";
		String filePassword = "";
				
		try {

	        File file = new File("UserPass.txt");

	        // if file doesn't exists, then create it
	        if (!file.exists()) {
	            file.createNewFile();
	           System.out.println("Creating a new file"); 
	        }else{
	        	   	Scanner scnr = new Scanner(file);
		        	
		        	while(scnr.hasNextLine()){
						String line = scnr.nextLine();
						String [] details = line.split(",");
						fileUser = details[0];
						filePassword = details[1];
						
						if(user.equals(fileUser) && (password.equals(filePassword))){
							System.out.println(" ACCESS GRANTED ");
							isUserValid = true;
							break;
						}
					
		        	}	
						
					//increment login counter for each failed login attempt
		        	while(!isUserValid){
						if(loginCounter == 3){
							System.out.println(" ACCESS DENIED ");
							++loginCounter;
						}else if(loginCounter < 3){
							System.out.println("Username or Password does not match. Try again. ");
							++loginCounter;
							System.out.println("\n");
							System.out.println("\n");
							System.out.println("\n");
							HeaderView hv = new HeaderView();
							hv.displayHeader();
							displayLogin();
						}
		        	}
	          }   
	   }catch (Exception e) {
	        e.printStackTrace();
	    }
		
		
	}
}
