package com.hms.admin.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.hms.entity.User;

/**
 * AdminLoginServlet - Handles admin login.
 * Updated to use jakarta.servlet.* imports (Jakarta EE 9+).
 */
@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			HttpSession session = req.getSession();
			
			if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
				session.setAttribute("adminObj", new User());
				resp.sendRedirect("admin/index.jsp");
			} else {
				session.setAttribute("errorMsg", "Invalid Username or Password.");
				resp.sendRedirect("admin_login.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
