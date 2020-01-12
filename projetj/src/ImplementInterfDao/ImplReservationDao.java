package ImplementInterfDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ClassModel.Chambre;
import ClassModel.Client;
import ClassModel.Hotel;
import ClassModel.Reservation;
import InterfaceDao.IReservation;
import MainConn.ConnexionDB;

public class ImplReservationDao implements IReservation{

	public int ajouterReservation(Reservation res) throws ClassNotFoundException {
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");  
        
		int r = 0;
		ConnexionDB conn=new ConnexionDB();
		
		try {
			PreparedStatement ps=conn.getConn().prepareStatement("INSERT INTO reservation(Date_Reservation,Date_Depart,Date_Arrive,Id_Chambre,Id_Client,Id_Hotel"
					+ ") VALUES(?,?,?,?,?,?)");
            String datearrive = dateFormat.format(res.getDateArrive());  
            String datedepart = dateFormat.format(res.getDateDepart());  
             String dateresa=dateFormat.format(res.getDateReservation());
			ps.setString(1,dateresa);
			ps.setString(2,datedepart);
			ps.setString(3,datearrive);
			ps.setInt(4,res.getChambre().getIdChambre());
			ps.setInt(5,res.getClient().getIdClient());
			ps.setInt(6,res.getHotel().getIdHotel());
			r=ps.executeUpdate();
ps.close();




			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}


		
	
    @Override
	public int supprimerReservation(int idReservation) throws ClassNotFoundException  {

			int r = 0;
			ConnexionDB conn=new ConnexionDB();
			try {
				PreparedStatement ps=conn.getConn().prepareStatement(" DELETE FROM Reservation WHERE Id_Reservation="+idReservation );
	         r=ps.executeUpdate();
	         
	          ps.close();




				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return r;
		}

		
	

	@Override
	public int modifierReservation(Reservation res) throws ClassNotFoundException {

		int r = 0;
		ConnexionDB conn=new ConnexionDB();
		try {
			PreparedStatement ps=conn.getConn().prepareStatement("UPDATE reservation SET Date_Reservation =?, Date_Depart=?"
					+ ",Date_Arrive=?, Id_Chambre=? , Id_Client=?,Id_Hotel=? WHERE Id_Reservation="+res.getIdReservation());
			 DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");  

			
		       String datearrive = dateFormat.format(res.getDateArrive());  
	            String datedepart = dateFormat.format(res.getDateDepart());  
	             String dateresa=dateFormat.format(res.getDateReservation());
				ps.setString(1,dateresa);
				ps.setString(2,datedepart);
				ps.setString(3,datearrive);
				ps.setInt(4,res.getChambre().getIdChambre());
				ps.setInt(5,res.getClient().getIdClient());
				ps.setInt(6,res.getHotel().getIdHotel());
				r=ps.executeUpdate();
	    ps.close();



			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return r;

		
	}

	@Override
	public List<Reservation> listerReservation() {
		List<Reservation> reservation=new ArrayList<Reservation>();
		ConnexionDB conn = null;
		try {
			conn = new ConnexionDB();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			PreparedStatement ps;
		ResultSet rs;
		try {
			ps=conn.getConn().prepareStatement("select * from reservation");
			rs = ps.executeQuery();
		
		while(rs.next()) {
				Reservation res=new Reservation();
				res.setIdReservation(rs.getInt(1));
				try {
					res.setDateReservation(new SimpleDateFormat("dd/mm/yyyy").parse(rs.getString(2)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					res.setDateDepart(new SimpleDateFormat("dd/mm/yyyy").parse(rs.getString(3)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					res.setDateArrive(new SimpleDateFormat("dd/mm/yyyy").parse(rs.getString(4)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
				PreparedStatement ps1=conn.getConn().prepareStatement("select * from chambre where Id_Chambre="+rs.getInt(5));
				ResultSet rs1=ps1.executeQuery();
				if(rs1.next()) {

					Chambre chambre=new Chambre();
					chambre.setIdChambre(rs1.getInt(1));
					chambre.setCategorieChambre(rs1.getString(2));
					chambre.setEtatChambre(Boolean.parseBoolean(rs1.getString(3)));
					res.setChambre(chambre);
					PreparedStatement ps2=conn.getConn().prepareStatement("select * from client where Id_Client="+rs.getInt(6));
					

					ResultSet rs2=ps2.executeQuery();
					if(rs2.next()) {
					Client client=new Client();
					client.setIdClient(rs2.getInt(1));
					res.setClient(client);
					PreparedStatement ps3=conn.getConn().prepareStatement("select * from hotel where Id_Hotel="+rs.getInt(7));
					ResultSet rs3=ps3.executeQuery();
					if(rs3.next()) {
					Hotel hotel=new Hotel();
					hotel.setIdHotel(rs3.getInt(1));
					res.setHotel(hotel);
				
					reservation.add(res);
					
					
					}
					
					}
					}
				}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
				
			
		
		return reservation;

		
	}
	static public ArrayList<String> nomChambre()  {
		ArrayList<String> noms=new ArrayList<String>();
		ConnexionDB conn = null;
		try {
			conn = new ConnexionDB();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Statement st = null;
		try {
			st = conn.getConn().createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ResultSet myrs=st.executeQuery("select Categorie_Chambre from chambre");
			while(myrs.next()) {
				noms.add(myrs.getString("Categorie_Chambre"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return noms;


}
	static public ArrayList<String> nomHotel()  {
		ArrayList<String> noms=new ArrayList<String>();
		ConnexionDB conn = null;
		try {
			conn = new ConnexionDB();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Statement st = null;
		try {
			st = conn.getConn().createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ResultSet myrs=st.executeQuery("select Nom_Hotel from hotel");
			while(myrs.next()) {
				noms.add(myrs.getString("Nom_Hotel"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return noms;
		
	}
	static public int nombreLigne()   {
		ConnexionDB conn = null;
		try {
			conn = new ConnexionDB();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement st = null;
		try {
			st = conn.getConn().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	ResultSet rs = null;
	try {
		rs = st.executeQuery("SELECT count(*) AS nbLignes FROM reservation ");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		int nbLignes=0; try {
			rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} try {
			nbLignes = rs.getInt("nbLignes");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nbLignes;
	}

	
}
