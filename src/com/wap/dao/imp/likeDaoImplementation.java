package com.wap.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<LikeModel> UserlikeList() throws SQLException {
		// TODO Auto-generated method stub
		
		List<LikeModel> userlikeList =new ArrayList<LikeModel>();
		
		String sql="select * from userlike order by lid";
		ResultSet rs=dbcon.doSelect(sql);
		
		while(rs.next()){
			LikeModel userlike=new LikeModel();
			userlike.setLid(rs.getInt("lid"));
			userlike.setPostid(rs.getInt("postid"));
			userlike.setUserid(rs.getInt("userid"));
			userlike.setDate(rs.getDate("date"));
			userlikeList.add(userlike);
		}
		
		return userlikeList;
	}

}
