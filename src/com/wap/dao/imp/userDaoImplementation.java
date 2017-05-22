package com.wap.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.wap.model.UserModel;
import com.wap.utility.DBUtil;
import com.wap.utility.Utill;

public class userDaoImplementation implements UserDAO {

	private Connection conn;
	private PreparedStatement statement;
	private ResultSet rs;
	private JSONObject obj = new JSONObject();
	Map<String,String> map = new HashMap<String,String>();

	public userDaoImplementation() {
		conn = DBUtil.getConnection();
	}

	@Override
	public Map<String,String> LoginUser(UserModel user) {
		// TODO Auto-generated method stub
		String message = null;
		

		try {
			String q = "select email, password from user where email = ? and password = ?";
			statement = conn.prepareStatement(q);
			// setting the parameters
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			rs = statement.executeQuery();
			if (rs.next()) {
				rs = statement.executeQuery("select * from user where email='" + user.getEmail() + "' and password='"
						+ user.getPassword() + "'");
				while (rs.next()) {

					obj.put("code", "200");
					obj.put("msg", "Login Sucessfull");
					obj.put("id", "" + rs.getInt("id"));
					obj.put("email", rs.getString("email"));
					obj.put("fname", rs.getString("fname"));
					obj.put("lname", rs.getString("lname"));
					obj.put("email", rs.getString("email"));
					obj.put("fname", rs.getString("fname"));
					obj.put("lname", rs.getString("lname"));
					obj.put("contactno", rs.getString("contactno"));
					obj.put("profileimage", rs.getString("profileimage"));
					obj.put("address", rs.getString("address"));
					obj.put("gender", rs.getString("gender"));
					
					//This is done for putting data ino session
					map.put("id", String.valueOf(rs.getInt("id")));
					map.put("email", rs.getString("email"));
					map.put("fname", rs.getString("fname"));
					map.put("lname", rs.getString("lname"));
					map.put("email", rs.getString("email"));
					map.put("fname", rs.getString("fname"));
					map.put("lname", rs.getString("lname"));
					map.put("contactno", rs.getString("contactno"));
					map.put("profileimage", rs.getString("profileimage"));
					map.put("address", rs.getString("address"));
					map.put("gender", rs.getString("gender"));
				}
				message = obj.toJSONString();
				System.out.println(message);
			} else {
				obj.put("code", "201");
				obj.put("msg", "Login fail User and password not coreect");
				message = obj.toJSONString();
				System.out.println(message);

			}
			statement.close();
		} catch (SQLException e) {
			obj.put("code", "201");
			obj.put("msg", "Login fail User and password not coreect");
			message = obj.toJSONString();
			e.printStackTrace();
		}
		map.put("message", message);
		return map;

	}

	@Override
	public String RgisterUser(UserModel user) {
		String message = null;
		try {
			String query = "insert into user (email, fname, lname, password,contactno,profileimage,address, gender) values (?,?,?,?,?,?,?,?)";
			statement = conn.prepareStatement(query);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getfName());
			statement.setString(3, user.getlName());
			statement.setString(4, user.getPassword());
			statement.setString(5, "N/a");
			statement.setString(6, "N/a");
			statement.setString(7, "N/a");
			statement.setString(8, "N/a");
			int executeUpdate = statement.executeUpdate();

			if (executeUpdate == 1) {
				// message = Utill.successJson;
				// } else {
				// message = Utill.failJson;
				rs = statement.executeQuery("select * from user where email='" + user.getEmail() + "' and password='"
						+ user.getPassword() + "'");
				while (rs.next()) {

					obj.put("code", "200");
					obj.put("msg", "Registration Sucessfull");
					obj.put("id", "" + rs.getInt("id"));
					obj.put("email", rs.getString("email"));
					obj.put("fname", rs.getString("fname"));
					obj.put("lname", rs.getString("lname"));
					obj.put("email", rs.getString("email"));
					obj.put("fname", rs.getString("fname"));
					obj.put("lname", rs.getString("lname"));
					obj.put("contactno", rs.getString("contactno"));
					obj.put("profileimage", rs.getString("profileimage"));
					obj.put("address", rs.getString("address"));
					obj.put("gender", rs.getString("gender"));
					

				}
				message = obj.toJSONString();
				System.out.println(message);
			} else {
				obj.put("code", "201");
				obj.put("msg", "Registration fail");
				message = obj.toJSONString();
				System.out.println(message);

			}
			statement.close();
		} catch (SQLException e) {
			obj.put("code", "201");
			obj.put("msg", "Registration fail!!! email allready exit");
			message = obj.toJSONString();
			e.printStackTrace();
		}
		return message;
	}

}
