package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import ClassModel.Hotel;
import ImplementInterfDao.ImplHotelDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerHotelAjout implements Initializable{

	@FXML private TextField nom;
	@FXML private TextField ville;
	@FXML private TextField adresse;
	@FXML private TextField email;
	@FXML private TextField tel;
	@FXML private TextField categorie;
	@FXML private TextArea description;
	@FXML private AnchorPane rootPane;
	

	@FXML
    private void onButtonAjouterHotel(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
    	Hotel hotel=new Hotel(nom.getText(),ville.getText(),adresse.getText(),
    			email.getText(),tel.getText(),categorie.getText(),description.getText());
	    ImplHotelDao hotel1 = new ImplHotelDao();
	    hotel1.ajouterHotel(hotel);
		
		Parent parent=FXMLLoader.load(getClass().getResource("/InterfaceView/ViewHotel.fxml"));
		Scene scene=new Scene(parent);
		Stage window=(Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();
	}
	
	@FXML
	private void back(ActionEvent event) throws IOException {
		Parent parent=FXMLLoader.load(getClass().getResource("/InterfaceView/ViewHotel..fxml"));
		Scene scene=new Scene(parent);
		Stage window=(Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
    	
		
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
