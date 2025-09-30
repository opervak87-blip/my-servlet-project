<%@ page
	import="java.util.List, ca.http.myservlet.bean.AdminHeaderNavBar"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="nav-bar">
	<c:forEach var="n" items="${sessionScope.header_nav_bar}">
		<div class="dropdown-wrapper">
			<div class="dropdown-title">
				<c:out value="${n.title}" />
			</div>
			<div class="dropdown-content">
				<c:forEach var="d" items="${n.listAdminDropMenu}">
					<div>
						<a
							href="${pageContext.request.contextPath}/Controller?command=goToDropMenuDetails&id=${d.id}">
							<c:out value="${d.title}" />
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</c:forEach>
</div>

<nav class="breadcrumbs">
	<c:forEach var="crumb" items="${requestScope.breadcrumbs}"
		varStatus="status">
		<c:choose>
			<c:when test="${status.last}">
				<span><c:out value="${crumb.label}" /></span>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath}${crumb.url}"> <c:out
						value="${crumb.label}" />
				</a>
				<span class="separator">&gt;</span>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</nav>


