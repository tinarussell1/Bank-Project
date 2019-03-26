package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class GpaServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		System.out.println("customer List size: "+customers.size());

		customer.setEmail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));
		
		String lmsg = "";
		
		if (customers == null) {
			lmsg = "ERROR: There are no accounts set up yet.";
			
			session.setAttribute("lmsg",  lmsg);
		
			RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
			rs.forward(request, response);	
			
		}
		boolean IsError = false;
		if (customers != null) {
			IsError = false;
			for (int i=0; i<customers.size(); i++) {
				System.out.println("in for loop for arrayitem "+i+"CustID: "+customers.get(i).getCustID());
				if ((customers.get(i).getEmail().equals(request.getParameter("email")))
						&& (customers.get(i).getPassword().equals(request.getParameter("password")))	)
				{
					System.out.println("in LoginServlet good"+i);
					session.setAttribute("customer",  customers.get(i));
				
					RequestDispatcher rs = request.getRequestDispatcher("dashboard.jsp");
					rs.forward(request, response);
				} else {
					System.out.println("error"+i);
					IsError = true;
					
					lmsg = "ERROR: The email or password is incorrect!";		
				}
			}
		}
		
		if (IsError) {
			session.setAttribute("lmsg",  lmsg);
			session.setAttribute("customers",  customers);
			
			RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
			rs.forward(request, response);	
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
