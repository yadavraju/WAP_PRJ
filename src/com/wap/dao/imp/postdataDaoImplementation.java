package com.wap.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		              "userid) VALUES ("+
		               "'"+product_you_offer+"',"+
		               "'"+describe_your_offer+"',"+
		               "'"+product_you_need+"',"+
		               "'"+describe_your_need+"',"+
		               like_count+","+
		               comment_count+","+
		               userid+")";
		              
		dbcon.doInsert(sql);             
	}

	@Override
	public List<PostdataModel> PostdataQuery() throws SQLException {
		// TODO Auto-generated method stub
		List<PostdataModel> postdataList=new ArrayList<PostdataModel>();
		
		String sql="select * from postdata order by pid";
		ResultSet rs=dbcon.doSelect(sql);

		while(rs.next()){
			PostdataModel postdata=new PostdataModel();
			postdata.setPid(rs.getInt("pid"));
			postdata.setProduct_you_offer(rs.getString("product_you_offer"));
			postdata.setDescribe_your_offer(rs.getString("describe_your_offer"));
			postdata.setProduct_you_need(rs.getString("product_you_need"));
			postdata.setLike_count(rs.getInt("like_count"));
			postdata.setComment_count(rs.getInt("comment_count"));
			postdata.setUserid(rs.getInt("userid"));
			postdata.setDate(rs.getDate("date"));
			postdataList.add(postdata);
		}
		
		return postdataList;
	}

	@Override
	public void DeletePostdata(int id) {
		// TODO Auto-generated method stub
		
		String sql="delete from postdata where pid="+id;
		dbcon.doDelete(sql);
	}

}
