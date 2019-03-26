package com.servlet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Account;
import com.user.Address;
import com.user.Customer;
import com.user.Transaction;

import java.util.Date;

/**
 * Servlet implementation class NewAccountServlet
 */
@WebServlet("/NewAccountServlet")
public class NewAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ArrayList<Customer> customers = (ArrayList<Customer>)session.getAttribute("customers");
		
		Customer customer = new Customer();
		
		if(customers == null)
		{
			customers = new ArrayList<Customer>();
			customer.setCustID(001);
		} else {
			int newID = customers.size() +1;
			customer.setCustID(newID);
		}
		System.out.println(customer.getCustID());
		customer.setFirstName(request.getParameter("firstName"));
		customer.setLastName(request.getParameter("lastName"));
		customer.setTelephone(request.getParameter("telephone"));
		customer.setEmail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));
		customer.setConfirmPassword(request.getParameter("confirmPassword"));
		
		Address address = new Address();
   		customer.setAddress(address);
		address.setStreet(request.getParameter("street"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setZip(request.getParameter("zip"));
		
		
		//Setting up an Account fields
		String acctInfo = "";
		Account account = new Account();	
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		int randomNumber = (int) (Math.floor(Math.random() * 1000000)); 
		int acctno = randomNumber;
		String acctTp =request.getParameter("accountType");
		if (acctTp == null) {
			acctTp.equals("Checking");
		}
		
		account.setID(customer.getCustID());
		account.setAccountNumber(acctno);
		account.setAccountType(acctTp);	
		//set account balance to zero
		account.setAccountBalance(0);
		
		
		//New Transaction fields
		Transaction transaction = new Transaction();
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		//set transaction account number to same as Account account number
		transaction.setAccountNumber(account.getAccountNumber());
		//String tranno = (request.getParameter("tranNumber"));
		String transNumber = "01";
			transaction.setTranNumber(Integer.parseInt(transNumber));
			 
		Date trandte = new Date();
		transaction.setTranDate(trandte);

		String amt = (request.getParameter("tranAmount"));
		if (amt == null) {
			transaction.setTranAmount(0);
			transaction.setTranBalance(0);
		}else { transaction.setTranAmount(Double.parseDouble(amt));
		 		transaction.setTranBalance(Double.parseDouble(amt));}
		
		transactions.add(transaction);
		account.setTransactions(transactions);
		accounts.add(account);
		customer.setAccounts(accounts);


		if (acctTp.equals("Checking")) {
			acctInfo = acctInfo +" Checking Account: " + acctno;	
		} else	if (acctTp.equals("Savings")) {
			acctInfo = acctInfo +" Savings Account: " + acctno;
		} else if (acctTp.equals("Credit")) {
			acctInfo = acctInfo +" Credit Card Account: "+ acctno;
		}
		
		String msg = "";
		if (customer.getFirstName() != null 
				&&	 customer.getPassword().contentEquals(customer.getConfirmPassword()) ) {
				
				msg = "ADDED " +"Customer:  " +customer.getFirstName() 
						+ " " + customer.getLastName() +" with " +acctInfo;
				
				System.out.println("Successfully ADDED " + customer);
			}
		
		if (customer.getPassword() != null 
				&&	 (!customer.getPassword().contentEquals(customer.getConfirmPassword())) ) {
				msg = "ERROR:  Please reenter passwords.  Passwords don't match.";
			}
		
	
		customers.add(customer);
		
		System.out.println("Customer ADDED to list: "+customers.size());
		session.setAttribute("customers",  customers);
		session.setAttribute("customer",  customer);
		session.setAttribute("account",  account);
		session.setAttribute("accounts",  accounts);
		
		session.setAttribute("msg", msg);

		RequestDispatcher rs = request.getRequestDispatcher("createAccount.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
