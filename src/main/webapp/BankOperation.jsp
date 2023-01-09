<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bank Domin</h1>
	<br>
	<form action="checkbalance" method="get">
		<button type="button">
			<a href="./DepositeAmount.jsp">Deposite Money </a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./Statement.jsp">Bank Statement</a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./TransferAmount.jsp">Transfer Money </a>
		</button>
		<br> <br>
		<button type="button">
			<a href="./Customer1.jsp">CustomerHomePage</a>
		</button>
		<br> <br>
		<button type="submit">Check Balance</button>

	</form>
</body>
</html>