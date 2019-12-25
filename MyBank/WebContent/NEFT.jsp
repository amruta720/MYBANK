<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page errorPage="errorpage.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="Signup.css" rel="stylesheet" type="text/css"/>
<style>
body{
background:powderblue;
	}
	
</style>

</head>

<body>
<form action="NEFTController" method="post">
<table align="centre" >
<tr>
<td><h2> Guidlines:</h2></td></tr>
<tr>
<td><b>Remitter's Account No:-</b>
<input type="text" name="AccNo"></td></tr>
<tr>
<td><b>Beneficiary Name:-</b>
<input type="text" name="BenefName"></td></tr>

<tr>
<td><b>Beneficiary Account No:-</b>
<input type="text" name="BenefAccNo"></td></tr>

<tr>
<td><b>IFSC code:-</b>
<input type="text" name="IFSCcode"></td></tr>

<tr>
<td><b>Amount of transaction</b>
<input type="text" name="Amount"></td></tr>
<tr>
<td><b>Date Of Transaction</b>
<input type="text" name="date"></td></tr>

<tr>
<td><a href="TransactionSuccessful.jsp"><input type="submit" value="Transfer" name="Transfer"></a>
</td>
<tr>
<td><a href="errorpage.jsp"><input type="submit" value="Reject" name="Reject" ></a></td>
</tr>
</table>
</form>
</body>
</html>