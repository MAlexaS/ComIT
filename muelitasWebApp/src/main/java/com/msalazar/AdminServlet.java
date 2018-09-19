package com.msalazar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msalazar.data.User;
import com.msalazar.exceptions.MuelitasException;

/*
 * Browser sends Http Request to Web Server
 * 
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * JEE with Servlets
 * 
 * Web Server responds with Http Response
 */

//Java Platform, Enterprise Edition (Java EE) JEE6

//Servlet is a Java programming language class 
//used to extend the capabilities of servers 
//that host applications accessed by means of 
//a request-response programming model.

//1. extends javax.servlet.http.HttpServlet
//2. @WebServlet(urlPatterns = "/login.do")
//3. doGet(HttpServletRequest request, HttpServletResponse response)
//4. How is the response created?

@WebServlet(urlPatterns = "/admin.do")
public class AdminServlet extends HttpServlet {

	private AdminService service = new AdminService(); 

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			request.setAttribute("list", service.getAll());
			request.getRequestDispatcher("/WEB-INF/views/UserAdmin.jsp").forward(request, response);
		} catch (MuelitasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String roleUser = request.getParameter("roleUser");
		String password = request.getParameter("password");
		
		//System.out.println("LoginServlet username: "+ username);
	
		User oUser = null;
		try {
			oUser = service.insertUser(name, lastName, username, roleUser, password);
		} catch (MuelitasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/admin.do");
		
	}
	
	
	
}