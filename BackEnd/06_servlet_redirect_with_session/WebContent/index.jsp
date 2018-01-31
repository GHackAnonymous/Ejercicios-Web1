<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String error = (String)session.getAttribute("error");
String errorOutput = "";
if(error!=null && !error.equals("")){
	errorOutput = "<p class='error'>"+error+"</p>";
}
session.setAttribute("error", null);
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>First Servlet in JSP</title>
  </head>
  <body>
  	<h1>Retrieving parameters in JSP</h1>
  	<form action="IndexController" method="post">
  		<label>Write your name: <input type="text" name="username"/></label><br/>
  		<label>Write your password: <input type="password" name="userpass"/></label><br/>
  		<button type="submit">Send</button>
  	</form>
	<%= errorOutput %>
  </body>
</html> 