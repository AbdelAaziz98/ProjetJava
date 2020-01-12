package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import ClassModel.Client;
import ImplementInterfDao.ImplClientDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerClientAjout implements Initializable{
	@FXML private TextField nom;
	@FXML private TextField prenom;
	@FXML private TextField nationalite;
	@FXML private ChoiceBox sexe;
	@FXML private TextField telephone;
	@FXML private TextField adresse;
	@FXML private TextField email;
	ObservableList<String> choixsexe=FXCollections.observableArrayList("male","female");
	private Scene scene;


		@FXML
		public void suivant(ActionEvent e) throws IOException, SQLException, ClassNotFoundException {
			
		
			  String nomm=nom.getText(); String prenomm=prenom.getText(); String
			  nationalitee=nationalite.getText(); String sexee=(String) sexe.getValue();
			  String telephonee=telephone.getText(); String adressee=adresse.getText();
			  String emaill=email.getText(); 
			Client client22=new Client(ImplClientDao.dernierIdClient()+1,nomm, prenomm, adressee, nationalitee, emaill, telephonee, sexee);
			
			
			 FXMLLoader loader=new FXMLLoader();
			 String url="/InterfaceView/ViewAjoutReservation.fxml";
			 loader.setLocation(getClass().getResource(url));
			
		Parent parent=loader.load();
		Scene scene=new Scene(parent);
			
			  ControllerReservation rc=loader.getController();
			  rc.selectedclient=client22;
		
		Stage window=(Stage) ((Node)e.getSource()).getScene().getWindow();

		window.setScene(scene);
		window.show();
		
		 
		
			
		}
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			sexe.setValue("male");
			sexe.setItems(choixsexe);
			
		}

}
