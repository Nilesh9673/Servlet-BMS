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

	<h1>Update Password</h1>
	<br>
	<form action="updateadminpassword" method="post">
		<div class="form-group">
			<label for="formGroupExampleInput2">Enter your New Password</label> <input
				type="password" class="form-control" name="pass"
				placeholder=" New password">
		</div>
		<br>
		<div class="form-group">
			<label for="formGroupExampleInput2">Enter your Password</label> <input
				type="password" class="form-control" name="password"
				placeholder="password">
		</div>
		<br>
		<div class="form-group">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
	<button type="button">
		<a href="./Admiin1.jsp">Back</a>
	</button>
</body>
</html>