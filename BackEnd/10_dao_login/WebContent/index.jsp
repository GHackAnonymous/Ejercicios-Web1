<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css"/>
<title>DAO login</title>
</head>
<body>
<c:if test="${not empty requestScope.error}">
	<p class="error"><c:out value="${requestScope.error}"/></p>
</c:if>
<c:if test="${not empty requestScope.message}">
	<p class="message"><c:out value="${requestScope.message}"/></p>
</c:if>


<c:choose>
	<c:when test="${sessionScope.isLoged}">
		<h1>You are loged!</h1>
		<form action="Login">
			<button type="submit" name="action" value="logout">Logout</button>
		</form>
	</c:when>
	<c:otherwise>
		<h1>Login</h1>
		<form action="Login" method="post">
		<label>Username: <input type="text" name="username" required value="<c:out value="${requestScope.username}" default=""/>"/></label><br/>
		<label>Password: <input type="password" name="password" required value="<c:out value="${requestScope.password}" default=""/>"/></label><br/>
		<button type="submit" name="action" value="login">Login</button>
		</form>
	</c:otherwise>
</c:choose>
</body>
</html>