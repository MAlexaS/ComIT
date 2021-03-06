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

@WebServlet(urlPatterns = "/PersonUpdate.do")
public class PersonUpdateServlet extends HttpServlet {

	private PersonService service = new PersonService(); 

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			String userId= request.getParameter("person");
			request.setAttribute("User", service.getPerson(Integer.parseInt(userId)));
			request.setAttribute("personId", userId);
		
			request.getRequestDispatcher("/WEB-INF/views/PersonUpdate.jsp").forward(request, response);
		} catch (MuelitasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		int a = Integer.parseInt(userId);
		System.out.println("userId: " + userId);
		
		try {
			Boolean res = service.updatePerson(a);
		} catch (NumberFormatException | MuelitasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("admin.do");
			
	}
	
	
	
}