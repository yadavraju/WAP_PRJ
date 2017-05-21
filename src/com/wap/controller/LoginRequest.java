package com.wap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wap.dao.imp.UserDAO;
import com.wap.dao.imp.userDaoImplementation;
import com.wap.model.UserModel;

/**
 * Servlet implementation class LoginRequest
 */
@WebServlet("/LoginRequest")
public class LoginRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginRequest() {
        super();
        dao = new userDaoImplementation();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        System.out.println("============"+username+password);
        
		UserModel user = new UserModel();
		user.setEmail(username);
		user.setPassword(password);
		String message = dao.LoginUser(user);
         
        response.getWriter().write(message);
	}


}
