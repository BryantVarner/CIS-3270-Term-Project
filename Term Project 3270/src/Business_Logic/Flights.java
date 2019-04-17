package Business_Logic;

// All flight information

import java.util.Date;

public class Flights {
	
	private String airLine;
	private String flightNum;
	private String origin;
	private String destination;
	private int departureTime;             
    private int arrivalTime;               
    private String airlines;
    private int duration;                   
    private int flightNumber;                     
    private int maxCapacity;                   
    private int bookedSeats;                
    private double costOfFlight; 
	
	public Flights() {
		
	}
	
	public Flights(String airLine, String flightNum, String origin, String destination) {
		
		this.airLine = airLine;
		this.flightNum = flightNum;
		this.origin = origin;
		this.destination = destination;
		
	}


	public String getAirLine() {
		return airLine;
	}


	public void setAirLine(String airLine) {
		this.airLine = airLine;
	}


	public String getFlightNum() {
		return flightNum;
	}


	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}


	public String getOrigin() {
		return origin;
	}


	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String toString() {
		
		return "Flight information: \nAirline: " + getAirLine()
				+ "\nFlight Number: " + getFlightNum() + "\nFrom: " + getOrigin() 
				+ "\nTo: " + getDestination();
		
	}
}
