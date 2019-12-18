package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.NEFTDao;
import com.model.NEFTModel;

/**
 * Servlet implementation class NEFTController
 */
public class NEFTController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NEFTController() {
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
		// TODO Auto-generated method stub
		String Acc_No=request.getParameter("AccNo");
		String Benef_Name=request.getParameter("BenefName");
		String IFSCcode=request.getParameter("IFSCcode");
		String Amt=request.getParameter("Amount");
		long Amount=Long.parseLong(Amt);
		
		
		
         NEFTDao NDao=new NEFTDao();
          NDao.Transfer();
		
		
		
		doGet(request, response);
	}

}
