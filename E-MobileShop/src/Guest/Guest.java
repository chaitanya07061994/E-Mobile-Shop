package Guest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



import java.sql.SQLException;

import com.user.Product;



public class Guest {
			
			public void ViewAsGuest() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
				
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				while (true) {
				System.out.println("Press 1 to View Products : ");
				System.out.println("Press 2  to Exit : ");
				
				System.out.println("--------------------------------------------");
				
				int b = Integer.parseInt(bufferedReader.readLine());
				
				if (b==1) {
					
					
					Product product = new Product();
					product.productInfo();
				
				
				}
          
				if(b==2) {
					//Logout
					System.out.println("You are Successfully Logged Out..");
					break;
					
				}
				else {
					
					}
				
				
				
		}
				
	}		
}