package ClassModel;

public class Client {
	

    private int idClient;
	private String nomClient;
	private String prenomClient;
	private String adresseClient;
	private String nationnalite;
	private String emailClient;
	private String sexeClient;
	private String teleClient;
	
	
	
	
	public Client() {
		super();
	}
	
	
	
	
	public String getTeleClient() {
		return teleClient;
	}




	public void setTeleClient(String teleClient) {
		this.teleClient = teleClient;
	}




	public Client(int id,String nom,String prenom,String adres,String natio,
			String email,String tele,String sexe) {
		super();
		nomClient=nom;
		prenomClient=prenom;
		adresseClient=adres;
		nationnalite=natio;
		idClient=id;
		emailClient=email;
		sexeClient=sexe;
		teleClient=tele;
		
	    }
	
	
	
	
	public Client(String nom,String prenom,String adres,String natio,
			String email,String tele,String sexe) {
		super();
		nomClient=nom;
		prenomClient=prenom;
		adresseClient=adres;
		nationnalite=natio;
		emailClient=email;
		sexeClient=sexe;
		teleClient=tele;
		
	    }
	
	
	
	public int getIdClient() {
		return idClient;
	}
	
	
	public void setIdClient(int idClient) {
		idClient = idClient;
	}
	
	public String getNomClient() {
		return nomClient;
	}
	
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	
	public String getPrenomClient() {
		return prenomClient;
	}
	
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	
	public String getAdresseClient() {
		return adresseClient;
	}
	
	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}
	
	public String getNationnalite() {
		return nationnalite;
	}
	
	public void setNationnalite(String nationnalite) {
		nationnalite = nationnalite;
	}
	
	
	public String getEmailClient() {
		return emailClient;
	}
	public void setEmailClient(String emailClient) {
		emailClient = emailClient;
	}
	public String getSexeClient() {
		return sexeClient;
	}
	public void setSexeClient(String sexeClient) {
		sexeClient = sexeClient;
	}

}
