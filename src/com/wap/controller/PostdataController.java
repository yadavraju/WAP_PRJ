package com.wap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wap.dao.imp.PostdataDAO;
import com.wap.dao.imp.postdataDaoImplementation;
import com.wap.dao.imp.userDaoImplementation;
import com.wap.model.PostdataModel;

/**
 * Servlet implementation class PostdataController
 */
@WebServlet("/PostdataController")
public class PostdataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostdataDAO postdatadao;
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostdataController() {
        super();
        // TODO Auto-generated constructor stub
        postdatadao=new postdataDaoImplementation();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PostdataModel postdata=new PostdataModel();
		
		postdata.setProduct_you_offer(request.getParameter("product_you_offer"));
		postdata.setDescribe_your_offer(request.getParameter("describe_your_offer"));
		postdata.setProduct_you_need(request.getParameter("product_you_need"));
		postdata.setDescribe_your_need(request.getParameter("describe_your_need"));
		postdata.setComment_count(Integer.parseInt(request.getParameter("like_count")));
		postdata.setLike_count(Integer.parseInt(request.getParameter("comment_count")));
		postdata.setUserid(Integer.parseInt(request.getParameter("userid")));
	    
		System.out.println("ok=====================");
		
		System.out.println(postdata.getComment_count());
		System.out.println(postdata.getDescribe_your_need());
		System.out.println(postdata.getDescribe_your_offer());
		System.out.println(postdata.getLike_count());
		System.out.println(postdata.getProduct_you_need());
		System.out.println(postdata.getProduct_you_offer());
		System.out.println(postdata.getUserid());
		
		
        postdatadao.AddPostdata(postdata);
        
        
        PostdataModel[] postdataRecords=new PostdataModel[10];
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
