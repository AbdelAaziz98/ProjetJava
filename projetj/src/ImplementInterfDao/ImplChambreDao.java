package ImplementInterfDao;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ClassModel.Chambre;
import MainConn.ConnexionDB;

public class ImplChambreDao {

	
	public void ajouterChambre(Chambre chambre) throws ClassNotFoundException, SQLException {
		ConnexionDB conn = new ConnexionDB();
	
		java.sql.Statement st=conn.getConn().createStatement();
		((java.sql.Statement) st).executeUpdate("INSERT INTO Chambre (Prix_Chambre,Categorie_Chambre) values("+"\""+chambre.getPrixChambre()+"\""+","
				+"\""+chambre.getCategorieChambre()+"\""+")"+";");
	}

	public void etatChambre(Chambre chambre) throws ClassNotFoundException, SQLException {
		ConnexionDB conn = new ConnexionDB();
		Statement st=(Statement) conn.getConn().createStatement();
		((java.sql.Statement) st).executeUpdate("UPDATE Chambre SET "+chambre.getEtatChambre()+"= false");
	}
	
	public void modifierChambre(Chambre chambre) throws ClassNotFoundException, SQLException{
		
		ConnexionDB conn = new ConnexionDB();
		Statement st=(Statement) conn.getConn().createStatement();
		((java.sql.Statement) st).executeUpdate("UPDATE Chambre SET Categorie_Chambre="+chambre.getCategorieChambre()+", Prix_Chambre=" +chambre.getPrixChambre()+"where Id_Chambre="+chambre.getIdChambre());
		System.out.println("1");
	}

	public void supprimerChambre(Chambre chambre) throws ClassNotFoundException, SQLException{
		ConnexionDB conn = new ConnexionDB();
		Statement st=(Statement) conn.getConn().createStatement();
		((java.sql.Statement) st).executeUpdate("DELETE FROM Chambre WHERE Id_Chambre="+chambre.getIdChambre()) ;
	}
	
	public ArrayList<Chambre> listerChambre() throws ClassNotFoundException, SQLException{
		ConnexionDB conn = new ConnexionDB();
		java.sql.Statement st=conn.getConn().createStatement();
		ResultSet rs=((java.sql.Statement) st).executeQuery("Select * from Chambre");
		ArrayList<Chambre> listeChambres=new ArrayList<Chambre>();
     	try {
			while(rs.next()) {
				listeChambres.add(new Chambre(rs.getInt(1),rs.getBoolean(3),rs.getFloat(4),rs.getString(5)));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return listeChambres;
		
	}
	static public Chambre returnChambre(String a)  {
		boolean bool=true;
		Chambre chambre=new Chambre();
		ConnexionDB conn = null;
		try {
			conn = new ConnexionDB();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		java.sql.Statement st = null;
		try {
			st =  conn.getConn().createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ResultSet myrs=((java.sql.Statement) st).executeQuery("select * from chambre where Categorie_Chambre like '%" + a + "%'");
			while(myrs.next()) {
				chambre.setIdChambre(myrs.getInt(1));
				chambre.setCategorieChambre(myrs.getString(2));
				chambre.setPrixChambre(Float.parseFloat(myrs.getString(4)));
				if(myrs.getString(3).equals("disponible")) {
					bool=false;
				}
				chambre.setEtatChambre(bool);


				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return chambre;
		
	}

}