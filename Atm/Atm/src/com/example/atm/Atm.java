package com.example.atm;

import java.util.ArrayList;
import java.util.Scanner;

//create ATM class
public class Atm {

	// creating object of scanner class for getting input from user
	Scanner scanner = new Scanner(System.in);
	int pinNumber;

	// create a static list of customer for dummy data
	static ArrayList<Customer> list = new ArrayList<>();

	// static block initialize at compile time
	static {
		list.add(new Customer("John", "lachi", "Birmingham", "john@gmail.com", 45454545454l,
				new BankCard(1221212121212l, 1234), new BankAccount(488548758744l, 8474445454l, 10000d, 5000d)));
		list.add(new Customer("Aliska", "asdlk", "Cambridge", "aliska@gmail.com", 776767676767l,
				new BankCard(2323232344533l, 9079), new BankAccount(1227633333l, 3265265272l, 26000d, 11000d)));
		list.add(new Customer("meri", "khan", "Manchester", "juberkhan@gmail.com", 898987897797l,
				new BankCard(5555666686l, 5678), new BankAccount(4367747l, 748748743l, 15000d, 20000d)));
		list.add(new Customer("Himi", "sdf", "Leeds", "meri@gmail.com", 65556568995l,
				new BankCard(8798767967678l, 4321), new BankAccount(48549854l, 49854984l, 15000d, 20000d)));
		list.add(new Customer("Loso", "tovlo", "London", "Loso@gmail.com", 60668696666l,
				new BankCard(857575458454l, 2345), new BankAccount(5868858l, 457477l, 9000d, 25000d)));

	}

	// create method for getting pin of ATM card from user
	public void getAtmPin() {

		// attempt variable for customer have 5 attempt
		int attempt = 5;
		boolean f = false;
		for (int i = 0; i <= 5; i++) {
			System.out.println("Please Enter your pin");
			System.out.println("*************************************");
			int pin = scanner.nextInt();
			pinNumber = pin;
			if (attempt > 1) {
				// Iterating list of customer for
				for (Customer customer : list) {
					// if condition for matching pin number
					if (customer.getBankCard().getPin() == pin) {
						System.out.println("Pin accepcted!");

						// calling method for taking choice for any operation
						showOption();
						f = true;

					}

				}
				attempt--;
				// If customer enter invalid pin then showing error
				if (f == false) {
					System.err.println("Invalid pin try aggain.. Attempts remaining : " + attempt);
				}
			} else {
				System.err.println("you can use atm pin only 5 time ");
			}

		}

		// Increment attempt variable by 1

	}

	// create method for showing choice to customer
	public void showOption() {
		System.out.println("*************************************");
		System.out.println("Please select an option:");
		System.out.println("*************************************");
		System.out.println("1. Print your Account Information");
		System.out.println("2. Withdraw");
		System.out.println("3. Deposit");
		System.out.println("4. Change PIN");
		System.out.println("5. Exit");

		int choice1 = scanner.nextInt();

		// passing choice in switch statement
		switch (choice1) {

		case 1:

			// If user enter 1 then call getCustomerInformation method that will print
			// all the information of the customer

			getCustomerInformation(pinNumber);
			break;
		case 2:
			// If user enter 2 then call withdraw method for withdraw money from account
			withdraw();
			break;
		case 3:

			// If user enter 3 then call deposit method for deposit money
			deposit();
			break;
		case 4:

			// If user enter 4 then call call changePing method for changing the pin of
			// customer ATM
			changePin();
			break;
		case 5:

			// If user enter 5 then program will exit
			System.out.println("thank you for using our bank ..!");
			System.exit(0);
			break;
		}
	}

	// withdraw method for withdraw money
	public void withdraw() {
		System.out.println("*************************************");
		System.out.println("WITHDRAW FROM WHICH ACCOUNT?");
		System.out.println("*************************************");
		// Iterating list of customer
		for (Customer customer : list) {
			double chequingBlance;
			double savingbalance;

			// If condition for matching the pin of customer
			if (customer.getBankCard().getPin() == pinNumber) {

				// getting the chequeing account balance of customer
				chequingBlance = customer.getBankAccount().getChequingBalance();

				// getting the saving account balance of the customer
				savingbalance = customer.getBankAccount().getSavingBalance();
				System.out.println("1. Chequing #" + customer.getBankAccount().getChequingAcctNumber()
						+ " Available balance " + chequingBlance);
				System.out.println("2. Savings #" + customer.getBankAccount().getSavingAcctNumber()
						+ " Available balance " + savingbalance);
				int number = scanner.nextInt();

				// checking user choice that from which account customer wants to
				// withdraw money if enter 1 then withdraw from chequing account
				if (number == 1) {
					System.out.println("Your selection:" + number);
					System.out.print("Enter withdrawal amount $");
					double ammount = scanner.nextDouble();

					// condition for entered amount must less than or equal to available balance
					if (chequingBlance > ammount) {
						chequingBlance = chequingBlance - ammount;
						System.out.println("SUCCESS -" + ammount + "has been withdrawn from Chequing.");
						System.out.println("NEW BALANCE $ " + chequingBlance);
					} else {
						System.out.println("Insufficient Balance");
					}

				}

				// If user enter 2 then withdraw money from saving account
				else if (number == 2) {
					System.out.println("Your selection: " + number);
					System.out.print("Enter withdrawal amount $");
					double ammount = scanner.nextDouble();

					// condition for entered amount must less than or equal to available balance
					if (savingbalance > ammount) {
						savingbalance = savingbalance - ammount;
						System.out.println("SUCCESS -" + ammount + "has been withdrawn from savings.");
						System.out.println("NEW BALANCE $ " + savingbalance);
					}

				} else {
					System.out.println("Your selection: " + number);
					System.err.println("ERROR - invalid entry. Try again.");
				}

			}

		}
		System.out.println("*************************************");
		System.out.println("Would you like to do anything else ? ");
		System.out.println(" 1 ) yes ");
		System.out.println(" 2 ) No");
		String a = "yes";

		String string = scanner.next();
		if (string.equals(a)) {
			showOption();
		} else {
			System.exit(0);
		}
	}

