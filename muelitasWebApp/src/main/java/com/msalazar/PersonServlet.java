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



@WebServlet(urlPatterns = "/PersonAdmin.do")
public class PersonServlet extends HttpServlet {

	private PersonService service = new PersonService(); 

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			request.setAttribute("list", service.getAll());
			request.getRequestDispatcher("/WEB-INF/views/PersonAdmin.jsp").forward(request, response);
		} catch (MuelitasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}