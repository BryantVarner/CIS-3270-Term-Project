package UI;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Business_Logic.Customer;
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

public class flightsControl extends loginControl implements Initializable {

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
	@FXML
	private TextField custDepartDate;
	@FXML
	private TextField custDepartFrom;
	@FXML
	private TextField custArrivalTo;
	@FXML
	private Label lblflightBooked;
	@FXML
	private Label lblBookedSuccess;
	
	
	protected String date;
	protected String from;
	protected String to;
	
	ObservableList<Flights> observableList = FXCollections.observableArrayList();
	
	// when main menu button is clicked anywhere it returns to login screen.
	public void mainMenuBtnClicked(ActionEvent event) throws Exception {
			Parent register = FXMLLoader.load(getClass().getResource("main.fxml"));
			Scene registerScene = new Scene(register);	
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(registerScene);
			window.show();
		}
	
	// when user clicks book flights CONSTRUCTION
	public void bookFlightsBtnClicked(ActionEvent event) throws Exception {
		
		Flights data = tableview.getSelectionModel().getSelectedItem();
		String flight = data.getFlightNum();
		Customer customer = new Customer();
		int id = customer.getCustomerID();
		
		if(unique(id,flight)) {
			// display flight is already booked
			lblflightBooked.setText("You already have flight " + flight + " booked.");
		}
		else {	
			//book flight
			book(id,flight);
			lblflightBooked.setText("Flight " + flight + " is now booked.");
		}
	}
		
	// when search button is clicked it shows list of flights user specified
	public void searchBtnClicked(ActionEvent event) throws Exception {

			
			date = custDepartDate.getText().toString();
			from = custDepartFrom.getText().toString();
			to = custArrivalTo.getText().toString();
			
			colFlightNum.setCellValueFactory(new PropertyValueFactory<>("FlightNum"));
			colDate.setCellValueFactory(new PropertyValueFactory<>("FlightDate"));
			colDepartureTime.setCellValueFactory(new PropertyValueFactory<>("DepartTime"));
			colDepartFrom.setCellValueFactory(new PropertyValueFactory<>("DepartFrom"));
			colArrivalTo.setCellValueFactory(new PropertyValueFactory<>("ArrivalTo"));
			colAirline.setCellValueFactory(new PropertyValueFactory<>("Airline"));
			colSeatPrice.setCellValueFactory(new PropertyValueFactory<>("SeatPrice"));
			tableview.setItems(getSearch(date,from,to));
		
		}

	// when see all flights button is clicked it shows list of all flights available
	public void seeAllFlightsClicked(ActionEvent event) throws Exception {
		
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
	
	public static ObservableList<Flights> getSearch(String date, String from, String to) 
			throws ClassNotFoundException, SQLException {
		
	ObservableList<Flights> obList = FXCollections.observableArrayList();
			
	PreparedStatement myStmt = null;
	ResultSet rs = null;
	String sql = " select * from flights where departFrom = " + "'" + from + "'"
		+ "and arrivalDestination = " + "'" + to + "'" + " and date = " + "'" + date + "'";
			
		try {	
			Connection con = FlightsData.getConnection();
			myStmt = con.prepareStatement(sql);
			rs = myStmt.executeQuery();
				
			while(rs.next()) {
				obList.add(new Flights(rs.getString("FlightNum"), rs.getString("date"),
						rs.getString("departureTime"), rs.getString("departFrom"),
						rs.getString("arrivalDestination"), rs.getString("airline"),
						rs.getString("seatPrice")));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return obList;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources ) {
		
		
		}
	
	}
	
