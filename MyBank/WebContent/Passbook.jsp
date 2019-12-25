<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
p.a{
word-spacing:normal;
}

body{
background-color:powderblue;
}

</style>
</head>
<body>
<form action="Home11.jsp">
	<h2 align="center">PassBook-Application Form </h2>

Service type:-<p class="a"><input type="radio" name="Service type" value="New Pass Book">New Pass Book<br>
		      <input type="radio" name="Service type" value="Dublicate Pass Book">Dublicate Pass Book<br>
		      <input type="radio" name="Service type" value="Replacement of Pass Book">Replacement of Pass Book<br></p>
		
				<h3>Land Details</h3>
	             State:- 
				<input type="text" name="LocalAddress" >
				District:-
				<input type="text" name="LocalAddress">
				Village:-
				<input type="text" name="LocalAddress">
				
				<h3>Applicant Details</h3>
				Applicant Name:-
				<input type="text" name="LocalAddress" ><br>
				GENDER:-
		<input type="radio" name="Gender" value="Male">Male
		<input type="radio" name="Gender" value="Female">Female
		<input type="radio" name="Gender" value="Other">Other
				Date_Of_Birth:-
				<input type="text" name="LocalAddress" ><br>
				<h3>Permanent Address</h3>
				State:-
				<input type="text" name="LocalAddress">
				LandMark:-
				<input type="text" name="LocalAddress">
				District:-
				<input type="text" name="LocalAddress">
				Village:-
				<input type="text" name="LocalAddress">
				pincode:-
				<input type="text" name="LocalAddress"><br>
				<h3>Postal Address</h3>
				State:-
				<input type="text" name="LocalAddress">
				LandMark:-
				<input type="text" name="LocalAddress">
				District:-
				<input type="text" name="LocalAddress">
				Village:-
				<input type="text" name="LocalAddress">
				pincode:-
				<input type="text" name="LocalAddress">
				Mobile No.:
				<input type="text" name="LocalAddress">
				Email-Id:-
				<input type="text" name="LocalAddress">
				Ration Card No.:-
				<input type="text" name="LocalAddress">
				Remark:-
				<input type="text" name="LocalAddress">
				Delivery Type:-
				<input type="text" name="LocalAddress">
				
				<input type="submit" name="submit" value="submit">
</form>				
</body>
</html>