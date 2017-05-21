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
 * Servlet implementation class PostdataQuery
 */
@WebServlet("/PostdataQuery")
public class PostdataQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostdataDAO postdatadao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostdataQuery() {
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
		
		try {
			postdataList=postdatadao.PostdataQuery();
			for (int i=0;i<postdataList.size();i++){
				//list the output data.
			}
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
