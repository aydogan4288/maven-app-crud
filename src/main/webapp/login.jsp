<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<h2>Login</h2>
	<form method="post" action="processLogin">
		<div class="form-group">
			<label for="exampleInputEmail1">First Name</label> <input
				type="text" name="firstName" class="form-control" placeholder="Enter First Name">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Last Name</label> <input
				type="text" class="form-control" name="lastName"
				placeholder="Last Name">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</body>
</html>