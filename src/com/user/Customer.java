package com.user;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
	private int custID;
	private String firstName;
	private String lastName;
	private String telephone;
	private String email;
	private String password;
	private String confirmPassword;
	private Address address;
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private String bankName = "A Bank";
	private static final String path = "C:\\Users\\Tina\\Documents\\JavaFullstackBootcamp\\streams\\";
	
	public Customer() {
	}
	
	public Customer(int custID, String firstName, String lastName, 
			String telephone, String email, String password, String confirmPassword, 
			Address address, ArrayList<Account> accounts, String bankName) {
		this.custID = custID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.address = address;
		this.bankName = bankName;
	}

	public int getCustID() {
		return this.custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Address getAddress() {
		return this.address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public ArrayList<Account> getAccounts() {
	return accounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
	this.accounts = accounts;
	}

	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public static Customer readFromFile(String email) {
		Account account = new Account();
		Address address = new Address();
		Customer customer = new Customer();
		String fileName = path + "TinasBankCustomers.txt";
		
		try {
			Scanner scanner = new Scanner (new File(fileName));
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parsedLine = line.split(",");
				
				customer.custID = (Integer.parseInt(parsedLine[0]));
				customer.firstName = parsedLine[1];
				customer.lastName = parsedLine[2];
				customer.telephone = parsedLine[3];
				customer.email = parsedLine[4];
				customer.password = parsedLine[5];
				
		   		customer.setAddress(address);
		   		address.setStreet(parsedLine[6]);
		   		address.setCity(parsedLine[7]);
		   		address.setState(parsedLine[8]);
		   		address.setZip(parsedLine[9]);
	/*   		
		   		customer.setAccount(account);
				account.setAccountNumber(Integer.parseInt(parsedLine[10]));
				account.setTranNumber(Integer.parseInt(parsedLine[11]));
				account.setBalance(Double.parseDouble(parsedLine[12]));
				account.setTranAmount(Double.parseDouble(parsedLine[13]));
		   		account.setAccountType(parsedLine[14]);
	*/
			}
			} catch(FileNotFoundException ex) {
			
			}
		return customer;
	}
	
	public void saveToFile() {
		String fileName = null;
		try {
			fileName = this.path + "TinasBankCustomers.txt";
			if (fileName.isEmpty()) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
				bw.write(this.toString());
				bw.close();
			} else {
				BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
				bw.write("\n"+this.toString());
				bw.close();
			}

		}catch(IOException ex) {		
			System.out.println("Exception occurred:");
			ex.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return   this.custID+","+this.firstName+","+this.lastName+","+this.telephone+","+this.email
				+","+this.password+","+this.address+","+this.bankName+"\n"+this.getAccounts();
	}
	
	
}

