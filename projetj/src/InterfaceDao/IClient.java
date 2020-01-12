package InterfaceDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import ClassModel.Client;

public interface IClient {
	   int ajouterClient(Client client) throws SQLException, Throwable;
		int modifierClient(Client client) throws ClassNotFoundException, Throwable;
		ResultSet listerClient() throws ClassNotFoundException, Throwable;
		int supprimerClient(Client client) throws ClassNotFoundException, Throwable;

}
