package com.msalazar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msalazar.data.User;

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

@WebServlet(urlPatterns = "/secretary.do")
public class SecretaryServlet extends HttpServlet {
	
	private UserValidationService service = new UserValidationService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/secretary.jsp").forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//System.out.println("LoginServlet username: "+ username);
	
		User oUser = service.isUserValid(username, password);
		
		if(oUser!=null) {
			/*
			//commented by MS
			request.setAttribute("username", username);
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
			*/
			// save session and role
			request.getSession().setAttribute("sUsername", oUser.getUserName());
			//role
			int role = oUser.getRole().getId();
			String profile = "";
			String redirect = "";
			switch (role) {
			case 12:
				profile = "SEC";
				redirect = "/secretary.do";
				break;
			case 13:
				profile = "DOC";
				redirect = "/doctor.do";
				break;
			case 14:
				profile = "ADM";
				redirect = "/admin.do";
				break;
			default:
				redirect = "/login.do?errorMessage=UnderConstruction";
				
				break;
			}
			request.getSession().setAttribute("sRole", profile);
			response.sendRedirect(redirect);
			
		} else
		{
			request.setAttribute("errorMessage", "Invalid Credentials!!");
			request.setAttribute("username", username);
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			
		}
		
		
		
		
		
		
	}
	
	
	
}