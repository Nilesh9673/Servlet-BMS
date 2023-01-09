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
	<form action="approveonemanager" method="post">
		<div class="form-group">
			<label for="formGroupExampleInput2">Enter Customer Id</label> <input
				type="number" class="form-control" name="mid" placeholder="CId">
		</div>
		<br>
		<div class="form-group">
			<label for="formGroupExampleInput2">Enter Password</label> <input
				type="password" class="form-control" name="password"
				placeholder="password">
		</div>
		<br>
		<div class="form-group">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
		<!-- Manager ID:<input type="number" name="mid"><br> <br>
		password:-<input type="text" name="password"><br> <br>
		<input type="submit">
	 -->
	</form>
	<button type="button">
		<a href="./Admin1.jsp">Back</a>
	</button>
</body>
</html>