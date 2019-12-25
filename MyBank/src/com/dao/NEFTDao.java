package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.concurrent.Callable;

import com.model.NEFTModel;

public class NEFTDao {
	public static Connection con;
   // public static Statement stmt;
	public PreparedStatement ps,ps1,ps2;
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
   public int Transfer(List<NEFTModel> list){
    	con=getConnection();
        NEFTModel NEFT=new NEFTModel();
        NEFT=list.get(0);
        int i=0;
    	try{
    		
            System.out.println(NEFT.getAcc_No()+" dgv "+NEFT.getAmount());
            ps=con.prepareStatement("Update remitter set balance=balance-? where ACCNO=?");
    		ps.setLong(1,NEFT.getAmount());
    		ps.setString(2,NEFT.getAcc_No());
    		i=ps.executeUpdate();
    		ps.close();
         /*
          This will update in remitter table

        */
    		System.out.println(NEFT.getBenefAccNo()+" ryet "+NEFT.getAmount());
    		ps1=con.prepareStatement("Update beneficiary set balance=balance+? where ACCNO=?");
    		ps1.setLong(1,NEFT.getAmount());
    		ps1.setString(2,NEFT.getBenefAccNo());
    	    i=ps1.executeUpdate();
    	    ps1.close();
    	    /*
            This will update in beneficiary table

          */
    	    ps2=con.prepareStatement("insert into transaction_details values(?,?,?,?,recent_transaction.nextval,?)");
    	    ps2.setString(1,NEFT.getAcc_No());
    	    ps2.setString(2,NEFT.getBenefAccNo());
    	    ps2.setString(3,NEFT.getBenef_Name());
    	    ps2.setLong(4,NEFT.getAmount());
    	    ps2.setString(5,NEFT.getDate());

    	    ps2.executeUpdate();
    	    ps2.close();
    	    
    	    
    	    

         System.out.println("update..");
    	}catch(Exception e){
    		System.out.println(e);
    	}
    	return i;    		
    	
    }
    
   }
