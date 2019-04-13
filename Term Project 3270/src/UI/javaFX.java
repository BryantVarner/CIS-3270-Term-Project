package UI;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class javaFX extends Application {
	
	Stage window;
	Scene scene1, scene2;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		
		window.setTitle("Airline Reservation System User Login");
		
		Label label1 = new Label("Sign In");
		Label label2 = new Label("Username");
		Label label3 = new Label("Password");
		
		Button button1 = new Button("Forgot username or password?");
		
		button1.setOnAction(e -> window.setScene(scene2));
		
		//layout1
		
		VBox layout1 = new VBox(20);
		
		layout1.getChildren().addAll(label1, label2, label3, button1);
		
		scene1 = new Scene(layout1, 700,400);
		
		
		//button 2
		
		Button button2 = new Button("Main Menu");
		
		Label label4 = new Label("Forgot username or password? \n Let us help.");
		
		button2.setOnAction(e -> window.setScene(scene1));
		
		//layout 2
		
		VBox layout2 = new VBox();
		
		layout2.getChildren().addAll(button2, label4);
		scene2 = new Scene(layout2, 600 , 300);
		
		
		
		window.setScene(scene1);
		window.show();
		
	}
	
	public static void main(String [] args) {
		
		launch(args);
	}
}






























