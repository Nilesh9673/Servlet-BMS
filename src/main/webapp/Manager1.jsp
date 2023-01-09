<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Manager Homepage</h1>
	<br>
	<form action="managerlogout">
		<button type="button">
			<a href="./UpdateManagerName.jsp">Update name</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./UpdateManagerEmail.jsp">Update email</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./UpdateManagerPassword.jsp">update password</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./GetManagerByid.jsp">Get Your All detail</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./ApproveOneCustomer.jsp">Approved one Customer</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./DeleteCustomer.jsp">Delete customers </a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./GetAllCustomer.jsp">All customers detail</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./GetAllBankAccount.jsp">All bankAccount</a>
		</button>
		<br> <br>
		<button type="submit">Logout</button>
	</form>
</body>
</html>