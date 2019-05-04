package UI;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class javaFX extends Application {
	
	
	public static void main(String [] args) {
			
			launch(args);
		}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
		Scene scene  = new Scene(root);
		primaryStage.setTitle("Airline Reservation");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
}






























