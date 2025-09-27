<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Riverstone Bank</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

	<!-- Header -->
	<%@ include file="/WEB-INF/jsp/includes/header.jsp" %>

	<!-- Navigation bar with dropdowns -->
	<%@ include file="/WEB-INF/jsp/includes/nav_bar.jsp" %>
	
	
	<!-- Welcome Section -->
	<div class="welcome">
		<h2>Welcome to Riverstone Bank</h2>
		<p>Your trusted financial partner for personal and business
			banking.</p>
	</div>

	
</body>
</html>
