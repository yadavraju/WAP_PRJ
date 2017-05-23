package com.wap.dao.imp;

import java.sql.SQLException;
import java.util.List;

import com.wap.model.LikeModel;
import com.wap.model.PostdataModel;

public interface LikeDAO {
	public void AddLike(LikeModel likemodel);
	public void DeleteUserlike(int id);
	List<PostdataModel> UserLikeList(int pid) throws SQLException;
}
