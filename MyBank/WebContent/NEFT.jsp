<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="TranferController" method="post">
<h2>Guidlines:</h2>
Remitter's Account No.<input type="text" name="AccNo">
Beneficiary Name<input type="text" name="BenefName">
Beneficiary Account No.<input type="text" name="BenefAccNo">
IFSC code<input type="text" name="IFSCcode">
Amount of transaction<input type="text" name="Amount"><br>

<input type="submit" value="Transfer" name="Transfer"><br>
<input type="submit" value="Reject" name="Reject"><br>

</form>
</body>
</html>