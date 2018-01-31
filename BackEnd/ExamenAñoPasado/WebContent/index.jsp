<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="modelo.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<link rel="stylesheet" type="text/css" href="css/style.css">
		
		<title>Dragon Ball web</title>
	</head>
	<body>
		<header>
			<div>
				<h1>Dragon Ball Plots</h1>
			</div>
			<nav>
				<div id="div_menu"><a href="./index.jsp">home</a></div>
				<div id="div_menu"><a href="#">Users</a></div>
				<div id="div_menu"><a href="#">News</a></div>
				<div id="div_menu"><a href="./advertController">Advert</a></div>
			</nav>
		</header>
		<section style="width: 80%;">
			<c:choose>
				<c:when test="${not empty sessionScope.user}">
					<h1>username: <c:out value="${sessionScope.user.username}"/>!</h1>
					<ul>
						<li>userId:<c:out value="${sessionScope.user.userId}"/></li>
					</ul>
					<form action="Login" method="get">
						<button type="submit" name="action" value="logout">logout</button>
					</form>
				</c:when>
				<c:otherwise>
					<h1>login</h1>
					<form action="Login" method="get">
					<label>username: <input type="text" name="username" required value="<c:out value="${requestScope.username}" default=""/>"/></label><br/>
					<label>password: <input type="password" name="password" required value="<c:out value="${requestScope.password}" default=""/>"/></label><br/>
					<button type="submit" name="action" value="login">login</button>
					</form>
				</c:otherwise>
			</c:choose>
		</section>
		<footer>
			<div id="div_footer">
				<p>Coppyleft Alain Perez</p>
			</div>
		</footer>
	</body>
</html>
