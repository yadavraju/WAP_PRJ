package com.wap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wap.dao.imp.PostdataDAO;
import com.wap.dao.imp.postdataDaoImplementation;

/**
 * Servlet implementation class DeletePostdata
 */
@WebServlet("/DeletePostdata")
public class DeletePostdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostdataDAO postdatadao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePostdata() {
        super();
        // TODO Auto-generated constructor stub
        postdatadao=new postdataDaoImplementation();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid=Integer.parseInt(request.getParameter("pid"));
		postdatadao.DeletePostdata(pid);
		request.getRequestDispatcher("PostdataQuery").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
