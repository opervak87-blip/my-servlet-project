<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error - Riverstone Bank</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        /* Error page container */
        .error-container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 70vh;
            text-align: center;
            padding: 40px;
            background-color: #f8f8f8;
        }

        .error-container h2 {
            color: #e31837; /* brand red */
            font-size: 32px;
            margin-bottom: 20px;
        }

        .error-container p {
            font-size: 18px;
            color: #555;
            margin-bottom: 15px;
        }

        .error-container a {
            display: inline-block;
            text-decoration: none;
            background-color: #e31837;
            color: #fff;
            padding: 10px 25px;
            border-radius: 20px;
            font-weight: bold;
            transition: background 0.2s ease-in-out;
        }

        .error-container a:hover {
            background-color: #b21025;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h2>Oops! Something went wrong</h2>
        <p>${errorMessage}</p>
        <p>Error Code: ${errorID}</p>
        <p><a href="${pageContext.request.contextPath}/Controller?command=gotoIndexPage">Go Home</a></p>
    </div>
</body>
</html>
