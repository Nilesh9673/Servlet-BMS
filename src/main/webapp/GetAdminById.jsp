<%@page import="com.jsp.bms.Controller.UpdateAdminName"%>
<%@page import="com.jsp.bms.Dto.AdminDto"%>
<%@page import="com.jsp.bms.Service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<!-- <form action="getadminbyid" method="get">
		password:-<input type="password" name="password"><br> <br>
		<input type="submit">
	</form> -->
	<%
	AdminService adminService = new AdminService();
	HttpSession httpSession = request.getSession();
	int id = (int) httpSession.getAttribute("id");
	AdminDto admin = adminService.getAdminById(id);
	%>
	Id:-
	<b><%=admin.getId()%></b>
	<br> Name:-
	<b><%=admin.getName()%></b>
	<br> Email:-
	<b><%=admin.getEmail()%></b>
	<br>

	<br>
	<br>
	<button type="button">
		<a href="./Admin1.jsp">Back</a>
	</button>
</body>
</body>
</html>