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
	<
	<h1>Enter your Detail</h1>
	<form action="saveadmin" method="post">
		<div class="form-group">
			<label for="formGroupExampleInput">Enter your name</label> <input
				type="text" class="form-control" name="name" placeholder="Name">
		</div>
		<br>

		<div class="form-group">
			<label for="formGroupExampleInput2">Enter your Email</label> <input
				type="email" class="form-control" name="email" placeholder="Email">
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
</body>
</html>