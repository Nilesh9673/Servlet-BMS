<%@page import="java.util.List"%>
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
	<h1>Details of Admin</h1>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>

			</tr>
		</thead>
		<%
		AdminService adminService = new AdminService();
		List<AdminDto> admin = adminService.getAllAdmin();
		for (AdminDto a : admin) {
		%>
		<tbody>
			<tr>
				<th scope="row"><%=a.getId()%></th>
				<td><%=a.getName()%></td>
				<td><%=a.getEmail()%></td>
			</tr>
		</tbody>
		<%
		}
		%>
	</table>
	<br>
	<br>
	<button type="button">
		<a href="./Admin1.jsp">Back</a>
	</button>
	<br>

</body>
</html>