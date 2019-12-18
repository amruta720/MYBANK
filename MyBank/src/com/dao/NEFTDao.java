package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class NEFTDao {
	public static Connection con;
   // public static Statement stmt;
	public static PreparedStatement ps,ps1;
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
    public void Transfer(){
    	long benf_balance;
    	long rem_balance;
    	int i,j;
    	try{
    		 ps = con.prepareStatement("selct Balance from remitter");
    		 ps1=con.prepareStatement("select Balance from Beneficiary");	
    		i=ps.executeUpdate();
    		j=ps1.executeUpdate();
    		
    	  		System.out.println(i);
    		
    	}catch(Exception e){
    		
    	}
    	
    	
    	
    }
    
   }
