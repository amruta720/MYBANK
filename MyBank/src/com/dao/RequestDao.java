package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.model.CreateAccountModel;

public class RequestDao {
	public static Connection con;
    public static Statement stmt;
    private String driver="oracle.jdbc.OracleDriver";
    private String url="jdbc:oracle:thin:@localhost:1521:XE";
    private String username="System";
    private String password="123456789";
    public Connection getConnection()
    {
   	 
  try  {
   	 Class.forName(driver);
   	 con=DriverManager.getConnection(url,username,password);
   	 System.out.println("Connection "+con);
    }catch(Exception e)
  {
System.out.println(e);	
}return con;
    }
      public static void info(){
    	  try{
    		  Statement stmt=con.createStatement();
    		  ResultSet rs=stmt.executeQuery("select * from Customer_Personal_details");
    		  while(rs.next()){
    			  System.out.println(rs.getString(1)+""+rs.getString(2)+""+rs.getString(3)+""+rs.getString(4)+""+rs.getString(5)+""+rs.getString(6));
    		  
    		  }
    		  
    	  }catch(Exception e)
    	  {
    		  
    	  }
    	  
      }
    }
    
   


