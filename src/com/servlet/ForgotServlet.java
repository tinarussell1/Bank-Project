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

import com.user.Customer;

/**
 * Servlet implementation class FoorgotServlet
 */
@WebServlet("/ForgotServlet")
public class ForgotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotServlet() {
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
		customer.setConfirmPassword(request.getParameter("confirmPassword"));
		
		String fmsg = "";
		boolean IsError = false;
		if (customers != null) {
			IsError = false;
			for (int i=0; i<customers.size(); i++) {
				if ((customer.getPassword().equals(customer.getConfirmPassword())) 
				  && (customers.get(i).getEmail().equals(request.getParameter("email"))) ) {
					
					customers.get(i).setPassword(customer.getPassword());
					customers.get(i).setConfirmPassword(customer.getConfirmPassword());
					fmsg ="Your password has been reset.";
					
				} else {
					System.out.println("error"+i);
					IsError = true;
					fmsg ="ERROR: The email or password is incorrect!";

				}
			}
		}
	
		session.setAttribute("fmsg",  fmsg);
		session.setAttribute("customers",  customers);
		
		RequestDispatcher rs = request.getRequestDispatcher("forgot.jsp");
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
