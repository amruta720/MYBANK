<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="Signup.css" rel="stylesheet" type="text/css"/>
<style>
body{
background-color:powderblue;

}
</style>
</head>
<body>
<div class="Signup">
	<form action="AddPhotoController" method="post" enctype="multipart/form-data" >


	<center><h2 style="color: black;"align="center">UPLOAD DOCUMENTS</h2></center>
		<br>
		<table align:"center">
		<tr>
		<td><b>EMAIL ID</b></td>
		<td><input type="email" placeholder="Enter Email_Id" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required="Email_Id is required" name="Email_Id"></td>
		</tr>
		<tr>
		<td><b>AADHAR CARD</b></td>
		<td><input type = "file" name = "AadharCardDocument" size = "50" /></td>
		</tr>
		<tr>
		<td><b>PAN CARD</b></td>
		<td><input type = "file" name = "PanCardDocument" size = "50" />
		</td></tr>
		<tr>
		<td><b>ELECTRICITY BILL</b></td>
		<td><input type = "file" name = "ElectricityBillDocument" size = "50" ></td>
		</tr>
		<tr>
		<td><b>INCOME CERTIFICATE</b></td>
		<td><input type = "file" name = "IncomeCertificateDocument" size = "50" />
		</td></tr>
		<tr>
		<td><b>PASSPORT SIZE PHOTO</b></td>
		<td><input type = "file" name = "PassportPhoto" size = "50" />
		</td></tr>
		<tr>
		<td><b>SIGNATURE</b></td>
		<td><input type = "file" name = "Signature" size = "50" />
		</td></tr>
		<tr>
		<td><input type="submit" value="Submit" ></td>
		</tr>
	
	</form>
	</div>
	
	</table>
</body>
