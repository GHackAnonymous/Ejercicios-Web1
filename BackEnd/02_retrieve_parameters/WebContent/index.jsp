<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	
	String myParameter = request.getParameter("myParameter");
	if(myParameter==null){
		myParameter = new String("Nothin retrieved yet.");
	}
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Retrieving parameters in JSP</title>
  </head>
  <body>
  	<h1>Retrieving parameters in JSP</h1>
  	<form action="index.jsp" method="get">
  		<label>Write something to send.<input type="text" name="myParameter"/></label><br/>
  		<button type="submit">Send</button>
  	</form>
	<p><%= myParameter %></p>

  </body>
</html> 