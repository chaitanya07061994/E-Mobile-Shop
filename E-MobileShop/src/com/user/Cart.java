package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Cart {


	public void addToCart() throws SQLException {

		Scanner scan = new Scanner(System.in);
		System.out.println("Add Products To cart : ");
		
		    System.out.println("Enter Your Id") ;
	        int Id1 = scan.nextInt();

		    System.out.println("Enter PassWord :") ;
  	        Scanner scanner = new Scanner(System.in);
		    String Password = scanner.nextLine();
  	    
  	        System.out.println("Enter Product ID : ");
		    int Id = scan.nextInt();

		    System.out.println("Enter Your Id To Verify :") ;
		    int ProductId = scan.nextInt();
		    
		    System.out.println("Enter Your Quantity :") ;
		    int Quantity = scan.nextInt();
		    

		    Connection connection=ConnectionTest.getConnection();
		    
		  	PreparedStatement ps = connection.prepareStatement("select * from user where Id=? and Password=?");
				
				
				ps.setInt(1, Id1);
				ps.setString(2, Password);
				
				ResultSet resultset = ps.executeQuery();
				
				
				
				if(resultset.next()) {
					
		             System.out.println(" User Identified ");
					
					System.out.println(resultset.getString(2));
					
				}
				
				else {
					
					System.out.println("  Sorry Wrong Id or PassWord \n ");
					System.out.println("  Please Try Again ");
				     
				}

				Connection connection1=ConnectionTest.getConnection();
			    
				  String sql2 = "insert into Cart (Id,ProductId,Quantities) values (?,?,?)";
						
						PreparedStatement ps2 = connection.prepareStatement(sql2);
					    
						ps2.setInt(1, Id);
				     	ps2.setInt(2, ProductId); 
				       ps2.setInt(3, Quantity);
			     	
				       
				       if(Id1==Id    && Password.equals(resultset.getString(4))) 
			     			 
			     			 { ps2.execute(); 
			       
			       System.out.println("Added to cart Successfully");
					
			       System.out.println("-----------------------------");
			     			 }
					
					 
			     	 
			     	 else {    System.out.println(" Sorry !!Wrong Id , Please Enter Your Id Correctly");
			     	 
			     	 }
				}

}
