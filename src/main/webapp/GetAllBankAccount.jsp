<%@page import="com.jsp.bms.Dto.BankAccountDto"%>
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
<h1>All  Account Detail</h1>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Customer Name</th>
				<th scope="col">Bank Name</th>
				<th scope="col">AccountNo</th>
				<th scope="col">IFSC Code</th>
				<th scope="col">Balance</th>
			</tr>
		</thead>
		<%ManagerService managerService = new ManagerService();
		List<BankAccountDto> bankAcc=managerService.allBankAccount();
		for(BankAccountDto b: bankAcc){
		%>
		<tbody>
			<tr>
				<th scope="row"><%=b.getId()%></th>
				<td><%=b.getCname()%></td>
				<td><%=b.getBname()%></td>
				<td><%=b.getAccno()%></td>
				<td><%=b.getIfsc()%></td>
				<td><%=b.getBname()%></td>
			</tr>
		</tbody>
		<%
		}
		%>
	</table>
</body>
</html>