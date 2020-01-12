package ClassModel;
import java.util.Date;

import ClassModel.Chambre;

public class Reservation {
	private int idReservation;
	private Date dateReservation;
	private Date dateDepart;
	private Date dateArrive;
	private Chambre chambre;
	private Client client;
	private Hotel hotel;

	public int getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date date) {
		this.dateReservation = date;
	}
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date date) {
		this.dateDepart = date;
	}
	public Date getDateArrive() {
		return dateArrive;
	}
	public void setDateArrive(Date date) {
		this.dateArrive = date;
	}
	public Chambre getChambre() {
		return chambre;
	}
	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Reservation(int idReservation, Date dateReservation,Date dateDepart,Date dateArrive, Chambre chambre,
			Client client, Hotel hotel) {
		super();
		this.idReservation = idReservation;
		this.dateReservation = dateReservation;
		this.dateDepart = dateDepart;
		this.dateArrive = dateArrive;
		this.chambre = chambre;
		this.client = client;
		this.hotel = hotel;

	}
	public Reservation(Date dateReservation,Date dateDepart,Date dateArrive, Chambre chambre, Client client, Hotel hotel) {
		super();
		this.dateReservation = dateReservation;
		this.dateDepart = dateDepart;
		this.dateArrive = dateArrive;
		this.chambre = chambre;
		this.client = client;
		this.hotel = hotel;
		
	}
	public Reservation() {
		super();
		
	}


}
