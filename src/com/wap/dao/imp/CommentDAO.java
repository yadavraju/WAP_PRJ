package com.wap.dao.imp;

import java.sql.SQLException;
import java.util.List;

import com.wap.model.CommentModel;

public interface CommentDAO {
	public void AddComment(CommentModel commentmodel);
	public void DeleteComment(int id);
	public List<CommentModel> CommentList() throws SQLException;
}
