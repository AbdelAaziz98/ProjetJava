package ImplementInterfDao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ClassModel.Facture;
import InterfaceDao.IFacture;
import MainConn.ConnexionDB;

public class ImplFactureDao implements IFacture{

	@Override
	public void ajouter(Facture facture) { 
			ConnexionDB conn = new ConnexionDB();
			Statement st= conn.getConn().createStatement();
 int rs=st.executeUpdate("insert into Facture(Id_Facture,Duree,DateFacture) values("+"\""+facture.getIdFacture()+"\""+","+ ""+"\""+facture.getDuree()+"\""+","+ ""+"\""+facture.getDateFacture()+"\""+")");
   if(rs==1) System.out.println("ajout bien passe");
   else  System.out.println("ajout non passe");
   conn.close();
		}

	@Override
	public void supprimer(Facture facture) {
		ConnexionDB conn = new ConnexionDB();
		Statement st = conn.getConn().createStatement();
		//st.executeUpdate("DELETE FROM Facture WHERE Id_Facture="+facture.getId_Facture()) ;
	}
		


	@Override
	public ArrayList<Facture> lister() { 
			ConnexionDB conn = new ConnexionDB();
			Statement st = conn.getConn().createStatement();
			ResultSet rs=st.executeQuery("select * from Facture");
			ArrayList<Facture> listeFactures=new ArrayList<Facture>();
			try {
				while(rs.next()) {
					listeFactures.add(new Facture(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4),rs.getFloat(5)));
				}
			}
			catch(SQLException e) {
				e.printStackTrace();}
			finally {
				conn.closeConnexion();
			}
	return listeFactures;
	}

	


	@Override
	public void genererFacture() {
		// TODO Auto-generated method stub
		
	}
}
