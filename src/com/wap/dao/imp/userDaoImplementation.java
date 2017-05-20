package com.wap.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public String LoginUser(UserModel user) {
		// TODO Auto-generated method stub
		String message = null;
        try {
        	String q = "select email, password from user where email = ? and password = ?";
            PreparedStatement statement = conn.prepareStatement(q);
            //setting the parameters
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            //executing the prepared statement, which returns a ResultSet
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                message = "SUCCESS";
            }else{
                message = "FAILURE";
            }
           // statement.executeUpdate();
            //statement.close();
        } catch (SQLException e) {
        	message = "FAILURE";
            e.printStackTrace();
        }
		return message;
		
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

            Utill.suceesfullyRegister = true;
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

}
