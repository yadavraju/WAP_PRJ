package com.wap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wap.dao.imp.UserDAO;
import com.wap.dao.imp.userDaoImplementation;
import com.wap.model.UserModel;
import com.wap.utility.Utill;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
	public static final String HOMEPAGE = "/homepage.jsp";
	public static final String LOGIN = "/login.jsp";

	public UserController() {
		super();
		dao = new userDaoImplementation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("890==" + request.getParameter("n"));
		/*
		 * String forward = ""; String action = request.getParameter("action");
		 * 
		 * if (action.equalsIgnoreCase("register")) { forward = REGISTER; }
		 * RequestDispatcher view = request.getRequestDispatcher(forward);
		 * view.forward(request, response);
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("abc123==" + request.getParameter("n"));

		UserModel user = new UserModel();
		user.setEmail(request.getParameter("email"));
		user.setfName(request.getParameter("fname"));
		user.setlName(request.getParameter("lname"));
		user.setPassword(request.getParameter("password"));
		String message = dao.RgisterUser(user);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");	      
        response.getWriter().write(message);

	}

}
