<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register | Riverstone Bank</title>
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/css/style.css?v=<%=System.currentTimeMillis()%>">
</head>
<body>

	<!-- Include header -->
	<jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

	<!-- Navigation bar with dropdowns -->
	<%@ include file="/WEB-INF/jsp/includes/nav_bar.jsp"%>

	<%
	String message = request.getParameter("message");
	String errorDetail = request.getParameter("details");
	if ("error".equals(message)) {
	%>
	<div class="alert error">
		Registration failed.
		<%
		if (errorDetail != null) {
	%>
		<br> <strong><%=errorDetail%></strong>
		<%
			} else {
		%>
		Please try again.
		<%
			}
		%>
	</div>
	<%
		}
	%>

	<div class="form-container">
		<div class="form-box">
			<h2>Create Your Account</h2>
			<form
				action="<%=request.getContextPath()%>/Controller?command=saveNewUser"
				method="post">
				<label for="fullname">Full Name</label> 
				<input type="text" id="fullname" name="fullname" required> 
				<label for="email">Email</label>
				<input type="email" id="email" name="email" required> 
				<label for="login">Login</label> 
				<input type="text" id="login" name="login" required> 
				<label for="password">Password</label>
				<input type="password" id="password" name="password" required>

				<button type="submit" class="login-btn">Register</button>
			</form>

			<p class="switch-form">
				Already have an account? <a
					href="${pageContext.request.contextPath}/Controller?command=goToLoginPage">Login
					here</a>
			</p>
		</div>
	</div>

</body>
</html>