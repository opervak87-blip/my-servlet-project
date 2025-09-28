<%@ page
	import="java.util.List, ca.http.myservlet.bean.AdminHeaderNavBar"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="nav-bar">
	<c:forEach var="n" items="${requestScope.header_nav_bar}">
		<div class="dropdown-wrapper">
			<div class="dropdown-title"><c:out value="${n.title}" /></div>
			<div class="dropdown-content">
				<c:forEach var="d" items="${n.listAdminDropMenu}">
					<div><c:out value="${d.title}" /></div>
				</c:forEach>
			</div>
			
		</div>
	</c:forEach>
</div>


