package Controller;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import ClassModel.Chambre;
import ImplementInterfDao.ImplChambreDao;
import MainConn.ConnexionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerChambre implements Initializable{
	

	    @FXML private TableView<Chambre> table;
	    @FXML private TableColumn<Chambre,Integer> Id_Chambre;
	    @FXML private TableColumn<Chambre,String> Id_Hotel;
	    @FXML private TableColumn<Chambre,Boolean> Etat_Chambre;
	    @FXML private TableColumn<Chambre,Float> Prix_Chambre;
	    @FXML private TableColumn<Chambre,String> Categorie_Chambre;
	    @FXML private Button modifierButton;
	    @FXML private Button supprimerButton;
	    @FXML private Button ajouterButton;
	    @FXML private Button closeButton;
	    @FXML private TextField idChambre;
	    @FXML private TextField idHotel;
	    @FXML private TextField prixChambre;
	    @FXML private TextField categorieChambre;

		
		Chambre chambre= new Chambre();
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
		/*
		 * try { ConnexionDB conn=new ConnexionDB(); } catch (ClassNotFoundException e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); } ImplChambreDao
		 * list=new ImplChambreDao(); ArrayList<Chambre> chambres; try { chambres =
		 * list.listerChambre(); ObservableList<Chambre>
		 * obserlist=FXCollections.observableArrayList(chambres);
		 * 
		 * Id_Chambre.setCellValueFactory(new
		 * PropertyValueFactory<Chambre,Integer>("idChambre"));
		 * Id_Hotel.setCellValueFactory(new
		 * PropertyValueFactory<Chambre,String>("idHotel"));
		 * Etat_Chambre.setCellValueFactory(new
		 * PropertyValueFactory<Chambre,Boolean>("etatChambre"));
		 * Prix_Chambre.setCellValueFactory(new
		 * PropertyValueFactory<Chambre,Float>("prixChambre"));
		 * Categorie_Chambre.setCellValueFactory(new
		 * PropertyValueFactory<Chambre,String>("categorieChambre"));
		 * table.setItems(obserlist);
		 * 
		 * } catch (ClassNotFoundException | SQLException e) { // TODO Auto-generated
		 * catch block e.printStackTrace();
		 */
			}
			
			
		
		@FXML
		public void close(ActionEvent event) {
			Stage stage = new Stage();
			Node source = (Node) event.getSource();
			stage = (Stage) source.getScene().getWindow();
			stage.close();
		    
		}
		
		@FXML
		public void ajoutChambre(ActionEvent event) throws IOException {
			
		    FXMLLoader loader=new FXMLLoader();
			loader.setLocation(getClass().getResource("/InterfaceView/ViewAjoutChambre.fxml"));
			AnchorPane root =loader.load();
			Scene scene = new Scene(root);
			Stage primaryS = (Stage) (((Node) event.getSource()).getScene().getWindow());
			primaryS.setScene(scene);
			primaryS.show();

		}
		
		@FXML
		void selectionnerChambre() {
			
			  Chambre chambre=table.getSelectionModel().getSelectedItem();
		       if(chambre != null) {
		    	//idHotel.setText(Integer.toString(chambre.getIdHotel()));
				prixChambre.setText(Float.toString(chambre.getPrixChambre()));
				categorieChambre.setText(chambre.getCategorieChambre());
				idChambre.setText(Integer.toString(chambre.getIdChambre()));
		    }
		  }

		@FXML
		void supprimerChambre(ActionEvent event) throws ClassNotFoundException, Throwable {
	    	chambre=table.getSelectionModel().getSelectedItem();
	    	table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
	    	 //MetierClient metClient=new MetierClient();
	    	ImplChambreDao chambre1 = new ImplChambreDao();
	         chambre1.supprimerChambre(chambre);
	    }

		@FXML
		void modifierChambre(ActionEvent event) throws ClassNotFoundException, Throwable {
	  	 
	  	  int idCh=Integer.parseInt(idChambre.getText());
	  	  float prixCh=Float.parseFloat(prixChambre.getText());
	      String categorieCh=categorieChambre.getText();
	        
	        Chambre chambre=new Chambre(idCh,prixCh,categorieCh); 
	  	
	  	ImplChambreDao chambre1 = new ImplChambreDao();
	  	  chambre1.modifierChambre(chambre);
	  	 
	  	  table.refresh();
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
