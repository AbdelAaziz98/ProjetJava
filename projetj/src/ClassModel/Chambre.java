package ClassModel;

public class Chambre {
	private int idChambre;
	private boolean etatChambre=false;
	private float prixChambre;
	private String categorieChambre;
	private Hotel hotel;
	
	public Hotel getIdHotel() { return hotel; }
public void setIdHotel(Hotel id) { this.hotel=id; }
	
	public int getIdChambre() { return this.idChambre; }
	public void setIdChambre(int id) { this.idChambre=id; }
	
	public boolean getEtatChambre() { return this.etatChambre; }
	public void setEtatChambre(boolean e) { this.etatChambre=e; }
	
	public float getPrixChambre() { return this.prixChambre; }
	public void setPrixChambre(float string) { this.prixChambre=string; }
	
	public String getCategorieChambre() { return this.categorieChambre; }
	public void setCategorieChambre(String categ) { this.categorieChambre=categ; }
	
	public Chambre(int idHotel, int idChambre, boolean etatChambre, float prixChambre, String categorieChambre) {
		super();
//		this.Hotel.idHotel = idHotel;
		this.idChambre = idChambre;
		this.etatChambre = etatChambre;
		this.prixChambre = prixChambre;
		this.categorieChambre = categorieChambre;
//		this.hotel = hotel;
	}
	public Chambre() {
		super();
	}
	public Chambre(int idChambre , float prixChambre, String categorieChambre) {
		this.idChambre = idChambre;
		this.prixChambre = prixChambre;
		this.categorieChambre = categorieChambre;
	}
	public Chambre(float prixChambre, String categorieChambre) {
		this.prixChambre = prixChambre;
		this.categorieChambre = categorieChambre;
	}
	public Chambre(int idChambre, boolean etatChambre, float prixChambre, String categorieChambre) {
		super();
		this.idChambre = idChambre;
		this.etatChambre = etatChambre;
		this.prixChambre = prixChambre;
		this.categorieChambre = categorieChambre;

	}
	
}