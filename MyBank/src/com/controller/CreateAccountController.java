package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.lang.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;

import com.dao.CreateAccountDao;
import com.model.CreateAccountModel;

/**
 * Servlet implementation class CreateAccountController
 */
public class CreateAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
		
    public CreateAccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 String Customer_Name=request.getParameter("FirstName")+" "+(String)request.getParameter("MiddleName")+" "+(String)request.getParameter("LastName");
		 String Customer_Fathers_Name=request.getParameter("FatherFirstName")+" "+(String)request.getParameter("FatherMiddleName")+" "+(String)request.getParameter("FatherLastName");
		 String DateOfBirth=request.getParameter("Date_Of_Birth");
		 String Gender=request.getParameter("Gender");
		 String Nationality=request.getParameter("Nationality");
		 String AadharNo=request.getParameter("AadharNo");
		 String PanCardNo=request.getParameter("PanCardNo");
		 String Local_Address=request.getParameter("LocalAddress");
		 String Permanent_Address=request.getParameter("PermanentAddress");
		 String State=request.getParameter("State");
		 String City=request.getParameter("City");		
		 String Pincode=request.getParameter("Pincode");
		 String MobileNo=request.getParameter("MobileNo");
		 String Email_Id=request.getParameter("Email_Id");
		 System.out.println(Customer_Name);
	   System.out.println(Email_Id);
		 
		
		CreateAccountModel AccModel=new CreateAccountModel();

		AccModel.setCustomer_Name(Customer_Name);
		AccModel.setCustomer_Fathers_Name(Customer_Fathers_Name);
		AccModel.setDate_Of_Birth(DateOfBirth);
		AccModel.setGender(Gender);
		AccModel.setNationality(Nationality);
		AccModel.setMobile_No(MobileNo);
		AccModel.setEmail_Id(Email_Id);

		AccModel.setLocal_Address(Local_Address);
		AccModel.setPermanent_Address(Permanent_Address);
		AccModel.setCity(City);
		AccModel.setState(State);
		AccModel.setPincode(Pincode);
		
		AccModel.setAadhar_No(AadharNo);
		AccModel.setPanCard_No(PanCardNo);

		List<CreateAccountModel> lst=new ArrayList<CreateAccountModel>();
		lst.add(AccModel);
	   
	  
	  CreateAccountDao Account_Dao=new CreateAccountDao();
	  int i=Account_Dao.Customer_details(lst);
	  
	  if(i>0)
	  {
		  response.sendRedirect("Upload.jsp");
	  }
	  
		//doGet(request, response);
	}

}
