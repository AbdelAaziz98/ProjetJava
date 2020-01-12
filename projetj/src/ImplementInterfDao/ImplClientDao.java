package ImplementInterfDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ClassModel.Client;
import InterfaceDao.IClient;
import MainConn.ConnexionDB;

public class ImplClientDao implements IClient {
	@Override
	public int modifierClient(Client client) throws ClassNotFoundException, Throwable {
		
		ConnexionDB conn=new ConnexionDB();
		PreparedStatement ps = null;
		
		String sql="update client set Nom_Client=?,Prenom_Client=?,Adresse_Client=?,Nationnalite=?,Email_Client=?,Tele_Client=?,Sexe_Client=? where Id_Client=?";
		
		ps= conn.getConn().prepareStatement(sql);
		
		ps.setString(1,client.getNomClient());
		ps.setString(2,client.getPrenomClient());
		ps.setString(3,client.getAdresseClient());
		ps.setString(4,client.getNationnalite());
		ps.setString(5,client.getEmailClient());
		ps.setString(6,client.getTeleClient());
		ps.setString(7,client.getSexeClient());
		ps.setInt(8,client.getIdClient());
		int i=ps.executeUpdate();
	
		
		return i;
		
	}
	

	@Override
	public int supprimerClient(Client client) throws ClassNotFoundException, Throwable {
		ConnexionDB conn=new ConnexionDB();
		java.sql.Statement stat=conn.getConn().createStatement();	
		String sql="delete from client where Id_Client='"+client.getIdClient()+"' ";
		int i=stat.executeUpdate(sql);
		return i;
			
		
	}
   @Override
	public int ajouterClient(Client client) throws  SQLException, Throwable {
	
			
			ConnexionDB conn=new ConnexionDB();
			java.sql.Statement stat=conn.getConn().createStatement();
			
			
			String sql="insert into client"
		   +"(Nom_Client,Prenom_Client,Adresse_Client,	Nationalite,Email_Client,Sexe,Telephone)"
	        +"values('"+client.getNomClient()+"','"+client.getPrenomClient()+"','"+client.getAdresseClient()+"','"+client.getNationnalite()+"','"+client.getEmailClient()+"','"+client.getSexeClient()+"','"+client.getTeleClient()+"')";
			int i=stat.executeUpdate(sql);
			return i;
		
			}
	
   @Override
   public ResultSet  listerClient() throws ClassNotFoundException, Throwable{
		ConnexionDB conn=new ConnexionDB();
		
		java.sql.Statement stat=conn.getConn().createStatement();
		String sql="select *from client";
		  ResultSet rs=stat.executeQuery(sql);
		return rs;
		
	}
   public static int  dernierIdClient()   {
		ConnexionDB conn = null;
		try {
			conn = new ConnexionDB();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int count = 0;
		Statement st = null;
		try {
			st = conn.getConn().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet myrs = null;
		try {
			myrs = st.executeQuery("select * from client ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(myrs.next()) {
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return count;
	} 

}
