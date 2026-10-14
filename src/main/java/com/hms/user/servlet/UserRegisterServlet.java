package com.hms.user.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.hms.dao.UserDAO;
import com.hms.db.DBConnection;
import com.hms.entity.User;

/**
 * UserRegisterServlet - Handles new user registration.
 * Updated to use jakarta.servlet.* imports (Jakarta EE 9+).
 */
@WebServlet("/user_register")
public class UserRegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String fullName = req.getParameter("fullName");
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			User user = new User(fullName, email, password);

			UserDAO userDAO = new UserDAO(DBConnection.getConn());
			
			HttpSession session = req.getSession();

			boolean f = userDAO.userRegister(user);

			if (f == true) {
				session.setAttribute("successMsg", "Register Successfully");
				resp.sendRedirect("signup.jsp");
			} else {
				session.setAttribute("errorMsg", "Something went wrong!");
				resp.sendRedirect("signup.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
