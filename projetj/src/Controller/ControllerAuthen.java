package Controller;

import java.io.IOException;

import ImplementInterfDao.ImplUserDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerAuthen {
	@FXML TextField name;
	@FXML TextField mdp;
	public void login(ActionEvent event) throws IOException, ClassNotFoundException{
		
		ImplUserDao user=new ImplUserDao();
		
		if(user.verifiermdp(mdp.getText()) && user.verifiername(name.getText()) ) {
			
			 FXMLLoader loader=new FXMLLoader();
			 
				
				Parent parent=FXMLLoader.load(getClass().getResource("/InterfaceView/ViewClient.fxml"));
				
				Scene scene=new Scene(parent);
				Stage window=(Stage) (((Node) event.getSource()).getScene().getWindow());
				window.setScene(scene);
				window.show();
		}
		else {System.out.println("khassr");}
	}

}


