package com.wap.dao.imp;

import com.wap.model.LikeModel;

public interface LikeDAO {
	public void AddLike(LikeModel likemodel);
	public void DeleteUserlike(int id);
}
