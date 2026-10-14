package com.hms.user.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * MyNewServlet - Legacy servlet kept for compatibility.
 * Updated to use jakarta.servlet.* imports (Jakarta EE 9+).
 */
@WebServlet("/MyNewServletRegisterUser")
public class MyNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyNewServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
