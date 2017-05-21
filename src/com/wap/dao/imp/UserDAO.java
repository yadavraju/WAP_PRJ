package com.wap.dao.imp;

import java.util.Map;

import com.wap.model.UserModel;

public interface UserDAO {
	
	public Map<String,String> LoginUser(UserModel user);
	public String RgisterUser(UserModel user);

}
