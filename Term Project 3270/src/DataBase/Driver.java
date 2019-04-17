package DataBase;

import java.sql.*;

public class Driver {

	public static void main(String[] args) throws SQLException, ClassNotFoundException  {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
			try {
			// Establish a connection
		    myConn = DriverManager.getConnection
		      ("jdbc:mysql://localhost/airlinereservation" , "root" , "nodummies12345");
			
		    // Create a statement
		    myStmt = myConn.prepareStatement("select * from customer where name = ? and address = ?");
			
			
			// set parameters
			
			myStmt.setString(1, "ben");
			myStmt.setString(2, "cars");
			
			
		    // Execute a statement
		    myRs = myStmt.executeQuery();
		
		    // Iterate through the result and print the student names
		    
		    display(myRs);
		    
			}
		    catch(Exception ex) {
				ex.printStackTrace();
			}
		
		    // Close the connection
				finally {
				   if (myRs != null) {
				    myRs.close();
				   }
				   
				   if (myStmt != null) {
				    myStmt.close();
				   }
				   
				   if (myConn != null) {
				    myConn.close();
				   }
				  }
		
	}

	private static void display(ResultSet myRs) throws SQLException {
		  while (myRs.next()) {
		   String name = myRs.getString("name");
		   String address = myRs.getString("address");
		  
		   
		   System.out.printf("%s, %s ", name, address);
		  }
		 }
	
}
