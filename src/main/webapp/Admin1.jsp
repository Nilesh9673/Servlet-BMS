<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Admin</h1>
	<br>
	<form action="adminlogout" method="get">
		<button type="button">
			<a href="./UpdateAdminName.jsp">Update Name</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./UpdateAdminEmail.jsp">Update Email</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./UpdateAdminPassword.jsp">Update Password</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./DeleteAdmin.jsp">delete Admin</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./GetAdminById.jsp">Get your all detail</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./GetAllAdmin.jsp">All admin</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./ApprovedOneManager.jsp">Approved Manager</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./GetAllManager.jsp"> All manager </a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./DeleteManager.jsp"> Delete manager </a>
		</button>
		<br> <br> <input type="submit" value="Logout">

	</form>
</body>
</html>