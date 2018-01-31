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
			<h2>Modi adverta</h2>
			
			<form action="./advertController" method="get">
			<table>
			<tr>
				<td><label>ID:</label></td>
				<td><input id="id" type="text" name="id" value="${requestScope.user.username}" required/></td>
			</tr>
			<tr>
				<td><label>title:</label></td>
				<td><input id="title" type="text" name="title" value="${requestScope.user.username}" required/></td>
			</tr>
			<tr>
				<td><label>source:</label></td>
				<td><input id="src" type="password" name="src" value="${requestScope.user.password}" required/></td>
			</tr>
			<tr>
				<td><label>ALT:</label></td>
				<td><input id="alt" type="text" name="alt" value="${requestScope.user.firstName}" required/></td>
			</tr>
			</table>
			<button type="Submit" name="action" value="save">save</button>
			</form>
			
		</section>
		<footer>
			<div id="div_footer">
				<p>Coppyleft Alain Perez</p>
			</div>
		</footer>
	</body>
</html>



