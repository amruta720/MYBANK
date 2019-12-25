package com.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.model.CreateAccountModel;


import oracle.net.aso.a;

public class CreateAccountDao {
	public static Connection con;
    public PreparedStatement ps1,ps2,ps3,ps4,ps5;
    public ResultSet rs1,rs2,rs3,rs4;
    public Statement s1,s2,s3,s4;
	CreateAccountModel applicant_details=null;
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
     public int Customer_details(List <CreateAccountModel> lst){
    	 int i=0;
    	 con=getConnection();
    	 CreateAccountModel Account_Model= (CreateAccountModel) lst.get(0);
    	 try{
    		 System.out.println(Account_Model.getEmail_Id());
    		 ps1=con.prepareStatement("insert into Customer_Personal_details values(?,?,?,?,?,?,?)");
    		 ps1.setString(1,Account_Model.getCustomer_Name());
    		 ps1.setString(2,Account_Model.getCustomer_Fathers_Name());
	    	 ps1.setString(3,Account_Model.getDate_Of_Birth());
	    	 ps1.setString(4,Account_Model.getGender());
	    	 ps1.setString(5,Account_Model.getNationality());
	    	 ps1.setString(6,Account_Model.getMobile_No());
	    	 ps1.setString(7,Account_Model.getEmail_Id());
	    	 i=ps1.executeUpdate();//table 1
	    	
	    	 i=0;
	    	 ps2=con.prepareStatement("insert into Customer_Address_details values(?,?,?,?,?,?)");
	    	 ps2.setString(1,Account_Model.getEmail_Id());
	    	 ps2.setString(2,Account_Model.getLocal_Address());
	    	 ps2.setString(3,Account_Model.getPermanent_Address());
	    	 ps2.setString(4,Account_Model.getState());
	    	 ps2.setString(5,Account_Model.getCity());
	    	 ps2.setString(6,Account_Model.getPincode());
	    	 i=ps2.executeUpdate();//table 2
	    	 
	    	 i=0;
	    	 ps3=con.prepareStatement("insert into Customer_Identity_details values(?,?,?)");
	    	 ps3.setString(1,Account_Model.getEmail_Id());
	    	 ps3.setString(2,Account_Model.getAadhar_No());
	    	 ps3.setString(3,Account_Model.getPanCard_No());
	    	 i=ps3.executeUpdate();//table 3
	    	 	    	 
            con.close();

    	 }catch(Exception e){
    		 System.out.println(e);
    	 }
     return i;
}
     public int Customer_Document_details(List <CreateAccountModel> lst){
    	 int i=0;
    	 con=getConnection();
    	 CreateAccountModel Account_Model= (CreateAccountModel) lst.get(0);
    	 try{
    		 FileItem file1=Account_Model.getAadharCardDocument();
	    	 FileItem file2=Account_Model.getPanCardDocument();
	    	 FileItem file3=Account_Model.getElectricityBillDocument();
	    	 FileItem file4=Account_Model.getIncomeCertificateDocument();
	    	 FileItem file5=Account_Model.getPassportphotoDocument();
	    	 FileItem file6=Account_Model.getSignDocument();
	    	 
	    	 ps4=con.prepareStatement("insert into customer_document_details values(?,?,?,?,?,?,?)");
	         ps4.setString(1,Account_Model.getEmail_Id());
	         // size must be converted to int otherwise it results in error
	         ps4.setBinaryStream(2, file1.getInputStream(), (int) file1.getSize());
	         ps4.setBinaryStream(3, file2.getInputStream(), (int) file2.getSize());
	         ps4.setBinaryStream(4, file3.getInputStream(), (int) file3.getSize());
	         ps4.setBinaryStream(5, file4.getInputStream(), (int) file4.getSize());
	         ps4.setBinaryStream(6, file5.getInputStream(), (int) file5.getSize());
	         ps4.setBinaryStream(7, file6.getInputStream(), (int) file6.getSize());
	         i=ps4.executeUpdate();
	         con.close();

    	 }catch(Exception e){
    		 System.out.println(e);
    	 }
     return i;
}

