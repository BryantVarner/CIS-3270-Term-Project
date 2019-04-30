package UI;


import Business_Logic.Customer;
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
import javafx.stage.Stage;

public class loginControl extends Customer implements Initializable {
	
	
	@FXML
	private Label lblErrors;
	@FXML
	private Label lblNotFilled;
	@FXML
	private Label lblUserTaken;
	@FXML
	private TextField user;
	@FXML
	private TextField pass;
	@FXML
	private TextField address;
	@FXML
	private TextField zipcode;
	@FXML
	private TextField email;
	@FXML
	private TextField state;
	@FXML
	private TextField securityAnswer;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField ssn;
	@FXML
	private TextField birthMonth;
	@FXML
	private TextField birthDay;
	@FXML
	private TextField birthYear;
	
	
	// when register button is clicked it changes to main menu scene if unique account is entered
	public void registerBtnClicked(ActionEvent event) throws Exception {
		
		String birthday = birthMonth.getText() + "/" + birthDay.getText() + "/" + birthYear.getText();
		
		if(filledCorrect(firstName.getText(), lastName.getText(), email.getText(), address.getText(),
					user.getText(), pass.getText(), ssn.getText(), securityAnswer.getText(),
					zipcode.getText(), state.getText(), birthday)) {
			
			if(checkUser(user.getText())) {
		
		Parent registers = FXMLLoader.load(getClass().getResource("main.fxml"));
		Scene registerScene = new Scene(registers);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(registerScene);
		window.show();
			}
			
			else 
				lblUserTaken.setText("Username is already taken.");
		}
		
		else 
			lblNotFilled.setText("One or more fields are empty.");
		
	}
	// when forgot password label is clicked takes user to security answer scene
	public void forgotBtnClicked(ActionEvent event) throws Exception {
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
	
	
	// when userSignIn button is clicked it verifies if username and password is correct
	public void userSignInBtnClicked(ActionEvent event) throws Exception {
		
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
	
	// when adminSignIn button is clicked it verifies if username and password is correct
		public void adminSignInBtnClicked(ActionEvent event) throws Exception {
			
				if (adminPass(user.getText().toString(), pass.getText().toString())) {
						
				Parent register = FXMLLoader.load(getClass().getResource("adminMain.fxml"));
				Scene registerScene = new Scene(register);
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				window.setScene(registerScene);
				window.show();
				}
					else {
						
					lblErrors.setText("Incorrect Username or Password.");
				}
				
		}
	
	// when sign up button is clicked it changes to register scene
	
		public void signUpBtnClicked(ActionEvent event) throws Exception {
			Parent register = FXMLLoader.load(getClass().getResource("register.fxml"));
			Scene registerScene = new Scene(register);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(registerScene);
			window.show();
		
		}
		
		public void manageFlightsBtnClicked(ActionEvent event) throws Exception {
			Parent register = FXMLLoader.load(getClass().getResource("addFlights.fxml"));
			Scene registerScene = new Scene(register);	
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(registerScene);
			window.show();
		}

		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
	}
	
	
}
