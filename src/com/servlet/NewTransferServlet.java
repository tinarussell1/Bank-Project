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
import com.user.Customer;
import com.user.Transaction;

/**
 * Servlet implementation class NewTransferServlet
 */
@WebServlet("/NewTransferServlet")
public class NewTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewTransferServlet() {
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

		String FrmAcct =request.getParameter("FromAccount");
		String ToAcct =request.getParameter("ToAccount");
		int FromAccount = Integer.parseInt(FrmAcct);
		int ToAccount = Integer.parseInt(ToAcct);

		String tfrmsg = "";
		
		ArrayList<Account> accounts = customer.getAccounts();
		if(accounts == null || accounts.size() < 2)
		{
			System.out.println("Need more than one account to do transfer!!");
			tfrmsg = "Need more than one account to do a transfer!!";
		}
		
		if (FromAccount != ToAccount) {
			//FromAccount   iii
			for (int i = 0; i <accounts.size(); i++) {
				if ((customer.getAccounts().get(i).getAccountNumber())==(FromAccount)) {
				 	//ToAccount jjj
					for (int j = 0; j <accounts.size(); j++) {
						if ((customer.getAccounts().get(j).getAccountNumber())==(ToAccount)) {
							
							ArrayList<Transaction> ftransactions = customer.getAccounts().get(i).getTransactions();
							ArrayList<Transaction> ttransactions = customer.getAccounts().get(j).getTransactions();
							Transaction ftransaction = new Transaction();
							Transaction ttransaction = new Transaction();
							
					
							double fbal = customer.getAccounts().get(i).getAccountBalance();
							double tbal = customer.getAccounts().get(j).getAccountBalance();
							
							String str = request.getParameter("tranAmount");
							double amt = Double.parseDouble(str);
							
							//deposit ToAccount
							ttransaction.setTranAmount(amt);
							tbal = tbal + amt;
							ttransaction.setTranBalance(tbal);
							ttransaction.setAccountNumber(customer.getAccounts().get(j).getAccountNumber());
							
							
							//withdraw FromAccount
							if (amt <= fbal) {
								amt = 0 - amt;
								ftransaction.setTranAmount(amt);
								fbal = fbal + amt;
								ftransaction.setTranBalance(fbal);
								ftransaction.setAccountNumber(customer.getAccounts().get(i).getAccountNumber());
							} else {
								tfrmsg = "Transaction cancelled due to insufficient funds";
								System.out.println("Transaction cancelled due to insufficient funds");
							}

							Date trandte = new Date();
							ttransaction.setTranDate(trandte);
							ftransaction.setTranDate(trandte);
					
							//reverse order of transactions back to ascending
							Collections.reverse(ttransactions);
							Collections.reverse(ftransactions);
					
							// since first transaction number was 01, set that up by 1 by 
							//    using length or size plus 1 to get tranNumber
							int ftrnNo = customer.getAccounts().get(i).getTransactions().size()+1;
							ftransaction.setTranNumber(ftrnNo);	
							int ttrnNo = customer.getAccounts().get(j).getTransactions().size()+1;
							ttransaction.setTranNumber(ttrnNo);	
					
							customer.getAccounts().get(i).setAccountBalance(fbal);
							customer.getAccounts().get(i).getTransactions().add(ftransaction);
							customer.getAccounts().get(j).setAccountBalance(tbal);
							customer.getAccounts().get(j).getTransactions().add(ttransaction);
					
							//reverse order transactions into descending order 
							ArrayList<Transaction> ftoReverse = customer.getAccounts().get(i).getTransactions();
							Collections.reverse(ftoReverse);
							ArrayList<Transaction> ttoReverse = customer.getAccounts().get(j).getTransactions();
							Collections.reverse(ttoReverse);

							customer.getAccounts().get(i).setTransactions(ftoReverse);
							customer.getAccounts().get(j).setTransactions(ttoReverse);

							if (ttransaction.getTranAmount() != 0 ) {
								tfrmsg = "Transfer " + ttransaction.getTranAmount() + " from acct "
								  + ftransaction.getAccountNumber() +" to acct " 
								  + ttransaction.getAccountNumber();

								System.out.println("Transfer Completed");
							}
					
							session.setAttribute("customer",  customer);
							session.setAttribute( "tfrmsg",  tfrmsg);
							session.setAttribute("account",  account);

							RequestDispatcher rs = request.getRequestDispatcher("newTransfer.jsp");
							rs.forward(request, response);
						}
					}
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
