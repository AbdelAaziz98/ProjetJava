package ImplementInterfDao;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import InterfaceDao.IUser;
import MainConn.ConnexionDB;

public class ImplUserDao implements IUser {
	
	@Override
	public boolean verifiermdp(String a) throws ClassNotFoundException {
		
		boolean bool=false;
		//ConnexionDB conn=new ConnexionDB();
		//try {
			/*Statement st=(Statement) conn.getConn().createStatement();
			ResultSet rs=((java.sql.Statement) st).executeQuery("select Mdp from user where Mdp like '%" + a + "%'");
			while(rs.next()) {
				if(rs.getString("Mdp").equals(a)) {*/
			if(a.equals("root")) {
				
				
					bool=true;
				}
				
			
		/*} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println(bool);
		return bool;
	}

	@Override
	public boolean verifiername(String a) throws ClassNotFoundException {
		
		boolean bool=false;
		/*ConnexionDB conn=new ConnexionDB();
		try {
			Statement st=(Statement) conn.getConn().createStatement();
			ResultSet rs=((java.sql.Statement) st).executeQuery("select Name from user where Name like '%" + a + "%'");
			while(rs.next()) {
				if(rs.getString("Name").equals(a)) {
					bool=true;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		if(a.equals("root")) {bool=true;
		}
		
		return bool;
	}

}



