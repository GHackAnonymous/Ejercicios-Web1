<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<div>
				 
			</div>
			<nav>
				<div id="div_menu"><a href="./index.jsp">home</a></div>
				<div id="div_menu"><a href="#">Users</a></div>
				<div id="div_menu"><a href="#">News</a></div>
				<div id="div_menu"><a href="./advertController">Advert</a></div>
			</nav>
		</header>
		<section>
			<h2>Create adverta</h2>
			<form action="./advertController" method="get">
				<label>title:</label>
				 <input type="text" name="title"/>
				 <label>source:</label>
				 <input type="text" name="src"/>
				 <label>ALT:</label>
				 <input type="text" name="alt"/>
				 <button type="submit" value="insert">Gorde</button>
			</form>
		</section>
		<aside>
			<c:forEach items="${requestScope.advertLista}" var="advert">
				<form id="tableForm" action="./advertController" method="get">
					<tr>
						<td form="tableForm" name="asideTitle"><h2><c:out value="${advert.title}"/></h2></td>
						<td><img alt="<c:out value="${advert.alt}"/>" src="img/<c:out value="${advert.src}"/>"/></td>
						<br/>
						<td><button  type="submit" name="action" value="edit">edit</button></td>
						<td><button  type="submit" name="action" value="delete">delete</button></td>
						<hr/>
					</tr>
				</form>
			</c:forEach>
		</aside>
		<footer>
			<div id="div_footer">
				<p>Coppyleft Alain Perez</p>
			</div>
		</footer>
	</body>
</html>



