package com.example.atm;

//Create  BankCard class
public class BankCard {
	private Long BankCard;
	private int pin;

	// create constructor to initialize object of class
	public BankCard(Long bankCard, int pin) {
		super();
		BankCard = bankCard;
		this.pin = pin;
	}

	// use getters and setters for getting and setting value
	public Long getBankCard() {
		return BankCard;
	}

	public void setBankCard(Long bankCard) {
		BankCard = bankCard;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

}
