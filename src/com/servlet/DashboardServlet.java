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

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println("In Post method - Dashboard");
		Customer customer = (Customer)session.getAttribute("customer");
		
		ArrayList<Account> accounts = customer.getAccounts();
		
		if(accounts == null)
		{
			System.out.println("Null Accounts in Dashboard");
			accounts = new ArrayList<Account>();
		}
	
		if(accounts != null)
		{	for (int i =0;i<accounts.size();i++) {
			System.out.println("In for dashboard loop for all accounts for this customer");
		
					System.out.println("In for dashboard loop, account"
							+customer.getAccounts().get(i).getAccountNumber()+"Type"+customer.getAccounts().get(i).getAccountNumber() );
					Account account = customer.getAccounts().get(i);
					
					session.setAttribute("customer",  customer);
					session.setAttribute("accounts",  accounts);
					session.setAttribute("account",  account);
					
					RequestDispatcher rs = request.getRequestDispatcher("dashboard.jsp");
					rs.forward(request, response);	
				
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
