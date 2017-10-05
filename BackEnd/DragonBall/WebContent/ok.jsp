<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
String username = (String)session.getAttribute("username");

%>
    
    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		
		<title>Dragon Ball web</title>
	</head>
	<body>
		<header>
			<h1>Dragon Ball Plots</h1>
			<form action="session" method="post" value="logout">
  				<button type="submit">Logout</button>
  			</form>
			<nav>
				<div id="div_menu_db"><a href="cambiarPagina?mensaje=db">Dragon Ball</a></div>
				<div id="div_menu_dbz"><a href="cambiarPagina?mensaje=dbz">Dragon Ball Z</a></div>
				<div id="div_menu_dbgt"><a href="cambiarPagina?mensaje=dbgt">Dragon Ball GT</a></div>
			</nav>
		</header>
		<section>
			Hola, <%= username %>
		</section>
		<footer>
			<div id="div_footer">
				<p>Coppyleft Alain Perez</p>
			</div>
		</footer>
	</body>
</html>