	public List<CreateAccountModel> getApplicantData() {
		
		List<CreateAccountModel> applicant_details=new ArrayList<CreateAccountModel>();
		con=getConnection();
		try
		{
			s1=con.createStatement();
			s2=con.createStatement();
			s3=con.createStatement();
			s4=con.createStatement();

			rs1=s1.executeQuery("select * from Customer_Personal_details");
			rs2=s2.executeQuery("select * from Customer_Address_details");
			rs3=s3.executeQuery("select * from Customer_Identity_details");

			while(rs1.next() && rs2.next() && rs3.next())
			{

				CreateAccountModel c1=new CreateAccountModel();
				c1=get(rs1.getString(7));

				c1.setCustomer_Name(rs1.getString(1));
				c1.setCustomer_Fathers_Name(rs1.getString(2));
				c1.setDate_Of_Birth(rs1.getString(3));
				c1.setGender(rs1.getString(4));
				c1.setNationality(rs1.getString(5));
				c1.setMobile_No(rs1.getString(6));
				c1.setEmail_Id(rs1.getString(7));
				
				c1.setLocal_Address(rs2.getString(2));
				c1.setPermanent_Address(rs2.getString(3));
				c1.setState(rs2.getString(4));
				c1.setCity(rs2.getString(5));
				c1.setPincode(rs2.getString(6));

				c1.setAadhar_No(rs3.getString(2));
				c1.setPanCard_No(rs3.getString(3));				
				applicant_details.add(c1);

			}	
            con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return applicant_details;
	}
	public CreateAccountModel get(String email_id) {
		try{
			 ps5 = con.prepareStatement("Select * from customer_document_details where Email_id=?");
		     ps5.setString(1, email_id);
		     rs4 = ps5.executeQuery();
		     if(rs4.next()){
		    	 applicant_details=new CreateAccountModel();
		    	 Blob AadharCard=rs4.getBlob(2);
		    	 Blob PanCard=rs4.getBlob(3);
		    	 Blob ElectricityBill=rs4.getBlob(4);
		    	 Blob IncomeCertificate=rs4.getBlob(5);
		    	 Blob PassportPhoto=rs4.getBlob(6);
		    	 Blob Sign=rs4.getBlob(7);
		    	 
		    	 InputStream inputStream = AadharCard.getBinaryStream();
		         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		         byte[] buffer =new byte[(int) AadharCard.length()];
		    	 int bytesRead=-1;
		    	 while((bytesRead = inputStream.read(buffer)) != -1) {
		             outputStream.write(buffer, 0, bytesRead);
		             byte[] imageBytes = outputStream.toByteArray();
		             String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		             inputStream.close();
		             outputStream.close();
		            applicant_details.setBase64AadharCardDocument(base64Image);
		    	 }
		      	 inputStream = PanCard.getBinaryStream();
		         outputStream = new ByteArrayOutputStream();
		         buffer =new byte[(int) AadharCard.length()];
		    	 bytesRead=-1;
		    	 while((bytesRead = inputStream.read(buffer)) != -1) {
		             outputStream.write(buffer, 0, bytesRead);
		             byte[] imageBytes = outputStream.toByteArray();
		             String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		             inputStream.close();
		             outputStream.close();
		            applicant_details.setBase64PanCardDocument(base64Image);
		    	 }
		      	 inputStream = ElectricityBill.getBinaryStream();
		         outputStream = new ByteArrayOutputStream();
		         buffer =new byte[(int) ElectricityBill.length()];
		    	 bytesRead=-1;
		    	 while((bytesRead = inputStream.read(buffer)) != -1) {
		             outputStream.write(buffer, 0, bytesRead);
		             byte[] imageBytes = outputStream.toByteArray();
		             String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		             inputStream.close();
		             outputStream.close();
		            applicant_details.setBase64ElectricityBillDocument(base64Image);
		    	 }
		      	 inputStream = IncomeCertificate.getBinaryStream();
		         outputStream = new ByteArrayOutputStream();
		         buffer =new byte[(int) IncomeCertificate.length()];
		    	 bytesRead=-1;
		    	 while((bytesRead = inputStream.read(buffer)) != -1) {
		             outputStream.write(buffer, 0, bytesRead);
		             byte[] imageBytes = outputStream.toByteArray();
		             String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		             inputStream.close();
		             outputStream.close();
		            applicant_details.setBase64IncomeCertificateDocument(base64Image);
		    	 }
		      	 inputStream = PassportPhoto.getBinaryStream();
		         outputStream = new ByteArrayOutputStream();
		         buffer =new byte[(int) PassportPhoto.length()];
		    	 bytesRead=-1;
		    	 while((bytesRead = inputStream.read(buffer)) != -1) {
		             outputStream.write(buffer, 0, bytesRead);
		             byte[] imageBytes = outputStream.toByteArray();
		             String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		             inputStream.close();
		             outputStream.close();
		            applicant_details.setBase64PassportphotoDocument(base64Image);
		    	 }
		      	 inputStream = Sign.getBinaryStream();
		         outputStream = new ByteArrayOutputStream();
		         buffer =new byte[(int) Sign.length()];
		    	 bytesRead=-1;
		    	 while((bytesRead = inputStream.read(buffer)) != -1) {
		             outputStream.write(buffer, 0, bytesRead);
		             byte[] imageBytes = outputStream.toByteArray();
		             String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		             inputStream.close();
		             outputStream.close();
		            applicant_details.setBase64SignDocument(base64Image);
		    	 }
		     }
		}
		catch (SQLException ex ) {
		    ex.printStackTrace();
		}   
		catch (IOException ex ) {
		    ex.printStackTrace();
		}    
		
				return applicant_details;	
}

}
