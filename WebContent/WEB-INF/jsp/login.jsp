<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login | Riverstone Bank</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css?v=<%=System.currentTimeMillis()%>">
</head>
<body>

	<!-- Include header -->
	<jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

	<!-- Navigation bar with dropdowns -->
	<%@ include file="/WEB-INF/jsp/includes/nav_bar.jsp"%>

	<%
	String message = request.getParameter("message");
	String details = request.getParameter("details");
	if (message != null && !message.isEmpty()) {
	%>
	<div class="alert error"><%=java.net.URLDecoder.decode(details, "UTF-8")%></div>
	<%
		}
	%>

	<div class="form-container">
		<div class="form-box">
			<h2>Sign In to Riverstone Bank</h2>
			<form action="${pageContext.request.contextPath}/Controller"
				method="post">
				<input type="hidden" name="command" value="loginUser"> <label
					for="login">Login or Email</label> <input type="text" id="login"
					name="login" required> <label for="password">Password</label>
				<input type="password" id="password" name="password" required>

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