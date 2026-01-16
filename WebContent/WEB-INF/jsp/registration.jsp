<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register | Riverstone Bank</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css?v=<%=System.currentTimeMillis()%>">

<script>
    var allCities = [
        <% 
        java.util.List<ca.http.myservlet.bean.City> cities = (java.util.List<ca.http.myservlet.bean.City>) request.getAttribute("cities");
            for(int i=0; i<cities.size(); i++) {
            	ca.http.myservlet.bean.City c = cities.get(i);
            	
        %>
        { id: '<%=c.getId()%>', nameOfCity: '<%=c.getNameOfCity().replace("'", "\\'")%>', provinceId: '<%=c.getProvince().getId()%>' }<%= (i < cities.size()-1) ? "," : "" %>
        <% } %>
    ];

    function updateCities(provinceId) {
        var citySelect = document.getElementById("city");
        citySelect.innerHTML = '<option value="">Select City</option>';
        for(var i=0; i<allCities.length; i++) {
            if(allCities[i].provinceId == provinceId) {
                var option = document.createElement("option");
                option.value = allCities[i].id;
                option.text = allCities[i].nameOfCity;
                citySelect.appendChild(option);
            }
        }
    }
</script>
</head>
<body>

	<!-- Include header -->
	<jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

	<!-- Navigation bar -->
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
			<form action="<%=request.getContextPath()%>/Controller?command=saveNewUser" method="post">
				
				<label for="firstName">First Name</label> 
				<input type="text" id="firstName" name="firstName" required> 
				
				<label for="middleName">Middle Name</label> 
				<input type="text" id="middleName" name="middleName"> 
				
				<label for="lastName">Last Name</label> 
				<input type="text" id="lastName" name="lastName" required> 
				
				<label for="email">Email</label>
				<input type="email" id="email" name="email" required> 
				
				<label for="login">Login</label> 
				<input type="text" id="login" name="login" required> 
				
				<label for="password">Password</label>
				<input type="password" id="password" name="password" required>

				<hr>
				<h3>Address Information</h3>

				<label for="streetNumber">Street Number</label> 
				<input type="text" id="streetNumber" name="streetNumber" required> 
				
				<label for="streetName">Street Name</label> 
				<input type="text" id="streetName" name="streetName" required> 
				
				<label for="apartmentNumber">Apartment Number</label> 
				<input type="text" id="apartmentNumber" name="apartmentNumber"> 
				
				<label for="nameOfProvince">Province</label> 
				<select id="province" name="provinceId" onchange="updateCities(this.value)" required>
   				 <option value="">Select Province</option>

    			<%
      				  java.util.List<ca.http.myservlet.bean.Province> provinces =
         			  (java.util.List<ca.http.myservlet.bean.Province>) request.getAttribute("provinces");

     					   if (provinces != null) {
           				   for (ca.http.myservlet.bean.Province p : provinces) {
   				 %>
       			 <option value="<%=p.getId()%>"> <%=p.getNameOfProvince()%> </option>
   				 <%
          			  }
        		}
   				 %>
				</select>
				
				<label for="nameOfCity">City</label> 
				<select id="city" name="cityId" required>
                <option value="">Select City</option>
            	</select>

				<label for="postalCode">Postal Code</label> 
				<input type="text" id="postalCode" name="postalCode" required>
				
				<label for="phone">phone</label> 
				<input type="text" id="phone" name="phone" required>

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
