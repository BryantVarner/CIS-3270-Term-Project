package UI;

import DataBase.Driver;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class loginControl extends Driver implements Initializable {
	
	@FXML
	private Label lblErrors;
	@FXML
	private TextField user;
	@FXML
	private TextField pass;
	
	
	
	// when register button is clicked it changes to registration scene
	public void registerBtnClicked(ActionEvent event) throws Exception {
		Parent register = FXMLLoader.load(getClass().getResource("register.fxml"));
		Scene registerScene = new Scene(register);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(registerScene);
		window.show();
	
	}
	// when forgot password label is clicked takes user to security answer scene
	public void forgotLblClicked(ActionEvent event) throws Exception {
		Parent register = FXMLLoader.load(getClass().getResource("forgotPass.fxml"));
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
	// when one way button is clicked it changes the date section
	// to only To: instead of to and from
	public void oneWayBtnClicked(ActionEvent event) throws Exception {
		
		Parent register = FXMLLoader.load(getClass().getResource("flights2.fxml"));
		
		Scene registerScene = new Scene(register);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(registerScene);
		window.show();
		
	}
	
	/*
	 *  when round trip button is clicked it changes the date section to To: and From:
	 */
	public void roundTripBtnClicked(ActionEvent event) throws Exception {
		
		Parent register = FXMLLoader.load(getClass().getResource("flights.fxml"));
		
		Scene registerScene = new Scene(register);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(registerScene);
		window.show();
		
	}
	
	/*
	 * when search button is clicked it takes user to list of flights they specified
	 */
	public void searchBtnClicked(ActionEvent event) throws Exception {
		
		Parent register = FXMLLoader.load(getClass().getResource("flightSearch.fxml"));
		
		Scene registerScene = new Scene(register);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(registerScene);
		window.show();
		
	}
	
	
	// when signIn button is clicked it verifies if username and password is correct
	public void signInBtnClicked(ActionEvent event) throws Exception {
					
		if (pass(user.getText().toString(), pass.getText().toString())) {
				
		Parent register = FXMLLoader.load(getClass().getResource("flights.fxml"));
		Scene registerScene = new Scene(register);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(registerScene);
		window.show();
		}
			else {
				
			lblErrors.setText("Incorrect Username or Password.");
			}				
	}
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
}
