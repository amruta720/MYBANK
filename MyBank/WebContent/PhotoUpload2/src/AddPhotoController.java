
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

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
            
            FileItem Email_id = (FileItem) items.get(0);
            String   Email_Id =  Email_id.getString();

            // get uploaded file
            FileItem file1 = (FileItem) items.get(1);
            FileItem file2 = (FileItem) items.get(2);
            FileItem file3 = (FileItem) items.get(3);
            FileItem file4 = (FileItem) items.get(4);
            FileItem file5 = (FileItem) items.get(5);
            FileItem file6 = (FileItem) items.get(6);
                        
            // Connect to Oracle
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","123456789");
            con.setAutoCommit(false);

            PreparedStatement ps = con.prepareStatement("insert into customer_document_details values(?,?,?,?,?,?,?)");
            ps.setString(1, Email_Id);
            // size must be converted to int otherwise it results in error
            ps.setBinaryStream(2, file1.getInputStream(), (int) file1.getSize());
            ps.setBinaryStream(3, file2.getInputStream(), (int) file2.getSize());
            ps.setBinaryStream(4, file3.getInputStream(), (int) file3.getSize());
            ps.setBinaryStream(5, file4.getInputStream(), (int) file4.getSize());
            ps.setBinaryStream(6, file5.getInputStream(), (int) file5.getSize());
            ps.setBinaryStream(7, file6.getInputStream(), (int) file6.getSize());

            ps.executeUpdate();
            con.commit();
            con.close();
            out.print("Photo Added Successfully.");
            out.println("Photo Added Successfully. <p> <a href='ListPhotoController'>List Photos </a>");
        }
        catch(Exception ex) {
            out.println( "Error --> " + ex.getMessage());
        }
 
	
	}


}
