package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.CreateAccountDao;
import com.model.CreateAccountModel;

/**
 * Servlet implementation class AddPhotoController
 */
@WebServlet("/AddPhotoController")
public class AddPhotoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPhotoController() {
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

        PrintWriter out = response.getWriter();
        int i=0;
        try {
            // Apache Commons-Fileupload library classes
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload sfu  = new ServletFileUpload(factory);

            if (! ServletFileUpload.isMultipartContent(request)) {
                System.out.println("sorry. No file uploaded");
                return;
            }
            // parse request
            List items = sfu.parseRequest(request);
            
            FileItem Email_Id1=(FileItem)items.get(0);
            String Email_Id=Email_Id1.getString();
            System.out.println(Email_Id);
           // get uploaded file
            CreateAccountModel addfiles = new CreateAccountModel();
            addfiles.setEmail_Id(Email_Id);
            addfiles.setAadharCardDocument((FileItem) items.get(1));
            addfiles.setPanCardDocument((FileItem) items.get(2));
            addfiles.setElectricityBillDocument((FileItem) items.get(3));
            addfiles.setIncomeCertificateDocument((FileItem) items.get(4));
            addfiles.setPassportphotoDocument((FileItem) items.get(5));
            addfiles.setSignDocument((FileItem) items.get(6));
            List<CreateAccountModel> lst=new ArrayList<CreateAccountModel>();
            lst.add(addfiles);            
            
            CreateAccountDao addfilesdao=new CreateAccountDao();
            i=addfilesdao.Customer_Document_details(lst);
            if(i>0){
            	out.print(" Successfully.");
            	out.println("Photo Added Successfully. <p> <a href='ListPhotoController'>List Photos </a>");
            	
            }
        }
        catch(Exception ex) {
            out.println( "Error --> " + ex.getMessage());
        }
 	}


}
