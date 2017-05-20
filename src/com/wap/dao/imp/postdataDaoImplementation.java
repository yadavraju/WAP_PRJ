package com.wap.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wap.model.PostdataModel;
import com.wap.utility.DBcon;

public class postdataDaoImplementation implements PostdataDAO {
	
    DBcon dbcon=new DBcon();
    PostdataModel postdata=new PostdataModel();

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
	public PostdataModel[] showPostdata() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from postdata";
		ResultSet rs=dbcon.doSelect(sql);
		int rows=rs.getRow();
		int i=0;
		PostdataModel[] postdataRows=new PostdataModel[rows];
		if(rs.next()){
			postdataRows[i].setPid(rs.getInt("pid"));
			postdataRows[i].setProduct_you_offer(rs.getString("product_you_offer"));
			postdataRows[i].setDescribe_your_offer(rs.getString("describe_your_offer"));
			postdataRows[i].setProduct_you_need(rs.getString("product_you_need"));
			postdataRows[i].setLike_count(rs.getInt("like_count"));
			postdataRows[i].setComment_count(rs.getInt("comment_count"));
			postdataRows[i].setUserid(rs.getInt("userid"));
			postdataRows[i].setDate(rs.getDate("date"));
		}
		
		return postdataRows;
	}

}
