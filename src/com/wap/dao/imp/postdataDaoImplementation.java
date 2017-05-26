package com.wap.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.wap.model.PostdataModel;
import com.wap.utility.DBcon;

public class postdataDaoImplementation implements PostdataDAO {
	
    DBcon dbcon=new DBcon();

	@Override
	public void AddPostdata(PostdataModel postdata) {
		// TODO Auto-generated method stub

		String product_you_offer=postdata.getProduct_you_need();
	    String describe_your_offer=postdata.getDescribe_your_offer();
	    String product_you_need=postdata.getProduct_you_need();
	    String describe_your_need=postdata.getDescribe_your_need();
	    String logi = postdata.getLongitude();
	    String lati = postdata.getLatitude();
	    int like_count=postdata.getLike_count();
	    int comment_count=postdata.getComment_count();
	    int userid=postdata.getUserid();
	        
		String sql="INSERT INTO postdata ("+
		              "product_you_offer,"+
		              "describe_your_offer,"+
		              "product_you_need,"+
		              "describe_your_need,"+
		              "like_count,"+
		              "comment_count,"+
		              "longitude,"+
		              "latitude,"+
		              "userid) VALUES ("+
		               "'"+product_you_offer+"',"+
		               "'"+describe_your_offer+"',"+
		               "'"+product_you_need+"',"+
		               "'"+describe_your_need+"',"+
		               "'"+logi+"',"+
		               "'"+lati+"',"+
		               like_count+","+
		               comment_count+","+
		               userid+")";
		              
		dbcon.doInsert(sql);             
	}

	@Override
	public List<PostdataModel> PostdataQuery() throws SQLException {
		// TODO Auto-generated method stub
		List<PostdataModel> postdataList=new ArrayList<PostdataModel>();
		
		String sql="select * from postdata order by date desc";
		ResultSet rs=dbcon.doSelect(sql);

		while(rs.next()){
			PostdataModel postdata=new PostdataModel();
			postdata.setPid(rs.getInt("pid"));
			postdata.setProduct_you_offer(rs.getString("product_you_offer"));
			postdata.setDescribe_your_offer(rs.getString("describe_your_offer"));
			postdata.setProduct_you_need(rs.getString("product_you_need"));
			postdata.setDescribe_your_need(rs.getString("describe_your_need"));
			postdata.setLike_count(rs.getInt("like_count"));
			postdata.setComment_count(rs.getInt("comment_count"));
			postdata.setUserid(rs.getInt("userid"));
			postdata.setDate(rs.getDate("date"));
			
			postdata.setLongitude(rs.getString("longitude"));
			postdata.setLatitude(rs.getString("latitude"));
			postdataList.add(postdata);
		}
		
		//Collections.reverse(postdataList);
		return postdataList;
	}

	@Override
	public void DeletePostdata(int id) {
		// TODO Auto-generated method stub
		
		String sql="delete from postdata where pid="+id;
		dbcon.doDelete(sql);
	}
	
	@Override
	public int IncrementLikes(int userid, int pid) throws SQLException  {
		// TODO Auto-generated method stub
		int isLike = 0;
		String sel = "select isLike from userlike where userid=" + userid + " and postid=" + pid;
		System.out.println("sel----" + sel);
		ResultSet rs = dbcon.doSelect(sel);
		
		if(!rs.next()) {
			String insert="insert into userlike(postid,userid) values(" + pid + "," + userid + ")";
			dbcon.doInsert(insert);
			
			String sql = "update postdata set like_count = like_count+1 where pid=" + pid;
			dbcon.doUpdate(sql);
			
			isLike = 1;
		}
//		else {
//			String updateSql = "update userlike set isLike = 1 where userid=" + userid + " and postid=" + pid;
//			dbcon.doUpdate(updateSql);
//			
//			String sql = "update postdata set like_count = like_count+1 where pid=" + pid;
//			dbcon.doUpdate(sql);
//			
//			isLike = 1;
//		}
		
		return isLike;
	}

	@Override
	public List<PostdataModel> PostdataQuery(String queryString) throws SQLException {
		// TODO Auto-generated method stub
		List<PostdataModel> postdataList=new ArrayList<PostdataModel>();
		
		String sql="";
		if(queryString.trim().length()>0){
		sql="SELECT * FROM postdata WHERE product_you_offer LIKE '%"+queryString+"%'"+
				    "OR describe_your_offer LIKE '%"+queryString+"%'"+
				    "OR product_you_need LIKE '%"+queryString+"%'"+
				    "OR describe_your_need LIKE '%"+queryString+"%' ORDER BY DATE DESC"; 
		}else{
			sql="select * from postdata order by date desc";
		}
		ResultSet rs=dbcon.doSelect(sql);
		while (rs.next()){
			PostdataModel postdata=new PostdataModel();
			postdata.setPid(rs.getInt("pid"));
			postdata.setProduct_you_offer(rs.getString("product_you_offer"));
			postdata.setDescribe_your_offer(rs.getString("describe_your_offer"));
			postdata.setProduct_you_need(rs.getString("product_you_need"));
			postdata.setDescribe_your_need(rs.getString("describe_your_need"));
			postdata.setLike_count(rs.getInt("like_count"));
			postdata.setComment_count(rs.getInt("comment_count"));
			postdata.setUserid(rs.getInt("userid"));
			postdata.setDate(rs.getDate("date"));
			postdataList.add(postdata);
		}
		
		return postdataList;
	}
}
