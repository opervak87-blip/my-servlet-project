<!-- Header -->
<header>
	<div class="logo">Riverstone Bank</div>

	<nav>
		<a href="index.jsp">Personal</a> <a href="business.jsp">Business</a> <a
			href="services.jsp">Services</a> <a href="about.jsp">About Us</a>
	</nav>

	<div class="header-right">
		<div class="header-icons">
			<span title="Call Us">&#9742;</span> <span title="Find Location">&#9679;</span>
			<!-- ● placeholder for pin -->
			<span title="Special Offers">&#9733;</span>
		</div>

		<%
			ca.http.myservlet.bean.User user = (ca.http.myservlet.bean.User) session.getAttribute("user");
		if (user != null) {
		%>
		<div class="user-info">
			<span class="welcome-text">Welcome, <%=user.getLogin()%>!
			</span> <a
				href="${pageContext.request.contextPath}/Controller?command=logoutUser"
				class="logout-btn">Logout</a>
		</div>
		<%
			} else {
		%>
		<a
			href="${pageContext.request.contextPath}/Controller?command=goToLoginPage"
			class="login-btn">Sign In</a>
		<%
			}
		%>

	</div>
</header>