package com.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


import com.user.ConnectionTest;

public class OrderBill {
	
	public void getBill() throws SQLException {
		
		
		System.out.println("Please Enter Order No to get Bill :");
		Scanner scanner = new Scanner(System.in);
		int Id = scanner.nextInt();
		
		
		Connection connection = ConnectionTest.getConnection();
		
		PreparedStatement ps = connection.prepareStatement("select ct.OrderNo,ur.Id,ur.Name,ct.ProductId,pd.ProductDetails,pd.ProductName,pd.ProductPrice,ct.Quantities from product pd   join cart ct   on pd.ProductId=ct.ProductId join user ur on ur.Id=ct.Id where ct.OrderNo=?");  
				
		
		ps.setInt(1, Id);
	
		ResultSet rs =ps.executeQuery();
		
		while(rs.next()) {
			
			System.out.println("Order No :- "+rs.getInt(1));
			System.out.println("Customer Id :-" +rs.getInt(2));
			System.out.println("Customer Name :-" +rs.getString(3));
			System.out.println("Product Id  :-"+rs.getInt(4));
			System.out.println("Product Details :- "+rs.getString(5));
			System.out.println("Product :- "+rs.getString(6));
			System.out.println("Price Rs :-" +rs.getInt(7));
			System.out.println("Quantity :-" +rs.getInt(8)+"\n");
			System.out.println("------------------------------------------"+"\n");
			
			
			System.out.println(" Bill Amount for Order No "+rs.getInt(1)+" is Rs "+ rs.getInt(8)*rs.getInt(7) );
			
			System.out.println("------------------------------------------"+"\n");
		
		
		}
		
			
	} 
	
		
	}


