<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<style>
body{
background:powderblue;
background-size:50px 50px;
	padding:100px;
	width:500px;
	height:10px;
	margin-top:50px;
	margin: 0 auto;
	margin-left:100px;
</style>
</head>
<body>
<div class="Signup">

<h1 style="color: black;"align="center"> Account Detail </h1>
	<%
	try{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","123456789");	
		Statement stmt=conn.createStatement();
		String query="select * from Beneficiary where name='amruta'";
	
		
		ResultSet rs=stmt.executeQuery(query);
		%><table border=1 align=center style="text-align:center">
		<thead>
		    <tr>
		       <th>Account Title</th>
		       <th> Account Number</th>
		       <th>IFSC Code</th>
		       <th>Balance</th>
		    </tr>
		</thead>
		<tbody>
		<%while(rs.next()){
			%>
			 <tr>
			 <td><%=rs.getString("Name")%></td>
		    <td><%=rs.getString("ACCNO")%></td>
		    <td><%=rs.getString("IFSC_Code")%></td>
		    <td><%=rs.getLong("Balance")%></td>
		    </tr>
		        <%
		        } %>
		        </tbody>
		     </table><br>
		      <%}
		    catch(Exception e){
		        out.print(e.getMessage());%><br><%
		    }
		    
		 %>
		 
	
	
	
	
	
			
		</form>
</body>
</html>