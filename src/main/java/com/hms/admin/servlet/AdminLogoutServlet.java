package com.hms.admin.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * AdminLogoutServlet - Handles admin logout.
 * Updated to use jakarta.servlet.* imports (Jakarta EE 9+).
 */
@WebServlet("/adminLogout")
public class AdminLogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.removeAttribute("adminObj");
		session.setAttribute("successMsg", "Admin Logout Successfully");
		resp.sendRedirect("admin_login.jsp");
		
	}

}
