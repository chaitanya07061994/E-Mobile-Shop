package com.user;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.Admin.Admin;
import com.Guest.Guest;


public class MainTest {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException, ClassNotFoundException  {

		System.out.println("Welcome To E-Store..");
		

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	
	
		while (true) {
			System.out.println("-------------------------");
			System.out.println("Press 1 to Register. : ");
			System.out.println("Press 2 to Login : ");
			System.out.println("Press 3 to Login as Admin : ");
			System.out.println("Press 4 to Login as Guest : ");
			System.out.println("Press 5 to Exit : ");
			System.out.println("-------------------------");
			int a = Integer.parseInt(bufferedReader.readLine());

			if (a == 1) {
				// add user
				System.out.println("Registration Page....");
				System.out.println("Enter Name : ");
				String name = bufferedReader.readLine();
				System.out.println("Enter UserName : ");
				String username = bufferedReader.readLine();
				System.out.println("Enter Password : ");
				String pass = bufferedReader.readLine();

				// Create RegisterUSer object to store the object
				RegisterUser registerUser = new RegisterUser(name,username, pass);
				boolean ans = InsertUser.InsertUser(registerUser);
				if (ans) {
					System.out.println("User Registered Successfully....");

				} else {
					System.out.println("Something Went Wrong.... ");
				}

			}
			
			
			if (a == 2) {
				
				System.out.println("Login Page");
				System.out.println("---------------------");
				System.out.println("Enter Username : ");
				String Uname = bufferedReader.readLine();
				System.out.println("Enter Password : ");
				String Password = bufferedReader.readLine();
			
				Login login = new Login();
				login.validateLogin(Uname, Password);
			
			}
		
			if (a == 3) {
				
				System.out.println("Admin Login..");
				System.out.println("-------------------------");
				System.out.println("Enter Username : ");
				String uid = bufferedReader.readLine();
				System.out.println("Enter Password : ");
				String pas = bufferedReader.readLine();
				if(uid.equals("Admin") && pas.equals("Admin")) 
					System.out.println("Login Successfull...");
					System.out.println("Welcome Admin!!");
				
				
					Admin admin = new Admin();
					admin.adminMenu();
				
				}
				
				if (a == 4) {
					System.out.println("Guest Login..");
					 
					
					Guest guest = new Guest();
					guest.ViewAsGuest() ;
				
				}
				
				if (a == 5) {
					
					// exit
					break;
				} 
				else {
					
				}
				
				
				
				
			}
		
		System.out.println("Thank You For Visiting Us....");
          }
	}

