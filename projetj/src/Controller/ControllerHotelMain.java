package Controller;

import java.io.IOException;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MainConn.ConnexionDB;
import ClassModel.Hotel;
import ImplementInterfDao.ImplHotelDao;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControllerHotelMain implements Initializable{

	ImplHotelDao list;
	ArrayList<Hotel> hotels;
	ObservableList<Hotel> oblist;

	
	@FXML private TableView<Hotel> table;
	@FXML private TableColumn<Hotel,Integer> id_hotel;
	@FXML private TableColumn<Hotel,String> nom_hotel;
	@FXML private TableColumn<Hotel,String> ville_hotel;
	@FXML private TableColumn<Hotel,String> adresse_hotel;
	@FXML private TableColumn<Hotel,String> email_hotel;
	@FXML private TableColumn<Hotel,String> tel_hotel;
	@FXML private TableColumn<Hotel,String> categorie_hotel;
	@FXML private TableColumn<Hotel,String> description_hotel;
	
	@FXML private TextField idMod;
	@FXML private TextField nomMod;
	@FXML private TextField villeMod;
	@FXML private TextField adresseMod;
	@FXML private TextField emailMod;
	@FXML private TextField telMod;
	@FXML private TextField categorieMod;
	@FXML private TextArea descriptionMod;
	@FXML private Label message;
	
	
	@FXML
	private void showMessage(String s) {
		 message.setText(s);
	 	 message.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
	 	FadeTransition ft = new FadeTransition(Duration.millis(5000),null);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.play();
        
        FadeTransition ft2 = new FadeTransition(
                Duration.millis(5000 + (5000 * .1)), message);
        ft2.setFromValue(1.0);
        ft2.setToValue(0.0);
        ft2.play();

	}
	
	
	@FXML
	private void refreshTable() throws ClassNotFoundException, SQLException {

		hotels=list.listerHotel();
		oblist=FXCollections.observableArrayList(hotels);
		table.setItems(oblist);
		
		idMod.setText(null);
		nomMod.setText(null);
		villeMod.setText(null);
		adresseMod.setText(null);
		emailMod.setText(null);
		telMod.setText(null);
		categorieMod.setText(null);
		descriptionMod.setText(null);
	 	
	}
	
	@FXML
	private void selectionner() {
		
		  Hotel hotel=table.getSelectionModel().getSelectedItem();
		   
	       if(hotel != null) {
	    	idMod.setText(Integer.toString(hotel.getId()));
			nomMod.setText(hotel.getNom());
			villeMod.setText(hotel.getVille());
			adresseMod.setText(hotel.getAdresse());
			emailMod.setText(hotel.getEmail());
			telMod.setText(hotel.getTel());
			categorieMod.setText(hotel.getCategorie());
			descriptionMod.setText(hotel.getDescription());

	    }
	  }

	@FXML
  private void onButtonModifierHotel(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
 	     int id=Integer.parseInt(idMod.getText()); 
 	     String nom=nomMod.getText();
       String ville=villeMod.getText();
       String adresse=adresseMod.getText();
       String email=emailMod.getText();
       String tel=telMod.getText();
       String categorie=categorieMod.getText();
       String description=descriptionMod.getText();
       
       Hotel hotel=new Hotel(id,nom,ville,adresse,email,tel,categorie,description); 
 	     ImplHotelDao h=new ImplHotelDao();
 	  h.modifierHotel(hotel);
 	 refreshTable();
 	 showMessage("    Modification avec succès.  ");
    }
	
	@FXML
	void onButtonSupprimerHotel(ActionEvent event) throws ClassNotFoundException, Throwable {
    	Hotel hotel=table.getSelectionModel().getSelectedItem();
    	table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
    	 ImplHotelDao h=new ImplHotelDao();
         h.supprimerHotel(hotel.getId());
         showMessage("    Suppression avec succès.  ");
    }
		
	
	
	@FXML
    private void onButtonAjoutHotel(ActionEvent event) throws IOException {
		Parent parent=FXMLLoader.load(getClass().getResource("/InterfaceView/ViewAjoutHotel.fxml"));
		Scene scene=new Scene(parent);
		Stage window=(Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		list=new ImplHotelDao();
		try {
			hotels=list.listerHotel();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		oblist=FXCollections.observableArrayList(hotels);

		id_hotel.setCellValueFactory(new PropertyValueFactory<Hotel,Integer>("id"));
		nom_hotel.setCellValueFactory(new PropertyValueFactory<Hotel,String>("nom"));
		ville_hotel.setCellValueFactory(new PropertyValueFactory<Hotel,String>("ville"));
		adresse_hotel.setCellValueFactory(new PropertyValueFactory<Hotel,String>("adresse"));
		email_hotel.setCellValueFactory(new PropertyValueFactory<Hotel,String>("email"));
		tel_hotel.setCellValueFactory(new PropertyValueFactory<Hotel,String>("tel"));
		categorie_hotel.setCellValueFactory(new PropertyValueFactory<Hotel,String>("categorie"));
		description_hotel.setCellValueFactory(new PropertyValueFactory<Hotel,String>("description"));
		
		table.setItems(oblist);
		
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
