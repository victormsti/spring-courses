<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>luv2code Company Home Page</title>
</head>
<body>
	<h2>luv2code Company Home Page - Test!!</h2>
	<hr>
	<p>Welcome to the luv2code Company Home Page!</p>
	
	<hr>

	<security:authorize access="hasRole('MANAGER')">
	<!-- add a link to point to /leaders ... this is for managers -->
	<p>
		<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
		(Only for Manager peeps)
	</p>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
	<!-- add a link to point to /systems ... this is for admins-->
	<p>
		<a href="${pageContext.request.contextPath}/systems">IT systems Meeting</a>
		(Only for Admin peeps)
	</p>
	</security:authorize>
	
	<hr>
	
	<!--  display user name and role -->
	User: <security:authentication property="principal.username"/>
	<br><br>
	Role(s): <security:authentication property="principal.authorities"/>
	
	<form:form
		action="${pageContext.request.contextPath}/logout"
		method="POST">
		
		<input type="submit" value="Logout">
		</form:form>
</body>
</html>