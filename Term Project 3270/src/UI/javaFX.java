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
		
		window.setTitle("Airline Reservation System");
		
		Label label1 = new Label("This is a label");
		
		Button button1 = new Button("Go to Main Menu");
		
		button1.setOnAction(e -> window.setScene(scene2));
		
		//layout1
		
		VBox layout1 = new VBox(20);
		
		layout1.getChildren().addAll(label1, button1);
		
		scene1 = new Scene(layout1, 300,250);
		
		
		//button 2
		
		Button button2 = new Button("You are progressing");
		
		button2.setOnAction(e -> window.setScene(scene1));
		
		//layout 2
		
		StackPane layout2 = new StackPane();
		
		layout2.getChildren().add(button2);
		scene2 = new Scene(layout2, 600 , 300);
		
		
		
		window.setScene(scene1);
		window.show();
		
	}
	
	public static void main(String [] args) {
		
		launch(args);
	}
}






























