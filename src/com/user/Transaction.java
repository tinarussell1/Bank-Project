package com.user;

import java.util.Date;

public class Transaction {
	private int accountNumber;
	private int tranNumber;
	private Date tranDate;
	private double tranAmount;
	private double tranBalance;
	
	//set balance to 0.00  on new account object
	public Transaction() {
	}
	
	public Transaction(int accountNumber, int tranNumber, Date tranDate, 
			 double tranAmount, double tranBalance) {
		this.accountNumber = accountNumber;
		this.tranNumber = tranNumber;
		this.tranDate = tranDate;
		this.tranAmount = tranAmount;
		this.tranBalance = tranBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getTranDate() {
		return tranDate;
	}

	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	public int getTranNumber() {
		return tranNumber;
	}

	public void setTranNumber(int tranNumber) {
		this.tranNumber = tranNumber;
	}

	public double getTranAmount() {
		return tranAmount;
	}

	public void setTranAmount(double tranAmount) {
		this.tranAmount = tranAmount;
	}
	public double getTranBalance() {
		return tranBalance;
	}
	public void setTranBalance(double tranBalance) {
		this.tranBalance = tranBalance;
	}

	@Override
	public String toString() {
		return "Transaction [accountNumber=" + accountNumber + ", tranNumber=" 
				+ tranNumber +", tranDate=" + tranDate + ", tranAmount=" + tranAmount +tranBalance +  "]";
	}
	
}
