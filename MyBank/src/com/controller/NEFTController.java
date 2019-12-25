package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		
		HttpSession session=request.getSession();
		List<NEFTModel> lst=(List<NEFTModel>) session.getAttribute("TransactionInfo");
		
		
		
		
		String Acc_No=request.getParameter("AccNo");
		String Benef_Name=request.getParameter("BenefName");
		String IFSCcode=request.getParameter("IFSCcode");
		String Amt=request.getParameter("Amount");
		String Date=request.getParameter("date");

		long Amount=Long.parseLong(Amt);
		String BenfAccNo=request.getParameter("BenefAccNo");
		System.out.println(Acc_No+"  "+Amount);
		NEFTModel model=new NEFTModel();
		model.setAcc_No(Acc_No);
		model.setBenef_Name(Benef_Name);
		model.setAmount(Amount);
		model.setBenefAccNo(BenfAccNo);
		model.setIFSCcode(IFSCcode);
		model.setDate(Date);

		//System.out.println(model.getAcc_No()+" "+model.getAmount());
        
	
		
		NEFTDao NDao=new NEFTDao();
        List<NEFTModel> list=new ArrayList<NEFTModel>();
        list.add(model);
        int i=NDao.Transfer(list);
		if(i>0)
		{
			response.sendRedirect("TransactionSuccessful.jsp");
			
		}
		doGet(request, response);
	}

}
