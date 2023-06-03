package com.example.atm;

//Create BankAccount class
public class BankAccount {

	private Long chequingAcctNumber;
	private Long savingAcctNumber;
	private double chequingBalance;
	private double savingBalance;

	// create constructor to initialize object of class
	public BankAccount(Long chequingAcctNumber, Long savingAcctNumber, double chequingBalance, double savingBalance) {
		super();
		this.chequingAcctNumber = chequingAcctNumber;
		this.savingAcctNumber = savingAcctNumber;
		this.chequingBalance = chequingBalance;
		this.savingBalance = savingBalance;
	}

	// use getters and setters for getting and setting value
	public Long getChequingAcctNumber() {
		return chequingAcctNumber;
	}

	public void setChequingAcctNumber(Long chequingAcctNumber) {
		this.chequingAcctNumber = chequingAcctNumber;
	}

	public Long getSavingAcctNumber() {
		return savingAcctNumber;
	}

	public void setSavingAcctNumber(Long savingAcctNumber) {
		this.savingAcctNumber = savingAcctNumber;
	}

	public double getChequingBalance() {
		return chequingBalance;
	}

	public void setChequingBalance(double chequingBalance) {
		this.chequingBalance = chequingBalance;
	}

	public double getSavingBalance() {
		return savingBalance;
	}

	public void setSavingBalance(Long savingBalance) {
		this.savingBalance = savingBalance;
	}

}
