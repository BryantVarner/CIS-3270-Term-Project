package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminData {
	
	// checks if password and username are correct for admin
	
	public boolean adminPass(String user, String pass) throws SQLException, ClassNotFoundException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		String sql = "select * from admin where username = ? and password = ? ";
		
			try {
		    myConn = DriverManager.getConnection
		      ("jdbc:mysql://localhost/airlinereservation" , "root" , "nodummies12345");
		    myStmt = myConn.prepareStatement(sql);
		    myStmt.setString(1, user);
		    myStmt.setString(2, pass);
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

	public void deleteFlight(String flightNum) throws SQLException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		String sql = "delete from flights where flightnum = ? ";

			try {
			    myConn = DriverManager.getConnection
			      ("jdbc:mysql://localhost/airlinereservation" , "root" , "nodummies12345");
			    myStmt = myConn.prepareStatement(sql);
			    myStmt.setString(1, flightNum);
			    myStmt.executeUpdate();
		 	}
		    catch(Exception ex) {
		    		ex.printStackTrace();
		 	}
			finally {
				    myConn.close();
			}
	}
	
	public boolean checkCustomerBookings(String flightNum) throws SQLException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		String sql = "select * from bookings where flightnum = ? ";
		
		try {
	    myConn = DriverManager.getConnection
	      ("jdbc:mysql://localhost/airlinereservation" , "root" , "nodummies12345");
	    myStmt = myConn.prepareStatement(sql);
	    myStmt.setString(1, flightNum);
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
			
			return true;
	}

	public void deleteFlightBooks(String flightNum) throws SQLException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		String sql = "delete from bookings where flightNum = " + "'" + flightNum + "'";
	
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


