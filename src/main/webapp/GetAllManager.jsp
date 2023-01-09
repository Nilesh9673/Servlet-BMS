<%@page import="java.util.List"%>
<%@page import="com.jsp.bms.Dto.ManagerDto"%>
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
	<h1>Details of Manager</h1>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Status</th>
				<th scope="col">AdminName</th>
			</tr>
		</thead>
		<%
		AdminService adminService = new AdminService();
		List<ManagerDto> manager = adminService.getAllManager();
		for (ManagerDto m : manager) {
		%>
		<tbody>
			<tr>
				<th scope="row"><%=m.getId()%></th>
				<td><%=m.getName()%></td>
				<td><%=m.getEmail()%></td>
				<td><%=m.getStatus()%></td>
				<td><%=m.getAdminDto().getName()%></td>
			</tr>
		</tbody>
		<%
		}
		%>
	</table>
	<br>
	<br>
	<button type="button">
		<a href="./Manager1.jsp">Back</a>
	</button>
</body>
</html>