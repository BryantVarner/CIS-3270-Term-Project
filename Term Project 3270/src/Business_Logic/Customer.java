package Business_Logic;

import DataBase.Driver;

public class Customer extends Driver  {
	
	private String firstName;
	private String lastName;
	private String address;
	private String zipCode;
	private String state;
	private String username;
	private String password;
	private String email;
	private String SSN;
	private String securityAnswer;
	
	
	
	public Customer() {
		
	}
	
	public String getFirstName() {
		
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipCode;
	}
	public void setZipcode(String zipcode) {
		this.zipCode = zipcode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	
	// makes sure there are no unfilled boxes on registration screen and then registers customer
	// in database if everything is filled out
	
	public boolean filledCorrect(String address, String zipcode, String email,
						String state, String securityAnswer,
						String firstName, String lastName,
						String username, String password, String ssn) throws Exception {
		
		if (address.trim().equals("") || zipcode.trim().equals("") || email.trim().equals("") ||
				state.trim().equals("") || securityAnswer.trim().equals("") || 
				firstName.trim().equals("") || lastName.trim().equals("") || username.trim().equals("")
				|| ssn.trim().equals("") || password.trim().equals("")) {
			
			
			return false;
		}
		
		else {
			register(address,zipcode, email, state,  securityAnswer, firstName, lastName,
					 username,  password,  ssn);
			
			return true;
		}
	}
	
	

}
