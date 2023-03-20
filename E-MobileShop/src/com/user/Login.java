package com.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
	public static void validateLogin(String Username, String Password) throws SQLException, NumberFormatException, IOException, ClassNotFoundException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		// create connection
				ConnectionTest connectionTest = new ConnectionTest();
				Connection con = connectionTest.getConnection();
		
			String s = "select * from user where Username=? and Password=? ";
		
		    PreparedStatement psmt = con.prepareStatement(s);
			psmt.setString(1, Username);
			psmt.setString(2, Password);
		
			ResultSet r = psmt.executeQuery();

			if (r.next()) {
				System.out.println("Login Successfull..");
				System.out.println("Your Id "+r.getInt(1));
				System.out.println("---------------------");

				while (true) {
					System.out.println("Press 1 to Product Display: ");
					System.out.println("Press 2 to Add To Cart : ");
					System.out.println("Press 3 to CheckCart : ");
					System.out.println("Press 4 to Logout : ");
					System.out.println("-----------------------------");

					int b = Integer.parseInt(bufferedReader.readLine());

					if (b == 1) {
						// Show Product Info
						Product product = new Product();
						product.productInfo();

					}
					if (b == 2) {
						// Add Product To Cart
						Cart cart = new Cart();
						cart.addToCart();

					}
					if (b == 3) {
						// Checkout And Bill Amount Calculation
						CheckCart checkOut = new CheckCart();
						checkOut.CheckOutDetails();
						System.out.println("Thank You For Shopping With Us....");
						System.out.println("-----------------------");
						
					}
					if(b==4) {
						//Logout
						System.out.println("Logged Out Successfully..");
						break;
						
					}
					

				}
			
			
			}
		
	
	
	
			else {
				System.out.println("-----------------------------");
				System.out.println("Invalid Username or Password!!");

			}
	
	
	
	
	}

}
