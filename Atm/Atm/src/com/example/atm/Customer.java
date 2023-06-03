package com.example.atm;

//Create customer class
public class Customer {

	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private Long phoneNumber;
	private BankCard bankCard;
	private BankAccount bankAccount;

// create constructor to initialize object of class
	public Customer(String firstName, String lastName, String address, String email, Long phoneNumber,
			BankCard bankCard, BankAccount bankAccount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.bankCard = bankCard;
		this.bankAccount = bankAccount;
	}

	// use getters and setters for getting and setting value
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BankCard getBankCard() {
		return bankCard;
	}

	public void setBankCard(BankCard bankCard) {
		this.bankCard = bankCard;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

}
