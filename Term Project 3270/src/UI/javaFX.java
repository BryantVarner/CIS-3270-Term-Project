package UI;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;


public class javaFX extends Application {
	
	
	public static void main(String [] args) {
			
			launch(args);
		}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
		Scene scene  = new Scene(root);
		primaryStage.setTitle("Airline Reservation");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
}






























