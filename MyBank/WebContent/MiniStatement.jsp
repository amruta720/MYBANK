<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>Mini Statement</h4>
<%
try{
	
	Class.forName("oracle.jdbc.OracleDriver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","123456789");	
String query="select * from transaction_details";
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
%><table border=1 align=center style="text-align:center">
<thead>
    <tr>
       <th>Remitter Account Number</th>
       <th>Benificiary Name</th>
       <th>Beneficiary Account Number</th>
       <th>Amount</th>
    </tr>
</thead>
<tbody>
<%while(rs.next()){
	%>
	 <tr>
	 <td><%=rs.getString("ACCNO")%></td>
    <td><%=rs.getString("BENF_NAME")%></td>
    <td><%=rs.getString("BENF_ACCNO")%></td>
    <td><%=rs.getLong("Amount")%></td>
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



</body>
</html>