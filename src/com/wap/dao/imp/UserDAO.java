package com.wap.dao.imp;

import com.wap.model.UserModel;

public interface UserDAO {
	
	public String LoginUser(UserModel user);
	public String RgisterUser(UserModel user);

}
