package Controller;

import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import ClassModel.Chambre;
import ImplementInterfDao.ImplChambreDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerChambreAjout implements Initializable{

	
	@FXML public TextField IdHotel;
	@FXML public TextField prixChambre;
	@FXML public TextField categorieChambre;
	@FXML public Button ajouterButton;
	@FXML public Button closeButton;
	@FXML public Button returnButton;

	

	@FXML
	private void ajouterChambre(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
		Chambre chambre = new Chambre(Float.parseFloat(prixChambre.getText()),categorieChambre.getText());
		ImplChambreDao chambre1 = new ImplChambreDao();
		chambre1.ajouterChambre(chambre);
		
		Parent parent=FXMLLoader.load(getClass().getResource("/InterfaceView/ViewChambre.fxml"));
		Scene scene=new Scene(parent);
		Stage window=(Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();

	}
	
	@FXML
	public void close(ActionEvent event) {
		Stage stage = new Stage();
		Node source = (Node) event.getSource();
		stage = (Stage) source.getScene().getWindow();
		stage.close();
	    
	}
	@FXML
	private void retour(ActionEvent event) throws IOException {
		Parent parent=FXMLLoader.load(getClass().getResource("/InterfaceView/ViewChambre.fxml"));
		Scene scene=new Scene(parent);
		Stage window=(Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();
	}
	@Override
	public void initialize(URL location, ResourceBundle ressources) {
		
    	
		
	}
	@FXML
	 void ToViewHotel(MouseEvent event) throws IOException {
		  
		   FXMLLoader loader=new FXMLLoader();
			 
			
			Parent parent=FXMLLoader.load(getClass().getResource("/InterfaceView/ViewHotel.fxml"));
			
			Scene scene=new Scene(parent);
			Stage window=(Stage) (((Node) event.getSource()).getScene().getWindow());
			window.setScene(scene);
			window.show();
	   }
	       @FXML
	       void ToViewClient(MouseEvent event) throws IOException {
	    	   
			   FXMLLoader loader=new FXMLLoader();
				 
				
				Parent parent=FXMLLoader.load(getClass().getResource("/InterfaceView/ViewClient.fxml"));
				
				Scene scene=new Scene(parent);
				Stage window=(Stage) (((Node) event.getSource()).getScene().getWindow());
				window.setScene(scene);
				window.show();
	       }
	       
	       
	       @FXML
		   void ToViewChambre(MouseEvent event) throws IOException {
			  
			   FXMLLoader loader=new FXMLLoader();
				 
				
				Parent parent=FXMLLoader.load(getClass().getResource("/InterfaceView/ViewChambre.fxml"));
				
				Scene scene=new Scene(parent);
				Stage window=(Stage) (((Node) event.getSource()).getScene().getWindow());
				window.setScene(scene);
				window.show();
		   }
	       @FXML
	       void ToViewReservation(MouseEvent event) throws IOException {
	    	   
			   FXMLLoader loader=new FXMLLoader();
				 
				
				Parent parent=FXMLLoader.load(getClass().getResource("/InterfaceView/ViewAcceuil.fxml"));
				
				Scene scene=new Scene(parent);
				Stage window=(Stage) (((Node) event.getSource()).getScene().getWindow());
				window.setScene(scene);
				window.show();
	       }

}
