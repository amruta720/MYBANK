package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import com.model.CreateAccountModel;

public class CreateAccountDao {
	public static Connection con;
    public static PreparedStatement ps,ps1,ps2;
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
     public int Customer_Personal_details(List <CreateAccountModel> lst){
    	 int i=0;
    	 int cnt=0;
    	 con=getConnection();
    	 CreateAccountModel Account_Model= (CreateAccountModel) lst.get(0);
    	 try{
    		 System.out.println(Account_Model.getEmail_Id());
    		 ps=con.prepareStatement("insert into Customer_Personal_details values(?,?,?,?,?,?,?)");
    	 ps.setString(1,Account_Model.getCustomer_Name());
    	 ps.setString(2,Account_Model.getCustomer_Fathers_Name());
    	 ps.setString(3,Account_Model.getDate_Of_Birth());
    	 ps.setString(4,Account_Model.getGender());
    	 ps.setString(5,Account_Model.getNationality());
    	 ps.setString(6,Account_Model.getMobile_No());
    	 ps.setString(7,Account_Model.getEmail_Id());
    	 i=ps.executeUpdate();//table 1
    	
    	 
    	 ps1=con.prepareStatement("insert into Customer_Address_details values(?,?,?,?,?,?)");
    	 ps1.setString(1,Account_Model.getEmail_Id());
    	 ps1.setString(2,Account_Model.getLocal_Address());
    	 ps1.setString(3,Account_Model.getPermanent_Address());
    	 ps1.setString(4,Account_Model.getState());
    	 ps1.setString(5,Account_Model.getCity());
    	 ps1.setString(6,Account_Model.getPincode());
    	 i=ps1.executeUpdate();//table 2
    	 
    	 
    	 
    	 
    	 ps2=con.prepareStatement("insert into Customer_Identity_details values(?,?,?)");
    	 ps2.setString(1,Account_Model.getEmail_Id());
    	 ps2.setString(2,Account_Model.getAadhar_No());
    	 ps2.setString(3,Account_Model.getPanCard_No());
    	 i=ps2.executeUpdate();//table 3
    	 
    	 }catch(Exception e){
    		 System.out.println(e);
    	 }if(i>0)
    	 {
    		 System.out.println("test4");
    		 cnt=1;
    	 }
     return cnt;
}}
