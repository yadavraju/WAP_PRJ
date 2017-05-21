package com.wap.dao.imp;

import java.sql.SQLException;
import java.util.List;

import com.wap.model.LikeModel;

public interface LikeDAO {
	public void AddLike(LikeModel likemodel);
	public void DeleteUserlike(int id);
	public List<LikeModel> UserlikeList() throws SQLException;
}
