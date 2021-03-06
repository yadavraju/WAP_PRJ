package com.wap.dao.imp;

import java.sql.SQLException;
import java.util.List;

import com.wap.model.PostdataModel;

public interface PostdataDAO {
	public void AddPostdata(PostdataModel postdata);
	//public List<PostdataModel> PostdataQuery() throws SQLException;
	public void DeletePostdata(int id);
	public int IncrementLikes(int userid, int pid) throws SQLException;
	public List<PostdataModel> PostdataQuery(String queryString) throws SQLException;
}
