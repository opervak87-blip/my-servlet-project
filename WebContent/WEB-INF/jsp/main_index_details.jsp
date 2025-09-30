<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Riverstone Bank</title>
<link rel="stylesheet" type="text/css"
      href="<%=request.getContextPath()%>/css/style.css?v=<%=System.currentTimeMillis()%>">
</head>
<body>

	<!-- Header -->
	<%@ include file="/WEB-INF/jsp/includes/header.jsp"%>



	<!-- Navigation bar with dropdowns -->
	<%@ include file="/WEB-INF/jsp/includes/nav_bar.jsp"%>


	<div class="details-container">
		<!-- Title of the dropdown menu (from the first element of the list) -->
		<c:if test="${not empty admin_drop_menu_details}">
			<h2 class="menu-title">
				<c:out value="${admin_drop_menu_details[0].adminDropMenu.title}" />
			</h2>
		</c:if>

		<div class="details-grid">
			<!-- Top box (first article) -->


			<!-- Bottom two boxes -->
			<div class="bottom-boxes">
				<c:forEach var="d" items="${admin_drop_menu_details}" begin="0"
					end="2">
					<div class="detail-box">
						<h3>
							<c:out value="${d.title}" />
						</h3>
						<p>
							<c:out value="${d.article}" />
						</p>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>


</body>
</html>