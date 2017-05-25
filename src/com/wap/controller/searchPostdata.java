package com.wap.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wap.dao.imp.PostdataDAO;
import com.wap.dao.imp.postdataDaoImplementation;
import com.wap.model.PostdataModel;


/**
 * Servlet implementation class searchPostdata
 */
@WebServlet("/searchPostdata")
public class searchPostdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostdataDAO postdatadao;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchPostdata() {
        super();
        // TODO Auto-generated constructor stub
        postdatadao=new postdataDaoImplementation();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<PostdataModel> postdataList=new ArrayList<PostdataModel>();
		
		String queryString=request.getParameter("inputsearch")==null?"":request.getParameter("inputsearch").trim();
		try {
			postdataList=postdatadao.PostdataQuery(queryString);
			request.setAttribute("postdataList", postdataList);
			request.getRequestDispatcher("postQuery.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
