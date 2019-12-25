package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CreateAccountDao;
import com.model.CreateAccountModel;

/**
 * Servlet implementation class DisplayController
 */
public class DisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DisplayController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CreateAccountDao applicantdata=new CreateAccountDao();
		List<CreateAccountModel> applicantdatalist=applicantdata.getApplicantData();
		
		HttpSession s=request.getSession(true);
		s.setAttribute("ApplicantDetails",applicantdatalist);
		response.sendRedirect("DisplayApplication.jsp");
		
		
	//	System.out.println(.getCustomer_Name());
	//  request.setAttribute("data",applicantdatalist);
	//	RequestDispatcher view = request.getRequestDispatcher("DisplayApplication.jsp");
	//  view.forward(request, response);
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

	}

}
