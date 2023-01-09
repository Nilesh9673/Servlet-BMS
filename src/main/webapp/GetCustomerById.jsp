<%@page import="com.jsp.bms.Dto.CustomerDto"%>
<%@page import="com.jsp.bms.Service.CustomerServices"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	CustomerServices customerServices = new CustomerServices();
	HttpSession httpSession = request.getSession();
	int id = (int) httpSession.getAttribute("id");

	CustomerDto customer = customerServices.getCustomerById(id);
	%>
	Id:-
	<b><%=customer.getId()%></b>
	<br> Name:-
	<b><%=customer.getName()%></b>
	<br> Gender:-
	<b><%=customer.getGender()%></b>
	<br>Dob:-<%=customer.getDob()%></b>
	<br>Aadhar no:-
	<b><%=customer.getAdharno()%></b>
	<br>
	<br>
	<br>
	<button type="button">
		<a href="./Customer1.jsp">Back</a>
	</button>
</body>
</html>