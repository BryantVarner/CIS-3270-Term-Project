package UI;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class loginControl  {
	
	// when register button is clicked it changes to registration scene
	public void registerBtnClicked(ActionEvent event) throws Exception {
		
		Parent register = FXMLLoader.load(getClass().getResource("register.fxml"));
		
		Scene registerScene = new Scene(register);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(registerScene);
		window.show();
	
	}
	
	// when login button is clicked it changes to flights scene
		public void flightsBtnClicked(ActionEvent event) throws Exception {
			
			Parent register = FXMLLoader.load(getClass().getResource("flights.fxml"));
			
			Scene registerScene = new Scene(register);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(registerScene);
			window.show();
		
		}
		
		
	// when main menu button is clicked anywhere it returns to login screen.
	public void mainMenuBtnClicked(ActionEvent event) throws Exception {
		
		Parent register = FXMLLoader.load(getClass().getResource("main.fxml"));
		
		Scene registerScene = new Scene(register);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(registerScene);
		window.show();
		
	}
	
	// when cabin and travelers button is clicked it goes to cabin and travelers scene
	public void cabinBtnClicked(ActionEvent event) throws Exception {
		
		Parent register = FXMLLoader.load(getClass().getResource("cabinTravel.fxml"));
		
		Scene registerScene = new Scene(register);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(registerScene);
		window.show();
		
	}
	
	public void oneWayBtnClicked(ActionEvent event) throws Exception {
		
		Parent register = FXMLLoader.load(getClass().getResource("flights2.fxml"));
		
		Scene registerScene = new Scene(register);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(registerScene);
		window.show();
		
	}
	
	public void roundTripBtnClicked(ActionEvent event) throws Exception {
		
		Parent register = FXMLLoader.load(getClass().getResource("flights.fxml"));
		
		Scene registerScene = new Scene(register);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(registerScene);
		window.show();
		
	}

}
