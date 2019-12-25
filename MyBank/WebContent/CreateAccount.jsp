<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<link rel="stylesheet" href="allcss.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<body>
	<div class="glass">
	   <h1   align="center"><b><i class="fa fa-retweet"></i>JM ROAD BANK</b></h1>
	</div>
	
	<div class="menu-bar">
		<h2 align="center"> Application Form </h2>
	</div>	
	
	<form action="CreateAccountController" method = "post" >
		
		<div class="Signup">
			<table align="center">
				<tr>
					<td><b>NAME</b></td>
					<td>
						<select>
							<option value="Mr">Mr</option>
							<option value="Mrs">Mrs</option>
							<option value="Ms">Ms</option>
						</select>
					</td>
					<td><input type="text" name="FirstName" placeholder="Enter First Name" required="firstname is required"  ></td>
					<td><input type="text" name="MiddleName" placeholder="Enter middle Name" required="middlename is required"></td>
					<td><input type="text" name="LastName"  placeholder="Enter last Name"required="lastname is required"></td>
				</tr>
				<tr>
					<td><label><b>FATHER'S NAME/GUARDIAN'S NAME</b></label> </td>
					<td>
						<select>
							<option value="Mr">Mr</option>
							<option value="Mrs">Mrs</option>
							<option value="Ms">Ms</option>
						</select>
					</td>
					<td><input type="text" name="FatherFirstName" placeholder="First Name" required></td>
					<td><input type="text" name="FatherMiddleName" placeholder="Middle Name" required ></td>
					<td><input type="text" name="FatherLastName" placeholder="Last Name"required></td>
				</tr>
				<tr>
					<td><label><b>	DATE OF BIRTH</b></label></td>
					<td><input type="text" name="Date_Of_Birth" required="DateOfBirth is required"  placeholder="DD-MON-YY"></td>
				</tr>
				<tr>
					<td><label><b>GENDER</b></label></td>
					<td><input type="radio" name="Gender" value="Male" required="Gender is required">Male</td>
					<td><input type="radio" name="Gender" value="Female" required="Gender is required">Female</td>
					<td><input type="radio" name="Gender" value="Other" required="Gender is required">Other</td>
				</tr>
				<tr>
					<td><label><b>	NATIONALITY</b></label></td>
					<td><input type="text" value="Indian" name="Nationality" required="nationality is required"></td>		
				</tr>
				<tr>
					<td><label><b>	AADHAR CARD NUMBER</b></label></td>
					<td><input type="text" name="AadharNo" placeholder="Enter 12 Digit Aadhar Number"  required="AadharNo is required"></td>
				</tr>
				<tr>
					<td><label><b>PAN CARD NUMBER</b></label></td>
					<td><input type="text" name="PanCardNo"  placeholder="Enter 8 Digit Aadhar Number" required="PanCardNo is required"></td>
				</tr>
				<tr>
					<td><label><b>LOCAL ADDRESS</b></label></td>
					<td><input type="text" name="LocalAddress"  placeholder="Enter Local Address"></td>
				</tr>
				<tr>
					<td><label><b>	PERMANENT ADDRESS</b></label></td>
					<td><input type="text" name="PermanentAddress" placeholder="Enter Permanent Address" required="LocalAddress is required"></td>
				</tr>
		
				<tr>
					<td><label><b>	STATE</b></label></td>
					<td>
						<select name="State" required="State is required">
							<option value="Maharashtra">Maharashtra</option>
							<option value="Maharashtra">Gujarat</option>
							<option value="Maharashtra">Rajasthan</option>
							<option value="Maharashtra">Karnataka</option>
						</select>	
					</td>
				</tr>
				<tr>
					<td><label><b>	CITY</b></label></td>
					<td>
						<select  name="City" required="City is required">
							<option value="Pune">Pune</option>
							<option value="Mumbai">Mumbai</option>
							<option value="Ms">Ms</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td><label><b>	PINCODE</b></label></td>
					<td><input placeholder="Enter 6 digit PinCode" type="number" name="Pincode"  pattern="{0-9}{6}" title="Enter valid pincode" required="Pincode is required"></td>
				</tr>
				<tr>
					<td><label><b>MOBILE NUMBER  </b></label></td>
					<td><input placeholder="Enter 10 digit Mobile No" type="number" name="MobileNo" pattern="{0-9}{10}" title="Enter valid mobile no" required="MobileNo is required"></td>
				</tr>
				<tr>
					<td><label><b>EMAIL ID</b></label></td>
					<td><input type="email" placeholder="Enter Email_Id" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required="Email_Id is required" name="Email_Id"></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Next" ></td>
				</tr>
			</table>
		</div>
	</form>
	
</body>
</html>