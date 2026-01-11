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
function loadCities() {
    const provinceId = document.getElementById("province").value;
    const citySelect = document.getElementById("city");

    // Clear previous cities
    citySelect.innerHTML = "<option value=''>Loading...</option>";

    // AJAX call to get cities by provinceId
    fetch(`<%=request.getContextPath()%>/Controller?command=citiesByProvince&provinceId=\${provinceId}`)
        .then(response => response.json())
        .then(data => {
            citySelect.innerHTML = "<option value=''>Select City</option>";
            data.forEach(city => {
                const option = document.createElement("option");
                option.value = city.id;
                option.text = city.nameOfCity;
                citySelect.appendChild(option);
            });
        })
        .catch(error => {
            console.error('Error loading cities:', error);
            citySelect.innerHTML = "<option value=''>Error loading cities</option>";
        });
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
			<form
				action="<%=request.getContextPath()%>/Controller?command=saveNewUser"
				method="post">
				<label for="fullname">Full Name</label> <input type="text"
					id="fullname" name="fullname" required> <label for="email">Email</label>
				<input type="email" id="email" name="email" required> <label
					for="login">Login</label> <input type="text" id="login"
					name="login" required> <label for="password">Password</label>
				<input type="password" id="password" name="password" required>

				<hr>
				<h3>Address Information</h3>

				<label for="streetNumber">Street Number</label> <input type="text"
					id="streetNumber" name="streetNumber" required> <label
					for="streetName">Street Name</label> <input type="text"
					id="streetName" name="streetName" required> <label
					for="apartmentNumber">Apartment Number</label> <input type="text"
					id="apartmentNumber" name="apartmentNumber"> <label
					for="postalCode">Postal Code</label> <input type="text"
					id="postalCode" name="postalCode" required>

				<form action="<%=request.getContextPath()%>/Controller" method="get">
					<input type="hidden" name="command" value="citiesByProvince">

					<label for="province">Province</label> <select id="province"
						name="provinceId" required>
						<option value="">Select Province</option>
						<%
							java.util.List<ca.http.myservlet.bean.Province> provinces = (java.util.List<ca.http.myservlet.bean.Province>) request
								.getAttribute("provinces");
						if (provinces != null) {
							for (ca.http.myservlet.bean.Province p : provinces) {
						%>
						<option value="<%=p.getId()%>"><%=p.getNameOfProvince()%></option>
						<%
							}
						}
						%>
					</select>

					<button type="submit">Send Province</button>
				</form>






				<label for="city">City</label> <select id="city" name="cityId"required ">
					<option value="">Select City</option>
					<%
						java.util.List<ca.http.myservlet.bean.City> cities = (java.util.List<ca.http.myservlet.bean.City>) request
							.getAttribute("cities");
					if (provinces != null || cities != null) {
						for (ca.http.myservlet.bean.City p : cities) {
					%>
					<option value="<%=p.getId()%>"><%=p.getNameOfCity()%></option>
					<%
						}
					}
					%>
				</select> <label for="city">City</label> <select id="city" name="cityId" required>
					<option value="">Select City</option>
				</select>

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
