package com.wap.dao.imp;

import com.wap.model.LikeModel;
import com.wap.utility.DBcon;

public class likeDaoImplementation implements LikeDAO {
    
	DBcon dbcon=new DBcon();
	
	@Override
	public void AddLike(LikeModel likemodel) {
		// TODO Auto-generated method stub
				
		int postid=likemodel.getPostid();
		int userid=likemodel.getUserid();
		
		String sql="insert into userlike(postid,userid) values("+postid+","+userid+")";
		
		System.out.println(sql);
		
		dbcon.doInsert(sql);
		System.out.println("insert like successfully");

	}

	@Override
	public void DeleteUserlike(int id) {
		// TODO Auto-generated method stub
		
		String sql="delete from userlike where id="+id;
		
	    dbcon.doDelete(sql);
		
	}

}
