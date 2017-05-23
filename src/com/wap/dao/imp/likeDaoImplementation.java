package com.wap.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wap.model.LikeModel;
import com.wap.model.PostdataModel;
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
		
		String sql="delete from userlike where lid="+id;
		
	    dbcon.doDelete(sql);
		
	}

	@Override
	public List<PostdataModel> UserLikeList(int pid) throws SQLException {
		// TODO Auto-generated method stub
		
		List<PostdataModel> userlikeList =new ArrayList<PostdataModel>();
		
		String sql="select * from postdata where pid=" + pid;
		ResultSet rs=dbcon.doSelect(sql);
		
		while(rs.next()){
			PostdataModel userlike=new PostdataModel();
			userlike.setLike_count(rs.getInt("like_count"));
			userlikeList.add(userlike);
		}
		
		return userlikeList;
	}

}
