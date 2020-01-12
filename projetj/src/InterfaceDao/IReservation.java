package InterfaceDao;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import ClassModel.Reservation;

public interface IReservation {
	public int ajouterReservation(Reservation res) throws ClassNotFoundException;
	public int supprimerReservation(int idReservation) throws ClassNotFoundException, Throwable;
	public int modifierReservation(Reservation res) throws ClassNotFoundException;
	public List<Reservation> listerReservation() throws ParseException, ClassNotFoundException;


}
