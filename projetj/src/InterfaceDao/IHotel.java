package InterfaceDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ClassModel.Hotel;

public interface IHotel {

	public ArrayList<Hotel> listerHotel() throws ClassNotFoundException, SQLException;
	public Hotel chercherHotel(int id) throws ClassNotFoundException, SQLException; 
	public void ajouterHotel(Hotel hotel) throws ClassNotFoundException, SQLException;
	public boolean modifierHotel(Hotel hotel) throws ClassNotFoundException, SQLException;
	public boolean supprimerHotel(int id) throws ClassNotFoundException, SQLException;
}
