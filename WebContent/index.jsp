<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> 
<%  String contextPath = request.getContextPath();
    System.out.println("INDEX contextPath - " + contextPath);
	response.sendRedirect(contextPath + "/Controller?command=gotoindexpage"); %>
</h1>
</body>
</html>