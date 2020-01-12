package InterfaceDao;
import java.sql.SQLException;
import java.util.List;

import ClassModel.Chambre;

public interface IChambre {
	public void ajouterChambre(Chambre chambre) throws ClassNotFoundException, SQLException;
	public void modifierChambre(Chambre chambre) throws ClassNotFoundException, SQLException;
	public void supprimerChambre(Chambre chambre) throws ClassNotFoundException, SQLException;
	public void etatChambre(Chambre chambre) throws ClassNotFoundException, SQLException;
	public List<Chambre> listerChambre() throws ClassNotFoundException, SQLException;
}