package InterfaceDao;
import java.util.List;

import ClassModel.Facture;

public interface IFacture {
	public void ajouter(Facture f);
	public void supprimer(Facture facture);
	public List<Facture> lister();
	public void genererFacture();

}
