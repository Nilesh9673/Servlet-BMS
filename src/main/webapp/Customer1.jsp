<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Customer Homepage</h1>
	<br>
	<form action="customerlogout">
		<button type="button">
			<a href="./UpdateCustomerName.jsp">Update Name</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./UpdateCustomerGender.jsp">Update Gender</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./UpdateCustomerDob.jsp">Update Dob</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./UpdateCustomerAdharno.jsp">Update AdharNo</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./UpdateCustomerPassword.jsp">Update Password</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./GetCustomerById.jsp">Get Your Detail</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./BankOperation.jsp">BankAccount</a>
		</button>
		<br>
		<br>
		<button type="submit">Logout</button>
	</form>
</body>
</html>