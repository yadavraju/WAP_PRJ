package com.wap.dao.imp;

import java.sql.SQLException;
import java.util.List;

import com.wap.model.PostdataModel;

public interface PostdataDAO {
	public void AddPostdata(PostdataModel postdata);
	public List<PostdataModel> PostdataQuery() throws SQLException;
	public void DeletePostdata(int id);
	public void IncrementLikes(int pid) throws SQLException;
}
