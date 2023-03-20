package com.Admin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.user.ConnectionTest;

public class Admin {
			
			public void adminMenu() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				while (true) {
				System.out.println("Press 1 to Check Registerd Users : ");
				System.out.println("Press 2 to Check Order History  : ");
				System.out.println("Press 3 to Check Order Bill : ");
				System.out.println("Press 4 to Logout : ");
				System.out.println("--------------------------------------------");
				
				int b = Integer.parseInt(bufferedReader.readLine());
				
				if (b==1) {
					//Check User Details
					this.getUserDetails();
				}
				if(b==2) {
					
					OrderHistory orderHistory = new OrderHistory();
					orderHistory.getOrderDetails();
					
				}
				if(b==3) {
					
					OrderBill bill = new OrderBill();
				     bill.getBill();
					
					
				}
				if(b==4) {
					//Logout
					System.out.println("You are Successfully Logged Out..");
					break;
					
				}
				else {
					
					}
				}
			}
		
		public void getUserDetails() throws ClassNotFoundException, SQLException {
			
			
			ConnectionTest connectionTest = new ConnectionTest();
			Connection con = connectionTest.getConnection();
			
			String s = "select Id,Name,Username from user";
		
			PreparedStatement preparedStatement = con.prepareStatement(s);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Registered User Details..");
				System.out.println("-------------------------");
				
				System.out.println("Id : "+resultSet.getInt(1));
				System.out.println("Name : "+resultSet.getString(2));
				System.out.println("Username : "+resultSet.getString(3));
				
				System.out.println("-------------------------");
				
			}
			

			
		}


}



