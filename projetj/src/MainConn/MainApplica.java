package MainConn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplica extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			String url="InterfaceView/ViewAuthen.fxml";
			Parent root =FXMLLoader.load(getClass().getClassLoader().getResource(url));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
