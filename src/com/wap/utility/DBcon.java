package com.wap.utility;

import java.io.*;     
import java.sql.*;
import java.util.Properties;     
 
public class DBcon {     
       public static String driver;
       public static String url;
       public static String user;
       public static String password;
       public static Connection conn;     
       public static Statement stmt;
       public ResultSet rs;
       //configuration CONN
       InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream( "/config.properties" );
       Properties properties=new Properties();
       static{     
           try {   
               driver="com.mysql.jdbc.Driver";  
               url="jdbc:mysql://localhost:3306/wapproject?useUnicode=true&characterEncoding=utf-8";  
               user="root";  
               password="root";                
               Class.forName(driver);     
               conn = DriverManager.getConnection(url,user,password);  
               System.out.println("-------connection successful------");  
           } catch(ClassNotFoundException classnotfoundexception) {     
                 classnotfoundexception.printStackTrace();     
               System.err.println("db: " + classnotfoundexception.getMessage());     
           } catch(SQLException sqlexception) {     
               System.err.println("db.getconn(): " + sqlexception.getMessage());     
           }     
       }     
       //Constructor
       public DBcon(){     
           this.conn=this.getConn();  
       }     
       //return dbcon     
       public Connection getConn(){     
           return this.conn;     
       }     
       //Execute insert
          public void doInsert(String sql) {     
           try {    
        	     
               stmt = conn.createStatement();     
               int i = stmt.executeUpdate(sql);  
                 
           } catch(SQLException sqlexception) {     
               System.err.println("db.executeInset:" + sqlexception.getMessage());     
           }finally{     
                    
           }     
       }     
       //Execute delete
       public void doDelete(String sql) {     
           try {     
               stmt = conn.createStatement();     
               int i = stmt.executeUpdate(sql);     
           } catch(SQLException sqlexception) {     
               System.err.println("db.executeDelete:" + sqlexception.getMessage());     
           }     
       }     
       //Execute update
       public void doUpdate(String sql) {     
           try {     
               stmt = conn.createStatement();     
               int i = stmt.executeUpdate(sql);     
           } catch(SQLException sqlexception) {     
               System.err.println("db.executeUpdate:" + sqlexception.getMessage());     
           }     
       }     
       //Query 
       public ResultSet doSelect(String sql) {     
           try {  
               conn=DriverManager.getConnection(url,user,password);  
               stmt = conn.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);       
               rs = stmt.executeQuery(sql);   
           } catch(SQLException sqlexception) {     
               System.err.println("db.executeQuery: " + sqlexception.getMessage());     
           }     
           return rs;     
       }     
       /**   
        *Close the database result set, db connection   
          @Function: Close all the statement and conn int this instance and close the parameter ResultSet   
          @Param: ResultSet   
          @Exception: SQLException,Exception   
         **/    
        public void close(ResultSet rs) throws SQLException, Exception {     
       
          if (rs != null) {     
            rs.close();     
            rs = null;     
          }     
       
          if (stmt != null) {     
            stmt.close();     
            stmt = null;     
          }     
       
          if (conn != null) {     
            conn.close();     
            conn = null;     
          }     
        }     
       
        /**   
         *Close the db object and connection 
         * Close all the statement and conn int this instance   
         * @throws SQLException   
         * @throws Exception   
         */    
        public void close() throws SQLException, Exception {     
          if (stmt != null) {     
            stmt.close();     
            stmt = null;     
          }     
       
          if (conn != null) {     
            conn.close();     
            conn = null;     
          }     
        }         
}