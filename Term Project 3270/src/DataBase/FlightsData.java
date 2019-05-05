package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public boolean unique(int customerID, String flightNum) throws SQLException, ClassNotFoundException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		String sql = "select * from bookings where customerID = ? and flightNum = ? ";
		
			try {
		    myConn = DriverManager.getConnection
		      ("jdbc:mysql://localhost/airlinereservation" , "root" , "nodummies12345");
		    myStmt = myConn.prepareStatement(sql);
		    myStmt.setInt(1, customerID);
		    myStmt.setString(2, flightNum);
		    myRs = myStmt.executeQuery();
		    
		    if (myRs.next()) {
		    	return true;
		    }
		    else 
		    	return false;
			}
			
		    catch(Exception ex) {
				ex.printStackTrace();
			}
			finally {
			    myConn.close();
    		  }
			
			return false;
}
	// when ever book flights is clicked this method books the flight in bookings database
	public void book(int customerID, String flightNum) throws SQLException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		String sql = "insert into bookings values (?, ?, ?)";
		
		
			try {
			    myConn = DriverManager.getConnection
			      ("jdbc:mysql://localhost/airlinereservation" , "root" , "nodummies12345");
			    myStmt = myConn.prepareStatement(sql);
			    myStmt.setInt(1, 0);
			    myStmt.setInt(2, customerID);
			    myStmt.setString(3, flightNum);
			    myStmt.executeUpdate();
		 	}
		 		    catch(Exception ex) {
		 				ex.printStackTrace();
		 			}
		 			finally {
		 			    myConn.close();
		     		  }
	}
	//when user presses delete flight this method is called and deletes the flight from bookings
	public void deleteBook(int customerID, String flightNum) throws SQLException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		String sql = "delete from bookings where customerID = " + "'" + customerID + "'" 
				+ "and flightNum = " + "'" + flightNum + "'";
	
			try {
			    myConn = DriverManager.getConnection
			      ("jdbc:mysql://localhost/airlinereservation" , "root" , "nodummies12345");
			    myStmt = myConn.prepareStatement(sql);
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
