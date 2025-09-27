<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/5/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	margin: 0;
}

.login-container {
	background-color: #fff;
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 300px;
	text-align: center;
}

.login-container h2 {
	margin-bottom: 20px;
	color: #333;
}

.login-container label {
	display: block;
	text-align: left;
	margin-bottom: 5px;
	color: #555;
}

.login-container input[type="text"], .login-container input[type="password"]
	{
	width: calc(100% - 20px);
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ddd;
	border-radius: 4px;
}

.login-container button {
	background-color: #007bff;
	color: white;
	padding: 10px 15px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
	width: 100%;
}

.login-container button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="login-container">
		<h2>Registration</h2>
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="registration" /> <label
				for="username">Username:</label> <input type="text" name="login"
				required> <label for="password">Password:</label> <input
				type="password" name="password" required>

			<button type="submit">Submit</button>
		</form>
	</div>


</body>
</html>