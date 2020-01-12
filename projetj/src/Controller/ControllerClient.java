package Controller;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerClient implements Initializable{
	
	
	
		
		
	

	    @FXML
	    private Button ModifierB;

	    @FXML
	    private Button SupprimerB;
	   

	    @FXML
	    private TableView<Client> tableView;

	    @FXML
	    private TableColumn<Client,String> idCol;

	    @FXML
	    private TableColumn<Client, String> nomCol;

	    @FXML
	    private TableColumn<Client, String> prenomCol;

	    @FXML
	    private TableColumn<Client, String> adresseCol;

	    @FXML
	    private TableColumn<Client, String> emailCol;

	    @FXML
	    private TableColumn<Client, String> natioCol;

	    @FXML
	    private TableColumn<Client, String> teleCol;

	    @FXML
	    private TableColumn<Client, String> sexeCol;

	    @FXML
	    private TextField nomMod;

	    @FXML
	    private TextField prenomMod;

	    @FXML
	    private TextField adresMod;

	    @FXML
	    private TextField mailMod;

	    @FXML
	    private TextField natioMod;

	    @FXML
	    private TextField teleMod;

	    @FXML
	    private TextField sexeMod;

	    @FXML
	    private TextField idMod;
	    
	    private Client client=new Client();
	    
	    
	    ObservableList<Client> list=FXCollections.observableArrayList();
	    
	    @FXML
		   public void showAlertWithoutHeaderText(String str1,String str2) {
	        Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle(str1);
	 
	        // Header Text: null
	        alert.setHeaderText(null);
	        alert.setContentText(str2);
	 
	        alert.showAndWait();
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
	       void toViewReservation(MouseEvent event) throws IOException {
	    	   
			   FXMLLoader loader=new FXMLLoader();
				 
				
				Parent parent=FXMLLoader.load(getClass().getResource("/InterfaceView/ViewAcceuil.fxml"));
				
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
	    
	    public  void loadData(ObservableList<Client> list,TableView<Client> tableView) throws ClassNotFoundException, Throwable{
	    	
	    	ImplClientDao metClient=new ImplClientDao();
	    	ResultSet rs=metClient.listerClient();
	    	 
	    	while(rs.next()) {
	    		 int id=rs.getInt("Id_Client");
	    		 String nom=rs.getString("Nom_Client");
	    		 String prenom=rs.getString("Prenom_Client");
	    		 String adres=rs.getString("Adresse_Client");
	    		 String nation=rs.getString("Nationalite");
	    		 String email=rs.getString("Email_Client");
	    		 String tele=rs.getString("Telephone");
	    		 String sexe=rs.getString("Sexe");
	    		 
	    		 list.add(new Client(id,nom,prenom,adres,nation,email,sexe,tele));
	         	
	        }
	             tableView.getItems().setAll(list);
	    		}
	    
	    
	   
	    	
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			 idCol.setCellValueFactory(new PropertyValueFactory<>("idClient"));
			 nomCol.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
			 prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenomClient"));
			 adresseCol.setCellValueFactory(new PropertyValueFactory<>("adresseClient"));
			 natioCol.setCellValueFactory(new PropertyValueFactory<>("nationnalite"));
			 emailCol.setCellValueFactory(new PropertyValueFactory<>("emailClient"));
			 teleCol.setCellValueFactory(new PropertyValueFactory<>("sexeClient"));
			 sexeCol.setCellValueFactory(new PropertyValueFactory<>("teleClient"));
			
			 
			 
			 try {
				loadData(list,tableView);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
		public void initFilter() {

		}
		
		  @FXML
		   public void Selectionner() {
			 
			
			  Client client=tableView.getSelectionModel().getSelectedItem();
		      
			  
		     if(client != null) {
		    	 
		    	 
		    	 
		        idMod.setText(Integer.toString(client.getIdClient()));
				nomMod.setText(client.getNomClient());
				  
				prenomMod.setText(client.getPrenomClient());
				adresMod.setText(client.getAdresseClient());
				mailMod.setText(client.getEmailClient());
				
				natioMod.setText(client.getNationnalite());
				teleMod.setText(client.getTeleClient());
				sexeMod.setText(client.getSexeClient());
			
		       }

		    }
			  
		  

		
		    @FXML
		    void Modifier(ActionEvent event) throws ClassNotFoundException, Throwable {
		    	 list.clear();
		    	 
		    	
		    	  int id=Integer.parseInt(idMod.getText()); 
		    	 
		    	  String name=nomMod.getText();
		          String pren=prenomMod.getText();
		          String adress=adresMod.getText();
		          String mail=mailMod.getText();
		          String sexee=natioMod.getText();
		          String tele=teleMod.getText();
		          String nation=sexeMod.getText();
		          
		          System.out.println("M-2");
		          Client client=new Client(id,name,pren,adress,mail,sexee,tele,nation); 
		    	  ImplClientDao metClient=new ImplClientDao();
		    	  System.out.println("M-3");
		    	  int i=metClient.modifierClient(client);
		    	  System.out.println("M-4");
		    	  
		    	  if(i>0) {	 
		    	   showAlertWithoutHeaderText("Modification","Modification des données avec succes!");
		    	  }
		    	 
		    	  
		    	  loadData(list, tableView);
		       }
		  
		
		   @FXML
		    void Supprimer(ActionEvent event) throws ClassNotFoundException, Throwable {
			  
		    	client=tableView.getSelectionModel().getSelectedItem();
		    	if(client != null) {
		    	tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
		    	 ImplClientDao metClient=new ImplClientDao();
		         metClient.supprimerClient(client);
		    	}
		    	else { showAlertWithoutHeaderText("Suppression","Veuillez selectionner un client !");
		    	  }
		    }


		public Button getModifierB() {
			return ModifierB;
		}


		public void setModifierB(Button modifierB) {
			ModifierB = modifierB;
		}


		public Button getSupprimerB() {
			return SupprimerB;
		}


		public void setSupprimerB(Button supprimerB) {
			SupprimerB = supprimerB;
		}


	




		public TableView<Client> getTableView() {
			return tableView;
		}


		public void setTableView(TableView<Client> tableView) {
			this.tableView = tableView;
		}


		public TableColumn<Client, String> getIdCol() {
			return idCol;
		}


		public void setIdCol(TableColumn<Client, String> idCol) {
			this.idCol = idCol;
		}


		public TableColumn<Client, String> getNomCol() {
			return nomCol;
		}


		public void setNomCol(TableColumn<Client, String> nomCol) {
			this.nomCol = nomCol;
		}


		public TableColumn<Client, String> getPrenomCol() {
			return prenomCol;
		}


		public void setPrenomCol(TableColumn<Client, String> prenomCol) {
			this.prenomCol = prenomCol;
		}


		public TableColumn<Client, String> getAdresseCol() {
			return adresseCol;
		}


		public void setAdresseCol(TableColumn<Client, String> adresseCol) {
			this.adresseCol = adresseCol;
		}


		public TableColumn<Client, String> getEmailCol() {
			return emailCol;
		}


		public void setEmailCol(TableColumn<Client, String> emailCol) {
			this.emailCol = emailCol;
		}


		public TableColumn<Client, String> getNatioCol() {
			return natioCol;
		}


		public void setNatioCol(TableColumn<Client, String> natioCol) {
			this.natioCol = natioCol;
		}


		public TableColumn<Client, String> getTeleCol() {
			return teleCol;
		}


		public void setTeleCol(TableColumn<Client, String> teleCol) {
			this.teleCol = teleCol;
		}


		public TableColumn<Client, String> getSexeCol() {
			return sexeCol;
		}


		public void setSexeCol(TableColumn<Client, String> sexeCol) {
			this.sexeCol = sexeCol;
		}


		public TextField getNomMod() {
			return nomMod;
		}


		public void setNomMod(TextField nomMod) {
			this.nomMod = nomMod;
		}


		public TextField getPrenomMod() {
			return prenomMod;
		}


		public void setPrenomMod(TextField prenomMod) {
			this.prenomMod = prenomMod;
		}


		public TextField getAdresMod() {
			return adresMod;
		}


		public void setAdresMod(TextField adresMod) {
			this.adresMod = adresMod;
		}


		public TextField getMailMod() {
			return mailMod;
		}


		public void setMailMod(TextField mailMod) {
			this.mailMod = mailMod;
		}


		public TextField getNatioMod() {
			return natioMod;
		}


		public void setNatioMod(TextField natioMod) {
			this.natioMod = natioMod;
		}


		public TextField getTeleMod() {
			return teleMod;
		}


		public void setTeleMod(TextField teleMod) {
			this.teleMod = teleMod;
		}


		public TextField getSexeMod() {
			return sexeMod;
		}


		public void setSexeMod(TextField sexeMod) {
			this.sexeMod = sexeMod;
		}


		public TextField getIdMod() {
			return idMod;
		}


		public void setIdMod(TextField idMod) {
			this.idMod = idMod;
		}


		public   ObservableList<Client> getList() {
			return list;
		}


		public void setList(ObservableList<Client> list) {
			this.list = list;
		}


		public Client getClient() {
			
			 return client;
		
		}


		public void setClient(Client client) {
			this.client = client;
		}

	}

