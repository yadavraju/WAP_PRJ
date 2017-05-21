package com.wap.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wap.model.CommentModel;
import com.wap.utility.DBcon;

public class commentDaoImplementation implements CommentDAO {
    
	DBcon dbcon=new DBcon();

	@Override
	public void AddComment(CommentModel commentmodel) {
		// TODO Auto-generated method stub
		
		
		int postid=commentmodel.getPostid();
		int userid=commentmodel.getUserid();
		String comment=commentmodel.getComment();
		
		String sql="insert into comment(postid,userid,comment) values("+
		           postid+","+userid+",'"+comment+"')";
		
		dbcon.doInsert(sql);
		System.out.println("insert comment successfully");
	}

	@Override
	public void DeleteComment(int id) {
		// TODO Auto-generated method stub
		String sql="delete from comment where cid="+id;
		dbcon.doDelete(sql);
	}

	@Override
	public List<CommentModel> CommentList() throws SQLException {
		// TODO Auto-generated method stub
		
		List<CommentModel> commentList=new ArrayList<CommentModel>();
		
		String sql="select * from comment order by cid";
		
		ResultSet rs=dbcon.doSelect(sql);
		
		while (rs.next()){
			CommentModel comment=new CommentModel();
			comment.setCid(rs.getInt("cid"));
			comment.setPostid(rs.getInt("postid"));
			comment.setUserid(rs.getInt("userid"));
			comment.setComment(rs.getString("comment"));
			comment.setDate(rs.getDate("date"));
			commentList.add(comment);
		}
		return commentList;
	}

}
