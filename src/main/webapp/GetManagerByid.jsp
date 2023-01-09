<%@page import="com.jsp.bms.Dto.ManagerDto"%>
<%@page import="com.jsp.bms.Service.ManagerService"%>
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
	<!-- <form action="getmanagerbyid" method="get">
enter your password:-<input type="password" name="password"><br><br><input
			type="submit">
	</form> -->
	<%
	ManagerService managerService = new ManagerService();
	HttpSession httpSession = request.getSession();
	int id = (int) httpSession.getAttribute("id");

	ManagerDto manager = managerService.getManagerById(id);
	%>
	Id:-
	<b><%=manager.getId()%></b>
	<br> Name:-
	<b><%=manager.getName()%></b>
	<br> Email:-
	<b><%=manager.getEmail()%></b>
	<br>
	<br>
	<br>
	<button type="button">
		<a href="./Manager1.jsp">Back</a>
	</button>
</body>
</html>