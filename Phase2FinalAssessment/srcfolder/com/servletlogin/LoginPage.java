package com.servletlogin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginPage
 */
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		if(username==null | username.equals("")) {
			response.sendRedirect("invalid.jsp?error=1");
		}
		else if(password==null|password.equals("")) {
			response.sendRedirect("invalid.jsp?error=2");
		}
		else if(username.equalsIgnoreCase("Varun")&& password.equals("1234")) {
			HttpSession session=request.getSession();
			session.setAttribute("username", username);

			RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp");
			rd.forward(request,response);		}
		else
		{
			response.sendRedirect("invalid.jsp?error=3");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
