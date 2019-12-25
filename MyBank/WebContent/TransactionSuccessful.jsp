<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.model.NEFTModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>TRANSACTION PROCESSING</h4>
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
       <th>Benificiary Account Number</th>
       <th>Beneficiary Name</th>
       <th>Amount</th>
        <th>Date_of_transaction</th>
       
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
    <td><%=rs.getDate("Date_of_transaction")%></td>
    
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