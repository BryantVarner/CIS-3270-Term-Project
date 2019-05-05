package UI;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Business_Logic.Flights;
import DataBase.FlightsData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class manageFlightsControl extends flightsControl implements Initializable {
	
	@FXML
	private TableView<Flights> tableview;
	@FXML
	private TableColumn<Flights, Integer> colFlightNum;
	@FXML
	private TableColumn<Flights, String> colDate;
	@FXML
	private TableColumn<Flights, String> colDepartureTime;
	@FXML
	private TableColumn<Flights, String> colDepartFrom;
	@FXML
	private TableColumn<Flights, String> colArrivalTo;
	@FXML
	private TableColumn<Flights, String> colAirline;
	@FXML
	private TableColumn<Flights, Double> colSeatPrice;
	@FXML
	private TextField flightNum;
	@FXML
	private TextField flightDate;
	@FXML
	private TextField departTime;
	@FXML
	private TextField departFrom;
	@FXML
	private TextField arrivalTo;
	@FXML
	private TextField airline;
	@FXML
	private TextField seatPrice;
	@FXML
	private Label lblNotFilled;
	
	ObservableList<Flights> observableList = FXCollections.observableArrayList();
	
	
	// when add flights is clicked it verifies if all text fields are filled and adds a new flight
	public void addFlightsBtnClicked(ActionEvent event) throws Exception {
			
			if(flightFilledCorrect(flightNum.getText(), flightDate.getText(),
									departTime.getText(), departFrom.getText(),
									arrivalTo.getText(), airline.getText(),
									seatPrice.getText()))
			{
				
				addFlights();
				Parent registers = FXMLLoader.load(getClass().getResource("adminMain.fxml"));
				Scene registerScene = new Scene(registers);
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				window.setScene(registerScene);
				window.show();
			}
				
				else {
					lblNotFilled.setText("One or more fields are empty.");
			}
			
	}
	
	// when main menu button is clicked anywhere it returns to login screen.
	public void mainMenuBtnClicked(ActionEvent event) throws Exception {
			Parent register = FXMLLoader.load(getClass().getResource("main.fxml"));
			Scene registerScene = new Scene(register);	
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(registerScene);
			window.show();
		}	
	
	// when this button is clicked it takes admin back to admins terminal
	public void backToAdminTerminalBtnClicked(ActionEvent event) throws Exception {
					Parent register = FXMLLoader.load(getClass().getResource("adminMain.fxml"));			
					Scene registerScene = new Scene(register);	
					Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();		
					window.setScene(registerScene);
					window.show();
				}	
							
	public static ObservableList<Flights> getSearch(String date, String from, String to) 
				throws ClassNotFoundException, SQLException {
			
		ObservableList<Flights> observableList = FXCollections.observableArrayList();
			
		String str = date;
		String str1 = from;
		String str2 = to;
				
		PreparedStatement myStmt = null;
		ResultSet rs = null;
		String sql = " select * from flights where departFrom = " + "'" + str1 + "'"
			+ "and arrivalDestination = " + "'" + str2 + "'" + " and date = " + "'" + str + "'";
				
			try {
					
				Connection con = FlightsData.getConnection();
				myStmt = con.prepareStatement(sql);
					
				rs = myStmt.executeQuery();
					
				while(rs.next()) {
					observableList.add(new Flights(rs.getString("FlightNum"), rs.getString("date"),
							rs.getString("departureTime"), rs.getString("departFrom"),
							rs.getString("arrivalDestination"), rs.getString("airline"),
							rs.getString("seatPrice")));
							
				}
			}
			
			catch(Exception ex) {
				ex.printStackTrace();
			}
			
			return observableList;
		}
			
		@Override
	public void initialize(URL location, ResourceBundle resources ) {
				
			try {
					
				Connection con = FlightsData.getConnection();
				ResultSet rs = con.createStatement().executeQuery("select * from flights");
					
				while(rs.next()) {
					observableList.add(new Flights(rs.getString("FlightNum"), rs.getString("date"),
										rs.getString("departureTime"), rs.getString("departFrom"),
										rs.getString("arrivalDestination"), rs.getString("airline"),
										rs.getString("seatPrice")));
						
				}
				
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
				
			colFlightNum.setCellValueFactory(new PropertyValueFactory<>("FlightNum"));
			colDate.setCellValueFactory(new PropertyValueFactory<>("FlightDate"));
			colDepartureTime.setCellValueFactory(new PropertyValueFactory<>("DepartTime"));
			colDepartFrom.setCellValueFactory(new PropertyValueFactory<>("DepartFrom"));
			colArrivalTo.setCellValueFactory(new PropertyValueFactory<>("ArrivalTo"));
			colAirline.setCellValueFactory(new PropertyValueFactory<>("Airline"));
			colSeatPrice.setCellValueFactory(new PropertyValueFactory<>("SeatPrice"));
			tableview.setItems(observableList);
			
		}
	

}
