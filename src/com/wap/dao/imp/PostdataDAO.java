package com.wap.dao.imp;

import java.sql.SQLException;

import com.wap.model.PostdataModel;

public interface PostdataDAO {
	public void AddPostdata(PostdataModel postdata);
	public PostdataModel[] showPostdata() throws SQLException;
	public void DeletePostdata(int id);
}
