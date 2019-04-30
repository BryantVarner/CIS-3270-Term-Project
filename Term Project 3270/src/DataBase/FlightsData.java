package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FlightsData extends AdminData {
	
	
	public static Connection getConnection() throws SQLException {
		
		Connection myConn = DriverManager.getConnection
		      ("jdbc:mysql://localhost/airlinereservation" , "root" , "nodummies12345");

			return myConn;		
	}
	
	// adds a flight to flight database
	
	public void addFlight(String flightNums, String flightDate, String departTime, 
						String departFrom, String arrivalTo, String airline, String seatPrices)
						throws SQLException, ClassNotFoundException {

			Connection myConn = null;
			PreparedStatement myStmt = null;
			String sql = "insert into flights values (?, ?, ?, ?, ?, ?, ?)";
			
			try {
			myConn = DriverManager.getConnection
			  ("jdbc:mysql://localhost/airlinereservation" , "root" , "nodummies12345");
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1, flightNums);
			myStmt.setString(2, flightDate);	
			myStmt.setString(3, departTime);
			myStmt.setString(4, departFrom);
			myStmt.setString(5, arrivalTo);
			myStmt.setString(6, airline);
			myStmt.setString(7, seatPrices);
			
			myStmt.executeUpdate();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			finally {
			    myConn.close();
			  }
			
			}
	
	
	
	
	
	
	
	
	
	

}
