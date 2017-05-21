package com.wap.dao.imp;

import com.wap.model.CommentModel;

public interface CommentDAO {
	public void AddComment(CommentModel commentmodel);
	public void DeleteComment(int id);
}
