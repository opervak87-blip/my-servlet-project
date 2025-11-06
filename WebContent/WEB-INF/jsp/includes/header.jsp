<!-- Header -->
<header>
	<div class="logo">Riverstone Bank</div>
	

	<nav>
		<a href="index.jsp">Personal</a> 
		<a href="business.jsp">Business</a> 
		<a href="services.jsp">Services</a> 
		<a href="about.jsp">About Us</a>
	</nav>

	<div class="header-right">
		<div class="header-icons">
			<span title="Call Us">&#9742;</span> 
			<span title="Find Location">&#9679;</span><!-- ● placeholder for pin -->
			<span title="Special Offers">&#9733;</span>
		</div>

		 <%
            ca.http.myservlet.bean.User user =
                (ca.http.myservlet.bean.User) session.getAttribute("user");
            if (user != null) {
        %>
        <!-- User dropdown -->
        <div class="user-dropdown">
            <button class="user-toggle">
                &#128100; <%= user.getLogin() %> &#9662;
            </button>
            <div class="user-menu">
                <a href="${pageContext.request.contextPath}/Controller?command=goToProfile">
                    My Profile
                </a>
                <a href="${pageContext.request.contextPath}/Controller?command=goToAccounts">
                    My Accounts
                </a>
                <a href="${pageContext.request.contextPath}/Controller?command=goToTransfers">
                    Transfers
                </a>
                <a href="${pageContext.request.contextPath}/Controller?command=goToSettings">
                    Settings
                </a>
                <a href="${pageContext.request.contextPath}/Controller?command=logoutUser"
                   class="logout-link">Logout</a>
            </div>
        </div>
        <% } else { %>
        <!-- Sign-in button for guests -->
        <a href="${pageContext.request.contextPath}/Controller?command=goToLoginPage"
           class="login-btn">Sign In</a>
        <% } %>
    </div>
</header>

<!-- Dropdown script -->
<script>
document.addEventListener('DOMContentLoaded', function() {
    const toggle = document.querySelector('.user-toggle');
    const menu = document.querySelector('.user-menu');

    if (toggle && menu) {
        toggle.addEventListener('click', function(e) {
            e.stopPropagation();
            menu.classList.toggle('show');
        });

        document.addEventListener('click', function(e) {
            if (!menu.contains(e.target) && !toggle.contains(e.target)) {
                menu.classList.remove('show');
            }
        });
    }
});
</script>