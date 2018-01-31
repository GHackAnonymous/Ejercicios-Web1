<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>First Servlet in JSP</title>
  </head>
  <body>
  	<h1>Retrieving parameters in JSP</h1>
  	<form action="IndexController" method="post">
  		<label>Write something to send: <input type="text" name="message"/></label><br/>
  		<button type="submit">Send</button>
  	</form>

  </body>
</html> 