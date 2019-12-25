package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayPhotoController
 */
@WebServlet("/DisplayPhotoController")
public class DisplayPhotoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        			            response.setContentType("image/jpeg");

			        try {
			            Class.forName("oracle.jdbc.driver.OracleDriver");
			            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","123456789");
			            System.out.println("Test2");
			            PreparedStatement ps = con.prepareStatement("select AADHAR_CARD from customer_document_details where Email_ID = ?");
			            System.out.println("test3");
			            String Email_Id = request.getParameter("Email_Id");
			            ps.setString(1,Email_Id);
			            ResultSet rs = ps.executeQuery();
			            rs.next();
			            System.out.println("test4");

			            Blob  b = rs.getBlob("AADHAR_CARD");
			            System.out.println("test5");
			            System.out.println("test6");

			            response.setContentLength( (int) b.length());
			            System.out.println("test7");

			            InputStream is = b.getBinaryStream();
			            System.out.println("test8");

			            OutputStream os = response.getOutputStream();
			            System.out.println("test9");

			            byte buf[] = new byte[(int) b.length()];

			            System.out.println(buf);

			            is.read(buf);
			            os.write(buf);
			            os.close();
			        }
			        catch(Exception ex) {
			             System.out.println(ex.getMessage());
			        }
			    } 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPhotoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        processRequest(request, response);
	}

}
