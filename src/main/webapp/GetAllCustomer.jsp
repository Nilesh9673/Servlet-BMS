<%@page import="com.jsp.bms.Dto.CustomerDto"%>
<%@page import="java.util.List"%>
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
	<h1>Details of Customers</h1>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Name</th>
				<th scope="col">Gender</th>
				<th scope="col">DoB</th>
				<th scope="col">Adhar_No</th>
				<th scope="col">Status</th>
			</tr>
		</thead>
		<%
		ManagerService managerService = new ManagerService();
		List<CustomerDto> customer = managerService.getAllCustomer();
		for (CustomerDto c : customer) {
		%>
		<tbody>
			<tr>
				<th scope="row"><%=c.getId()%></th>
				<td><%=c.getName()%></td>
				<td><%=c.getGender()%></td>
				<td><%=c.getDob()%></td>
				<td><%=c.getAdharno()%></td>
				<td><%=c.getStatus()%></td>
			</tr>
		</tbody>
		<%
		}
		%>
	</table>
	<button type="button">
		<a href="./Manager1.jsp">Back</a>
	</button>
	<br>

</body>
</html>