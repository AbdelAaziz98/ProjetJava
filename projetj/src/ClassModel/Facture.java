package ClassModel;

public class Facture {
	private int idFacture;
	private int montantFacture;
	private Reservation reservation;
	private long numFacture;
	
	
	public long getNumFacture() {
		return numFacture;
	}
	public void setNumFacture(long numFacture) {
		this.numFacture = numFacture;
	}
	public int getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}
	public int getMontantFacture() {
		return montantFacture;
	}
	public void setMontantFacture(int montantFacture) {
		this.montantFacture = montantFacture;
	}
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facture(int montantFacture, Reservation reservation) {
		super();
		this.montantFacture = montantFacture;
		this.reservation = reservation;
	}
	public Facture(int idFacture, int montantFacture, Reservation reservation) {
		super();
		this.idFacture = idFacture;
		this.montantFacture = montantFacture;
		this.reservation = reservation;
	}
	public Facture(int int1, String string, int int2, float float1, float float2) {
		// TODO Auto-generated constructor stub
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	/*public String getDuree() {
		return 
	}*/
	public String getDateFacture() {
		// TODO Auto-generated method stub
		return null;
	}


}
