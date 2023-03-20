package com.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.user.ConnectionTest;

public class OrderHistory {



	public void getOrderDetails() throws SQLException {
		
        Connection connection = ConnectionTest.getConnection();
		
		PreparedStatement ps = connection.prepareStatement("select ct.OrderNo,ur.Id,ur.Name,ct.ProductId,pd.ProductDetails,pd.ProductName,pd.ProductPrice,ur.Username,ct.Quantities from product pd   join cart ct   on pd.ProductId=ct.ProductId join user ur on ur.Id=ct.Id order by OrderNo asc");  
				
		
	
		
		ResultSet rs =ps.executeQuery();
		
		
		while (rs.next() )  {
			
			System.out.println("Order No :- "+rs.getInt(1));
			System.out.println("Customer Id :-" +rs.getInt(2));
			System.out.println("Customer Name :-" +rs.getString(3));
			System.out.println("Product Id  :-"+rs.getInt(4));
			System.out.println("Product Details :- "+rs.getString(5));
			System.out.println("Product :- "+rs.getString(6));
			System.out.println("Price Rs :-" +rs.getInt(7));
			System.out.println("Quantity :-" +rs.getInt(9));
			System.out.println("------------------------------------------"+"\n");
		
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
