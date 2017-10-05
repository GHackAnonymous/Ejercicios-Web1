<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
String isLogin = (String)session.getAttribute("error");

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
			<div>
				<h1>Dragon Ball Plots</h1>
			</div>
			<div>
				 
			</div>
			<nav>
				<div id="div_menu_db"><a href="cambiarPagina?mensaje=db">Dragon Ball</a></div>
				<div id="div_menu_dbz"><a href="cambiarPagina?mensaje=dbz">Dragon Ball Z</a></div>
				<div id="div_menu_dbgt"><a href="cambiarPagina?mensaje=dbgt">Dragon Ball GT</a></div>
			</nav>
		</header>
		<section>
			<%
				if(isLogin != null){
					out.println(isLogin);
					if(isLogin.equalsIgnoreCase("Wrong username or password")){
						out.println("Error");
					%>
						<%@ include file="login.jsp" %>
					<%
					}else{
					%>
						<%@ include file="login.jsp" %>
					<%
					}
				}else{
				%>
					<%@ include file="login.jsp" %>
				<%
				}
			%> 
			  
		</section>
		<footer>
			<div id="div_footer">
				<p>Coppyleft Alain Perez</p>
			</div>
		</footer>
	</body>
</html>

<!-- https://stackoverflow.com/questions/12018242/using-a-href-link-to-pass-parameters-to-servlet  -->