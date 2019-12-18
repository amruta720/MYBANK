

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
 * Servlet implementation class ListPhotoController
 */
@WebServlet("/ListPhotoController")
public class ListPhotoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        response.setContentType("text/html;charset=UTF-8");
			        PrintWriter out = response.getWriter();      
			        try {
			            Class.forName("oracle.jdbc.driver.OracleDriver");
			            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","123456789");
			            PreparedStatement ps = con.prepareStatement("select * from customer_document_details");
			            ResultSet rs = ps.executeQuery();
			            out.println("<h1>Documents</h1>");
			            while ( rs.next()) {
			                  out.println("<h4>" + rs.getString("Email_Id") + "</h4>");
				                 out.print("<h2>test1</h2>");
				                 	System.out.println("test1");
				                    Blob  b = rs.getBlob("Aadhar_card");
				                    response.setContentType("image/jpeg");
				                    response.setContentLength( (int) b.length());
				                    InputStream is = b.getBinaryStream();
				                    OutputStream os = response.getOutputStream();
				                    byte buf[] = new byte[(int) b.length()];
				                    is.read(buf);
				                    os.write(buf);

			                  out.println("<img width='600' height='600' src=DisplayPhotoController?Email_Id=" +  rs.getString("Email_Id") + "></img> <p/>");
			                  
			            }

			            con.close();
			        }
			        catch(Exception ex) {

			        }
			        finally { 
			            out.close();
			        }
			    } 

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPhotoController() {
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
