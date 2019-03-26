package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Account;
import com.user.Transaction;
import com.user.Customer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 * Servlet implementation class NewTransactionServlet
 */
@WebServlet("/NewTransactionServlet")
public class NewTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewTransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Post method - New Transaction");
		
		HttpSession session = request.getSession(true);
		Customer customer = (Customer)session.getAttribute("customer");
		Account account = (Account)session.getAttribute("account");

		String acctNbr =request.getParameter("account");
		int acctNo = Integer.parseInt(acctNbr);
		System.out.println(acctNbr);

		String ntmsg = "";
		
		ArrayList<Account> accounts = customer.getAccounts();
		if(accounts == null)
		{
			System.out.println("Null Accounts in NewTransactionServlet");
			accounts = new ArrayList<Account>();
		}
		
		if(accounts != null)
		{
			for (int i = 0; i <accounts.size(); i++) {
				if ((customer.getAccounts().get(i).getAccountNumber())==(acctNo)) {
					double bal = customer.getAccounts().get(i).getAccountBalance();
					
					if(customer.getAccounts().get(i).getTransactions() == null)
					{
						System.out.println("transactions null");
						ArrayList<Transaction> transactions = new ArrayList<Transaction>();
					}

					ArrayList<Transaction> transactions = customer.getAccounts().get(i).getTransactions();
					
					//reverse order of transactions back to ascending
					Collections.reverse(transactions);
					System.out.println("After ascending Order, ArrayList Contains : " + transactions);
					
					
					Transaction transaction = new Transaction();
					
					//New Transaction fields
					
					// set transaction account number to same as Account account number
					transaction.setAccountNumber(customer.getAccounts().get(i).getAccountNumber());
					String acctTypeMsg = customer.getAccounts().get(i).getAccountType();
					
					// since first transaction number was 01, set that up by 1 by 
					//    using length or size plus 1 to get tranNumber
					int trnNo = customer.getAccounts().get(i).getTransactions().size()+1;
					transaction.setTranNumber(trnNo);	 
					
					Date trandte = new Date();
					transaction.setTranDate(trandte);

					String str = request.getParameter("tranAmount");
					double amt = Double.parseDouble(str);
					
					
					//get value of radio whether withdraw or deposit and 
					// update account balance and transaction balance
					
					String TransactionOption =(String)request.getParameter("DepositOrWithdrawalOption");
					System.out.println("sTransaction");

					
					//if deposit
					if (TransactionOption == null) {
						ntmsg = "Please choose whether to deposit or withdraw";
						System.out.println("Please choose whether to deposit or withdraw");
						
						session.setAttribute("ntmsg",  ntmsg);

						RequestDispatcher rs = request.getRequestDispatcher("newTransaction.jsp");
						rs.forward(request, response);
						
					}
					
					//if deposit
					if (TransactionOption.equals("1")) {
						transaction.setTranAmount(amt);
						bal = bal + amt;
					}
					//if withdrawal
					if (TransactionOption.equals("2")) {
						if (amt <= bal) {
							amt = 0 - amt;
							transaction.setTranAmount(amt);
							bal = bal + amt;
						} else {
							ntmsg = "Transaction cancelled due to insufficient funds";
							System.out.println("Transaction cancelled due to insufficient funds");
						}
					}

					transaction.setTranBalance(bal);
					customer.getAccounts().get(i).setAccountBalance(bal);
					customer.getAccounts().get(i).getTransactions().add(transaction);
					
					
					//reverse order transactions into descending order 
					ArrayList<Transaction> toReverse = customer.getAccounts().get(i).getTransactions();
					//toReverse.equals(customer.getAccounts().get(i).getTransactions());
					Collections.reverse(toReverse);
					System.out.println("After Reverse Order, ArrayList Contains : " + toReverse);
					

					customer.getAccounts().get(i).setTransactions(toReverse);

					if (transaction.getTranAmount() != 0 ) {
							
						ntmsg = acctTypeMsg  + " " +transaction.getAccountNumber() 
							+ " with Trans Amount of $" + transaction.getTranAmount()  +" gives New Balance=" +transaction.getTranBalance();
							
						System.out.println("Transaction ADDED " + transaction);
					}
					
					session.setAttribute("customer",  customer);
					session.setAttribute("ntmsg",  ntmsg);
					session.setAttribute("account",  account);

					RequestDispatcher rs = request.getRequestDispatcher("newTransaction.jsp");
					rs.forward(request, response);
				}
			}
		} 

	}
	
	
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
