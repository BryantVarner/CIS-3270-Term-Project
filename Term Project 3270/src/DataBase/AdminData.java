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

}
