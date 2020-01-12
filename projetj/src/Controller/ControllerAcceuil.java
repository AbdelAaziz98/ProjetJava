package Controller;

	import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;

import ClassModel.Reservation;
import ImplementInterfDao.ImplReservationDao;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

	public class ControllerAcceuil implements Initializable{ 
		
		@FXML private Pane resa;
		@FXML private TableView<Reservation> tableview;
		@FXML private TableColumn<Reservation, Integer> idres;
		@FXML private TableColumn<Reservation, Date> dateresa;
		@FXML private TableColumn<Reservation, Date> datedepart;
		@FXML private TableColumn<Reservation, Date> datearrive;
		@FXML private TableColumn<Reservation, Integer> idchambre;
		@FXML private TableColumn<Reservation, Integer> idhotel;
		@FXML private TableColumn<Reservation, Integer> idclient;
		@FXML private Label nbrligne;
		public ObservableList<Reservation> data=FXCollections.observableArrayList();
		
	
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			
			
			  ImplReservationDao rimp=new ImplReservationDao();
			  
			  data.addAll(rimp.listerReservation()); idres.setCellValueFactory(new
			  PropertyValueFactory<Reservation,Integer>("idReservation"));
			  dateresa.setCellValueFactory(new
			  PropertyValueFactory<Reservation,Date>("dateReservation"));
			  datedepart.setCellValueFactory(new
			  PropertyValueFactory<Reservation,Date>("dateDepart"));
			  datearrive.setCellValueFactory(new
			  PropertyValueFactory<Reservation,Date>("dateArrive"));
			  idchambre.setCellValueFactory(new
			  PropertyValueFactory<Reservation,Integer>("chambre"));
			  
			  idclient.setCellValueFactory(new
			  PropertyValueFactory<Reservation,Integer>("client"));
			  idhotel.setCellValueFactory(new
			  PropertyValueFactory<Reservation,Integer>("hotel"));
			  tableview.setItems(data);
			  try {
				nbrligne.setText(Integer.toString(ImplReservationDao.nombreLigne()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			
		}
	@FXML
public void AjouterResa(ActionEvent event) throws IOException {
		  FXMLLoader loader=new FXMLLoader();
			 
			
			Parent parent=FXMLLoader.load(getClass().getResource("/InterfaceView/ViewAjoutClient.fxml"));
			System.out.println("load");
			Scene scene=new Scene(parent);
			Stage window=(Stage) (((Node) event.getSource()).getScene().getWindow());
			window.setScene(scene);
			window.show();
}
	@FXML
public void supprimer(ActionEvent e) throws ClassNotFoundException {
	Reservation a=tableview.getSelectionModel().getSelectedItem();
	ImplReservationDao imp=new ImplReservationDao();
	imp.supprimerReservation(a.getIdReservation());
	tableview.getItems().removeAll(tableview.getSelectionModel().getSelectedItems());
	 
	
}
public void modifier(ActionEvent e) {
/*	Reservation a=tableview.getSelectionModel().getSelectedItem();
	 FXMLLoader loader=new FXMLLoader();
	 String url="/View/ModifClient.fxml";
	 loader.setLocation(getClass().getResource(url));
	
Parent parent;
try {
	
	parent = loader.load();
	Scene scene=new Scene(parent);
	  ModifClientController rc=loader.getController();
	 rc.resa=a;
	 System.out.println("resa c'est"+rc.resa.getIdReservation());


Stage window=(Stage) ((Node)e.getSource()).getScene().getWindow();

window.setScene(scene);
window.show();
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}*/

	

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
       void toViewClient(MouseEvent event) throws IOException {
    	   
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
	}
	


