package DataBase;

import java.sql.*;

public class Driver {

	public static void main(String[] args) throws SQLException, ClassNotFoundException  {
		
			
			// Establish a connection
		    Connection connection = DriverManager.getConnection
		      ("jdbc:mysql://localhost/airlinereservation" , "root" , "nodummies12345");
		    System.out.println("Database connected");
		
		    // Create a statement
		    Statement statement = connection.createStatement();
		
		    // Execute a statement
		    ResultSet resultSet = statement.executeQuery
		      ("select * from customer");
		
		    // Iterate through the result and print the student names
		    while (resultSet.next())
		      System.out.println(resultSet.getString("name") + " , " +
		        resultSet.getString("address"));
		
		    // Close the connection
		    connection.close();
		
	}
			  

}
