<!-- Header -->
	<header>
		<div class="logo">Riverstone Bank</div>

		<nav>
			<a href="index.jsp">Personal</a> <a href="business.jsp">Business</a>
			<a href="services.jsp">Services</a> <a href="about.jsp">About Us</a>
		</nav>

		<div class="header-right">
			<span title="Call Us">&#9742;</span> <span title="Find Location">&#9679;</span>
			<!-- ● placeholder for pin -->
			<span title="Special Offers">&#9733;</span>
			
			<a href="${pageContext.request.contextPath}/Controller?command=goToLoginPage" class="login-btn">Sign In</a>
		</div>
	</header>