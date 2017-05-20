package com.wap.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wap.model.UserModel;
import com.wap.utility.DBUtil;
import com.wap.utility.Utill;

public class userDaoImplementation implements  UserDAO{
	
    private Connection conn;
    
    public userDaoImplementation() {
        conn = DBUtil.getConnection();
    }

	@Override
	public void LoginUser(UserModel user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RgisterUser(UserModel user) {
        try {
            String query = "insert into user (email, fname, lname, password,contactno,profileimage,address, gender) values (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, user.getEmail() );
            preparedStatement.setString( 2, user.getfName() );
            preparedStatement.setString( 3, user.getlName() );
            preparedStatement.setString( 4, user.getPassword() );
            preparedStatement.setString( 5, "N/a" );
            preparedStatement.setString( 6, "N/a" );
            preparedStatement.setString( 7, "N/a" );
            preparedStatement.setString( 8, "N/a" );
            preparedStatement.executeUpdate();
            preparedStatement.close();
            Utill.suceesfullyRegister = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

}
