package MainConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnexionDB {
	 private Connection conn;
	 private Statement stat;
    
	
	
	
	public  Connection getConn() {
		return conn;
	}


	public void setConn(Connection conn) {
		conn = conn;
	}

	
	public ConnexionDB() throws ClassNotFoundException {
		
		try {	
			System.out.println("I-2");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("I-3");
			
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
			
			
		}	  
			   
		 
	   catch(SQLException e) {
			 e.printStackTrace();
		   
	    }
		
		
	}

   public void close() throws ClassNotFoundException, SQLException {
	   ConnexionDB con=new ConnexionDB();
	   con.getConn().close();
   }
	


	public void setStat(Statement stat) {
		this.stat = stat;
	}

}
