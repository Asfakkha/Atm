package com.example.atm;

import java.util.Scanner;

public class AtmTest {

	public static void main(String[] args) {

		// creating object of scanner class
		Scanner scanner = new Scanner(System.in);

		// creating object of ATM class
		Atm atm = new Atm();
		System.out.println("*************************************");
		System.out.println("Welcome to Bank of NC ATM");
		System.out.println("*************************************");
		atm.getAtmPin();

	}

}
