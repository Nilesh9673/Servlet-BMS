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

	<form action="savecustomer" method="post">
		<div class="form-group">
			<label for="formGroupExampleInput">Enter your name</label> <input
				type="text" class="form-control" name="name" placeholder="Name">
		</div>
		<br>
		<div class="row">
			<legend class="col-form-label col-sm-2 pt-0">Gender</legend>
			<div class="col-sm-10">
				<div class="form-check">
					<input type="radio" name="gender" value="Male" checked> <label>
						Male </label>
				</div>
				<div class="form-check">
					<input type="radio" name="gender" value="Female" checked> <label>
						Female </label>
				</div>
			</div>
		</div>
		<br>
		<div class="form-group">
			<label for="formGroupExampleInput">DOB</label> <input type="date"
				class="form-control" name="dob" placeholder="Date of Birth">
		</div>
		<br>
		<div class="form-group">
			<label for="formGroupExampleInput">Enter your AadharCardNo</label> <input
				type="number" class="form-control" name="adharno"
				placeholder="AadharCardNo">
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