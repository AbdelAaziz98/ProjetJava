package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


import ClassModel.Chambre;
import ClassModel.Client;
import ClassModel.Hotel;
import ClassModel.Reservation;

import ImplementInterfDao.ImplChambreDao;
import ImplementInterfDao.ImplClientDao;
import ImplementInterfDao.ImplHotelDao;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControllerReservation implements Initializable{


	
	
	
	

  @FXML ObservableList<String>
	  choixhotel=FXCollections.observableArrayList(ImplReservationDao.nomHotel());
	  
	  @FXML ObservableList<String>
	  choixchambre=FXCollections.observableArrayList(ImplReservationDao.nomChambre());
	 
@FXML DatePicker dateresa;
@FXML DatePicker datedebut;
@FXML DatePicker datesortie;
@FXML ChoiceBox choix_hotel;
@FXML ChoiceBox choix_chambre;
@FXML Label resultat;
@FXML Label code;
 public Client selectedclient;
 public int samir;
public Reservation resa;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choix_hotel.setItems(choixhotel);
		choix_chambre.setItems(choixchambre);
		
	
	}
	public void fin(ActionEvent e) throws Throwable {
	System.out.println(samir);
		Chambre chambre=ImplChambreDao.returnChambre((String) choix_chambre.getValue());
		Hotel hotel=ImplHotelDao.returnHotel((String) choix_hotel.getValue());
		Reservation reservation=new Reservation();
		reservation.setChambre(chambre);
		System.out.println(selectedclient.getNomClient());
		reservation.setClient(selectedclient);
		reservation.setHotel(hotel);
		String date_resa=dateresa.getEditor().getText();
		String date_debut=datedebut.getEditor().getText();
		String date_fin=datesortie.getEditor().getText();
		Date date1=null;
	try {
		 date1 = new SimpleDateFormat("dd/mm/yyyy").parse(date_resa);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	Date date2=null;
	try {
		date2 = new SimpleDateFormat("dd/mm/yyyy").parse(date_debut);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	Date	date3=null;
	try {
			date3 = new SimpleDateFormat("dd/mm/yyyy").parse(date_fin);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
reservation.setDateReservation(date1);
reservation.setDateArrive(date2);
reservation.setDateDepart(date3);
ImplReservationDao imp=new ImplReservationDao();

imp.ajouterReservation(reservation);
ImplClientDao imp2=new ImplClientDao();
imp2.ajouterClient(selectedclient);
resultat.setText("Bien Enregistré");
resa=reservation;

		
	}
	public void retour(ActionEvent e) throws IOException {
		/* FXMLLoader loader=new FXMLLoader();
		 String url="/InterfaceView/ViewGenFacture.fxml";
		 loader.setLocation(getClass().getResource(url));
		
	Parent parent=loader.load();
	Scene scene=new Scene(parent);
	//scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());

		Stage window=(Stage) ((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}*/
		 FXMLLoader loader=new FXMLLoader();
		 String url="/InterfaceView/ViewGenFacture.fxml";
		 loader.setLocation(getClass().getResource(url));
		
	Parent parent=loader.load();
	Scene scene=new Scene(parent);
		
		 ControllerGenFacture rc=loader.getController();
		  rc.idClient.setText(Integer.toString(resa.getClient().getIdClient()));
		  rc.idResa.setText(Integer.toString(resa.getIdReservation()));
		  rc.reservationHotel.setText(resa.getHotel().getNom());
		  rc.chambre.setText(resa.getChambre().getCategorieChambre());
		  rc.montant.setText(Float.toString(resa.getChambre().getPrixChambre()));
		  
	
	Stage window=(Stage) ((Node)e.getSource()).getScene().getWindow();

	window.setScene(scene);
	window.show();
	

	}
}
