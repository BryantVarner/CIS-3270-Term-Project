package DataBase;

import java.sql.*;

public class CustomerData extends FlightsData {
	
	// checks if password and username are correct
	
	public boolean pass(String user, String pass) throws SQLException, ClassNotFoundException {
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			String sql = "select * from customer where username = ? and password = ? ";
			
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
	
	public boolean checkUserName(String user, String securityAnswer) 
					throws SQLException, ClassNotFoundException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		String sql = "select * from customer where username = ? and securityAnswer = ? ";
		
			try {
		    myConn = DriverManager.getConnection
		      ("jdbc:mysql://localhost/airlinereservation" , "root" , "nodummies12345");
		    myStmt = myConn.prepareStatement(sql);
		    myStmt.setString(1, user);
		    myStmt.setString(2, securityAnswer);
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
	
	//when register is called all the users information is updated into database
	
	public void register(String firstName, String lastName, String email,
						String address, String username,
						String password, String ssn,
						String securityAnswer, String zipcode, String state, String birthday)
						throws SQLException, ClassNotFoundException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		String sql = "insert into customer values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
			try {
		    myConn = DriverManager.getConnection
		      ("jdbc:mysql://localhost/airlinereservation" , "root" , "nodummies12345");
		    myStmt = myConn.prepareStatement(sql);
		    
		    myStmt.setInt(1, 0);
		    myStmt.setString(2, firstName);	
		    myStmt.setString(3, lastName);
		    myStmt.setString(4, email);
		    myStmt.setString(5, address);
		    myStmt.setString(6, username);
		    myStmt.setString(7, password);
		    myStmt.setString(8, ssn);
		    myStmt.setString(9, securityAnswer);
		    myStmt.setString(10, zipcode);
		    myStmt.setString(11, state);
		    myStmt.setString(12, birthday);
		    
		    myStmt.executeUpdate();
			}
		    catch(Exception ex) {
				ex.printStackTrace();
			}
			finally {
			    myConn.close();
    		  }
			
	}
	
	// checks to see if the username is taken and returns false if username already exist.
	
	public boolean uniqueUser(String username) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		String sql = "select * from customer where username = ?";
		
			try {
		    myConn = DriverManager.getConnection
		      ("jdbc:mysql://localhost/airlinereservation" , "root" , "nodummies12345");
		    myStmt = myConn.prepareStatement(sql);
		    
		    myStmt.setString(1, username);
		    
		    myRs = myStmt.executeQuery();
		    
			    if (myRs.next()) {
			    	
			    	return false;
			    }
			    else { 
			    	
			    	return true;
			    }
			}
			 catch(Exception ex) {
					ex.printStackTrace();
			 }
			
			finally {
				myConn.close();	
			}
		return false;
	}
	
	// checks if password and username are correct for admin
	
		
		
	
	
	
}




