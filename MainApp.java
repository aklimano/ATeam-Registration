package com.uciext.javaone;
import java.util.Scanner;

import java.io.File;

import java.io.IOException;
import com.uciext.javaone.view.*;
import java.util.Scanner;

import com.uciext.javaone.model.*;

public class MainApp {
		/**
		 * Author:  Joann Ambrose
		 * Date Written: 2/22/2017
		 */
		
		public static void main(String[] args) throws IOException {
			LogoffView logoff = new LogoffView();
			//Display registration header banner
			HeaderView hv = new HeaderView();
			hv.displayHeader();
			
			LoginView lv = new LoginView();
			boolean isValidLogin = lv.displayLogin();
			
			if(isValidLogin){
				System.out.println("\n");
				System.out.println("\n");
				System.out.println("\n");
			
				hv.displayHeader();
				RegistrationSelectionView rsv = new RegistrationSelectionView();
				int regOption = rsv.start();
				
				System.out.println();
				System.out.println();
				System.out.println();
				
				//Return  
				if (regOption == 1){
					StudentProfileHeader spv = new StudentProfileHeader();
					spv.displayHeader();
					StudentProfile studentProf = new StudentProfile();
					studentProf.getStudentProfileDetails();
				}else if(regOption == 2){
					System.out.println("I am ready to register for a class");
				}else{
					hv.displayHeader();
					logoff.displayLogoffMessage();
				}
			}
			
			//Student stu = new Student();
			//stu.getStudentList();
			
			//Course crs = new Course();
			//crs.getCourseList();
		}
		
		
		
}



