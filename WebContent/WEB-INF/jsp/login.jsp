<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login | Riverstone Bank</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

	<!-- Include header -->
	<jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

	<!-- Navigation bar with dropdowns -->
	<%@ include file="/WEB-INF/jsp/includes/nav_bar.jsp"%>

	<%
		String message = request.getParameter("message");
	if ("success".equals(message)) {
	%>
	<div class="alert success">Registration successful! Please log
		in.</div>
	<%
		}
	%>

	<div class="form-container">
		<div class="form-box">
			<h2>Sign In to Riverstone Bank</h2>
			<form action="<%=request.getContextPath()%>/login" method="post">
				<label for="username">Username or Email</label> <input type="text"
					id="username" name="username" required> <label
					for="password">Password</label> <input type="password"
					id="password" name="password" required>

				<button type="submit" class="login-btn">Login</button>
			</form>

			<p class="switch-form">
				Don't have an account? <a
					href="${pageContext.request.contextPath}/Controller?command=goToRegistrationPage">Register
					here</a>
			</p>
		</div>
	</div>

</body>
</html>