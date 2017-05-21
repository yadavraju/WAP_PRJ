package com.wap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wap.dao.imp.LikeDAO;
import com.wap.dao.imp.likeDaoImplementation;
import com.wap.model.LikeModel;

/**
 * Servlet implementation class LikeController
 */
@WebServlet("/LikeController")
public class LikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LikeDAO likedao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeController() {
        super();
        // TODO Auto-generated constructor stub
        likedao=new likeDaoImplementation();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LikeModel likemodel=new LikeModel();
		likemodel.setPostid(Integer.parseInt(request.getParameter("postid")));
		likemodel.setUserid(Integer.parseInt(request.getParameter("userid")));
		
		likedao.AddLike(likemodel);
		System.out.println("Insert like in controller");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
