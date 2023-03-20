package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CheckCart {


	public void CheckOutDetails() throws SQLException {
		
		
  Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Id :");
		int Id = scanner.nextInt();
		
		System.out.println("Enter Username : ");
		String Username = scanner.next();
		
		
		System.out.println("Enter Product Id : ");
		int ProductId = scanner.nextInt();
		
		
		
		
	
//-------------------------------------------------------------------------------------------------------------

	
			Connection connection = ConnectionTest.getConnection();
		
		PreparedStatement ps = connection.prepareStatement("select ct.OrderNo,ur.Id,ur.Name,ct.ProductId,pd.ProductDetails,pd.ProductName,pd.ProductPrice,ct.Quantities,ur.Username from product pd   join cart ct   on pd.ProductId=ct.ProductId join user ur on ur.Id=ct.Id where ur.Id=? and ur.Username=? and pd.ProductId=?");  
				
		
		ps.setInt(1, Id);
		ps.setString(2, Username);
		ps.setInt(3, ProductId);
		ResultSet rs =ps.executeQuery();
		
		
		while (rs.next() )  {
		
		{
			System.out.println("Product- "+rs.getString(6));
			System.out.println(rs.getString(5));
		    System.out.println("Price Rs- " +rs.getInt(7));
		    System.out.println("Quantity - " +rs.getInt(8)+"\n");
		    
		}
		 
		
		
		}
		
		
		
		


			
			
		
		} 
      

}
	
