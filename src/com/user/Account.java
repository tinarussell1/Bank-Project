package com.user;

import java.util.ArrayList;
import java.util.Date;
import java.time.format.DateTimeFormatter;

public class Account {
	private int ID;
	private int accountNumber;
	private String accountType;
	private double accountBalance =0;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	//set balance to 0.00  on new account object
	public Account() {
		//balance = 0.0;
	}
	
	public Account(int ID, int accountNumber, String accountType, double balance) {
		this.ID = ID;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public ArrayList<Transaction> getTransactions() {
	return transactions;
	}
	public void setTransactions(ArrayList<Transaction> transactions) {
	this.transactions = transactions;
	}

	@Override
	public String toString() {
		return ID +","+accountNumber + ","+ accountType + "," +accountBalance;
	}
	
}
