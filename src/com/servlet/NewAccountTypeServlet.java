package com.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Account;
import com.user.Customer;
import com.user.Transaction;

/**
 * Servlet implementation class NewAccountTypeServlet
 */
@WebServlet("/NewAccountTypeServlet")
public class NewAccountTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAccountTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Customer customer = (Customer)session.getAttribute("customer");
		
		ArrayList<Account> accounts = customer.getAccounts();
		if(accounts == null)
		{
			System.out.println("Null Accounts in NewAccountTypeServlet");
			accounts = new ArrayList<Account>();
		}

		String namsg = "";
		System.out.println("In for loop, in for new account types");
		String[] accountTypes = request.getParameterValues("accountType");
	if (accountTypes.length >0) {
		namsg = "ADDED ";
		
		for (int j=0;j<accountTypes.length; j++) {
			System.out.println(accountTypes[j]);
					    	
			//Setting up an Account fields
			String acctInfo = "";
			Account account = new Account();	

			int randomNumber = (int) (Math.floor(Math.random() * 1000000)); 
			int acctno = randomNumber;
			String acctTp = accountTypes[j];
							
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
				
			transaction.setTranAmount(0);
			transaction.setTranBalance(0);

			transactions.add(transaction);
			account.setTransactions(transactions);
			accounts.add(account);
			namsg = namsg+ account.getAccountType() +" account# " +account.getAccountNumber()+"."+"\n"; 

	
			customer.setAccounts(accounts);	
					    
		}
	}
		session.setAttribute("customer",  customer);
		session.setAttribute("namsg", namsg);
		RequestDispatcher rs = request.getRequestDispatcher("accountTypeAddition.jsp");
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
