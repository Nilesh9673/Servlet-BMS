<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Transfer Money</h1>
	<form action="tranfermaoney" method="post">
		<br>
		<div class="form-group">
			<label for="formGroupExampleInput2">Enter BankId</label> <input
				type="number" class="form-control" name="bid" placeholder="BankId">
		</div>
		<br>
		<div class="form-group">
			<label for="formGroupExampleInput2">Enter Amount</label> <input
				type="number" class="form-control" name="depositemoney"
				placeholder="money">
		</div>
		<br>
		<div class="form-group">
			<label for="formGroupExampleInput2">Enter your Password</label> <input
				type="password" class="form-control" name="password"
				placeholder="password">
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
		<!-- Enter bankId:-<input type="number" name="bid"><br> <br>
		Enter Amount:-<input type="number" name="depositemoney"><br>
		Password:-<input type="password" name="password"><br> <br>
		<br> <input type="submit">
	 -->
	</form>
</body>
</html>