package DataBase;

import java.sql.*;

public class Driver {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
			    // Load the JDBC driver
			    System.out.println("Driver loaded");
			
			    // Establish a connection
			    Connection connection = DriverManager.getConnection
			      ("jdbc:mysql://localhost/test");
			    System.out.println("Database connected");
			
			    
			    String queryString = "select firstName, mi, " + 
			    "lastName , title, grade from Student, Enrollment, Course " +
			    "where Student.ssn = ? and Enrollment.courseId = ? " +
			    "and Enrollment.courseId = Course.courseId" ;
			    
			    // Create a statement
			  //   preparedStatement = connection.preparedStatement(queryString);
			
			    // Execute a statement
			//    ResultSet resultSet = statement.executeQuery
			     // ("select firstName, mi, lastName from Student where lastName "
			  //      + " = 'Smith'");
			
			    // Iterate through the result and print the student names
			 //   while (resultSet.next())
			 //     System.out.println(resultSet.getString(1) + "\t" +
			 //       resultSet.getString(2) + "\t" + resultSet.getString(3));
			
			    // Close the connection
			    connection.close();
			  }

}
