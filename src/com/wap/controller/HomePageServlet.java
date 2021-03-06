package com.wap.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wap.dao.imp.CommentDAO;
import com.wap.dao.imp.LikeDAO;
import com.wap.dao.imp.PostdataDAO;
import com.wap.dao.imp.commentDaoImplementation;
import com.wap.dao.imp.likeDaoImplementation;
import com.wap.dao.imp.postdataDaoImplementation;
import com.wap.model.CommentModel;
import com.wap.model.PostdataModel;


/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostdataDAO postdatadao;
	private CommentDAO commentbyiddatadao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageServlet() {
        super();
        // TODO Auto-generated constructor stub
        postdatadao = new postdataDaoImplementation();
        commentbyiddatadao = new commentDaoImplementation();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("postid"));
//		System.out.println("showcomment-------------" + request.getParameter("showcomment"));
////		if(request.getParameter("showcomment") != null && !"".equals(request.getParameter("showcomment"))){
//			pid = Integer.parseInt(request.getParameter("showcomment"));
//			try {
//				request.setAttribute("list_of_posted_comment_by_id", commentbyiddatadao.CommentListByID(pid));
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	        response.getWriter().write(new Gson().toJson(request.getAttribute("list_of_posted_comment_by_id")));
//		}else{
			String queryString = "";
			List<PostdataModel> list = null;
			try {
				
				queryString= request.getParameter("inputsearch") == null?"":request.getParameter("inputsearch").trim();
				System.out.println("queryString:" + queryString);
				list = postdatadao.PostdataQuery(queryString);
				for (PostdataModel postdataModel : list) {
					List<CommentModel> listCommentModel = commentbyiddatadao.CommentListByID(postdataModel.getPid());
//					if(request.getAttribute("list_like_counts") == null) {
//						List<PostdataModel> likeList = likedatadao.UserLikeList(postdataModel.getPid());
//						request.setAttribute("list_like_counts", likeList);
//					}
					
					System.out.println(listCommentModel.size()+"====");
					postdataModel.setListCommentModel(listCommentModel);

				}
				
				request.setAttribute("list_of_posted_data", list);
				System.out.println(new Gson().toJson(list));
				
				System.out.println("id:" + request.getSession().getAttribute("id").toString());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			if(queryString.isEmpty())
				request.getRequestDispatcher("index.jsp").forward(request, response);
//			else
//				response.getWriter().write(new Gson().toJson(list));
//		}
	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
