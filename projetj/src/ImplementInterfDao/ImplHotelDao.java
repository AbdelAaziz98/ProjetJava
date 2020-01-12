package ImplementInterfDao;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ClassModel.Hotel;
import InterfaceDao.IHotel;
import MainConn.ConnexionDB;

public class ImplHotelDao implements IHotel{
	
	static public Hotel returnHotel(String a) throws ClassNotFoundException, SQLException {
		Hotel hotel=new Hotel();
		ConnexionDB conn=new ConnexionDB();
		java.sql.Statement st =  conn.getConn().createStatement();
		
		try {
			ResultSet myrs=((java.sql.Statement) st).executeQuery("select * from hotel where Nom_Hotel like '%" + a + "%'");
			while(myrs.next()) {
				hotel.setIdHotel(myrs.getInt(1));
				hotel.setNom(myrs.getString(2));
				hotel.setTel(myrs.getString(3));
				hotel.setEmail(myrs.getString(4));
				hotel.setVille(myrs.getString(5));
				hotel.setCategorie(myrs.getString(6));
				hotel.setDescription(myrs.getString(7));


				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotel;
	}


		public ArrayList<Hotel> listerHotel() throws ClassNotFoundException, SQLException {
			ConnexionDB conn=new ConnexionDB();
			java.sql.Statement st = conn.getConn().createStatement();
			ResultSet rs=((java.sql.Statement) st).executeQuery("select * from hotel");
			ArrayList<Hotel> listHotels=new ArrayList<Hotel>();
			try{
				while(rs.next()) {
					listHotels.add(new Hotel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
		        		rs.getString(5),rs.getString(6),rs.getString(7),null));
				}
			
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				conn.close();
			}
			return listHotels;
		}
		
		public Hotel chercherHotel(int id) throws ClassNotFoundException, SQLException {
			
			Hotel hotel=null;
			ConnexionDB conn=new ConnexionDB();
			java.sql.Statement st= conn.getConn().createStatement();
			ResultSet rs=st.executeQuery("select * from hotel where id=" +id);
			
			try{
				if(rs.next()) {
					hotel=new Hotel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
		        		rs.getString(5),rs.getString(6),rs.getString(7),null);
					
					return hotel;
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				conn.close();
			}
			System.out.println("Nous n'avons pas trouvé un hotel avec ID : " +id +" .");
			return null;
		
		}
		
		public void ajouterHotel(Hotel hotel) throws ClassNotFoundException, SQLException {
			
			ConnexionDB conn=new ConnexionDB();
			java.sql.Statement st= conn.getConn().createStatement();
					try { int r=st.executeUpdate("insert into hotel(Nom_Hotel,Ville_Hotel,Adresse_Hotel,"
					 		+ "Email_Hotel,Tel_Hotel,Categorie_Hotel,Description_Hotel) "
					 		+ "values("+"\""+
				hotel.getNom()+"\""+","+"\""+hotel.getVille()+"\""+","
						+"\""+hotel.getAdresse()+"\""+","+"\""+hotel.getEmail()+"\""+","+"\""+hotel.getTel()+"\""+","+"\""+
				hotel.getCategorie()+"\""+","+"\""+hotel.getDescription()+"\""+")"+";");
					 if(r==1) System.out.println("ajout bien passée! ");
					 else System.out.println("ajout error!");
					}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				conn.close();
			}
			
		}
		
		
		public boolean modifierHotel(Hotel hotel) throws ClassNotFoundException, SQLException {
			ConnexionDB conn = new ConnexionDB();
			java.sql.Statement st= conn.getConn().createStatement();
			
			ResultSet resultSet = st.executeQuery("select * from hotel where id_hotel=" + hotel.getId());
			try {
				if (!resultSet.next()) {
					System.out.println("No hotel exists with that id");
					return false;
				}
				int result = st.executeUpdate("update hotel set nom_hotel='" + hotel.getNom() +"',ville_hotel='" + hotel.getVille() +
						"',adresse_hotel='" + hotel.getAdresse() + 	"',email_hotel='" + hotel.getEmail() + 	"',tel_hotel='" + hotel.getTel() + "',categorie_hotel='"
						+ hotel.getCategorie() + "' where id_hotel=" + hotel.getId());
				if (result == 1) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}
			System.out.println("Update doesn't applied successfully!");
			return false;
			
		}
		
		
		public boolean supprimerHotel(int id) throws ClassNotFoundException, SQLException {
			ConnexionDB conn = new ConnexionDB();
			java.sql.Statement st=conn.getConn().createStatement();
			ResultSet resultSet = st.executeQuery("select * from hotel where id_hotel=" + id);

			try {
				if (!resultSet.next()) {
					System.out.println("No hotel exists with that id");
					return false;
				}
				int result = st.executeUpdate("delete from hotel where id_hotel=" + id);
				if (result == 1) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}
			System.out.println("deleting doesn't applied successfully!");
			return false;
		}
		


}
