package com.wap.dao.imp;

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
		String sql="delete from comment where id="+id;
		dbcon.doDelete(sql);
	}

}