	// create static variable for user can deposit maximum money
	private static int MAX_DEPOSIT = 10000;

	// method for deposit money
	public void deposit() {
		System.out.println("Which account would you like to deposit into?");
		for (Customer customer : list) {
			double chequingBlance;
			double savingbalance;

			// matching pin number
			if (customer.getBankCard().getPin() == pinNumber) {
				chequingBlance = customer.getBankAccount().getChequingBalance();
				savingbalance = customer.getBankAccount().getSavingBalance();
				System.out.println("1. Chequing Available balance " + chequingBlance);
				System.out.println("2. Savings  Available balance " + savingbalance);
				int number = scanner.nextInt();

				// checking choice in which account user wants to deposit money
				// if user enter 1 then deposit money in chequing account
				if (number == 1) {
					System.out.println("Your selection:" + number);
					System.out.print("Enter deposit amount $");
					double ammount = scanner.nextDouble();
					if (ammount < MAX_DEPOSIT) {
						chequingBlance = chequingBlance + ammount;
						System.out.println("NEW BALANCE " + chequingBlance);
					} else {
						System.out.println("deposit Balance must be less than 10000");
					}

				}

				// if user enter then deposit money in saving account
				else if (number == 2) {
					System.out.println("Your selection: " + number);
					System.out.print("Enter deposit amount $");
					double ammount = scanner.nextDouble();
					if (ammount < MAX_DEPOSIT) {
						savingbalance = savingbalance + ammount;
						System.out.println("NEW BALANCE " + savingbalance);
					}

				} else {

					// deposit amount must be less than 10,000
					System.out.println("deposit Balance must be less than 10000");
				}

			}

		}
		System.out.println("*************************************");
		System.out.println("Would you like to do anything else ? ");
		System.out.println(" 1 ) yes ");
		System.out.println(" 2 ) No");
		String a = "yes";

		String string = scanner.next();
		if (string.equalsIgnoreCase(a)) {
			showOption();
		} else {
			System.exit(0);
		}
	}

	// create method for getting information of the customer
	public void getCustomerInformation(int pin) {
		for (Customer customer : list) {

			// if customer's pin will match then will print all the customer information
			if (customer.getBankCard().getPin() == pin) {
				System.out.println(customer.getFirstName());
				System.out.println(customer.getLastName());
				System.out.println(customer.getEmail());
				System.out.println(customer.getEmail());
				System.out.println(customer.getPhoneNumber());
			}
		}
		System.out.println("*************************************");
		System.out.println("Would you like to do anything else ? ");
		System.out.println(" 1 ) yes ");
		System.out.println(" 2 ) No");
		String a = "yes";

		String string = scanner.next();
		if (string.equals(a)) {
			showOption();
		} else {
			System.exit(0);
		}
	}

	// create method for changing the pin
	public void changePin() {
		System.out.println("Enter Your old pin");
		int oldPin = scanner.nextInt();
		boolean flag = false;
		for (Customer customer : list) {
			if (customer.getBankCard().getPin() == oldPin) {
				flag = true;
				System.out.println("please Enter new pin");
				int newpin = scanner.nextInt();

				// converting pin value Integer to string for confirmation that
				// digit of pin must be 4

				String s = String.valueOf(newpin);
				int size = s.length();
				if (size == 4) {
					System.out.println("Pin Successfully changed ");
					break;

				} else {
					System.out.println("Enter only 4 digit ");
					break;
				}
			}

		}

		// If user enter invalid pin than print this error
		if (flag == false) {
			System.err.println("Invalid pin try aggain..");
		}
		System.out.println("*************************************");
		System.out.println("Would you like to do anything else ? ");
		System.out.println(" 1 ) yes ");
		System.out.println(" 2 ) No");
		String a = "yes";

		String string = scanner.next();
		if (string.equals(a)) {
			showOption();
		} else {
			System.exit(0);
		}
	}

}