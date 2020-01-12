package ClassModel;

import java.util.List;

public class Hotel {
	private int id;
	private String nom;
	private String ville;
	private String adresse;
	private String email;
	private String tel;
	private String categorie;
	private String description;
	
	public Hotel() {
		
	}
	
	public Hotel(String nom, String ville, String adresse, String email, String tel, String categorie, String description) {
		this.nom=nom;
		this.adresse=adresse;
		this.ville=ville;
		this.email=email;
		this.tel=tel;
		this.categorie=categorie;
		this.description=description;
	}
	
	public Hotel(int id, String nom, String ville, String adresse, String email, String tel, String categorie, String description) {
		this.id=id;
		this.nom=nom;
		this.adresse=adresse;
		this.ville=ville;
		this.email=email;
		this.tel=tel;
		this.categorie=categorie;
		this.description=description;
	}
	
	public Hotel(int id, String nom, String ville, String adresse, String email, String tel, String categorie) {
		this.id=id;
		this.nom=nom;
		this.adresse=adresse;
		this.ville=ville;
		this.email=email;
		this.tel=tel;
		this.categorie=categorie;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setNom(String nom) {
		this.nom=nom;
	}
	public String getNom() {
		return nom;
	}
	public void setVille(String v) {
		ville=v;
	}
	public String getVille() {
		return ville;
	}
	public void setAdresse(String ad) {
		this.adresse=ad;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public String getEmail() {
		return email;
	}
	public void setTel(String tel) {
		this.tel=tel;
	}
	public String getTel() {
		return tel;
	}
	public void setCategorie(String categ) {
		this.categorie=categ;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setDescription(String desc) {
		description=desc;
	}
	public String getDescription() {
		return description;
	}

	public void setIdHotel(int id) {
		this.id=id;
		
	}

	public int getIdHotel() {
		return id;
	}
	
}

