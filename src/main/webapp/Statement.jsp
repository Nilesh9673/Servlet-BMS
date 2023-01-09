<%@page import="com.jsp.bms.Dto.StatementDto"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.bms.Service.StatementService"%>
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
	<h1>All Account Detail</h1>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Transaction Detail</th>

			</tr>
		</thead>
		<%
		HttpSession httpSession = request.getSession();
		int id = (int) httpSession.getAttribute("id");
		StatementService statementService = new StatementService();
		List<StatementDto> statement = statementService.customersStatement(id);
		int c = 0;
		for (StatementDto b : statement) {
			c++;
		%>
		<tbody>
			<tr>
				<th scope="row"><%=c%></th>
				<td><%=b.getTransactionDetail()%></td>

			</tr>
		</tbody>
		<%
		}
		%>
	</table>
	<br>
	<br>
	<button type="button">
		<a href="./BankOperation.jsp">Back</a>
	</button>
</body>
</html>