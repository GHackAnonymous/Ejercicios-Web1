<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Testing JSTL</title>
</head>
<body>
<h2>Set &amp; Out</h2>
<c:set var="username" scope="session" value="${'Alain'}"/>
<p>Hi <c:out value="${sessionScope.username}" default="Unknown User"/></p>
<p> c:out => <c:out value="${'Text output using <c:out>, you can escape tags.'}"/>

<h2>Remove</h2>
<c:remove var="username"/>
<p>Hi <c:out value="${sessionScope.username}" default="Unknown User"/></p>


<h2>Foreach</h2>
<ul>
<c:forEach var="i" begin="1" end="5">
   <li>Item <c:out value="${i}"/></li>
</c:forEach>
</ul>

<table>
<c:forEach var="i" begin="1" end="10">
	<tr>
	<c:forEach var="j" begin="1" end="20">
		<td><c:out value="${i}-${j}"/></td>
	</c:forEach>
	</tr>
</c:forEach>
</table>

<%
String[] loggedUsers = {"Alain","Enaitz","Dani","Goiuria","Xabier"};
//request.setAttribute("loggedUsers",loggedUsers);
session.setAttribute("loggedUsers",loggedUsers);
%>
<ul>
<c:forEach items="${sessionScope.loggedUsers}" var="loggedUser">
	<li>User: <c:out value="${loggedUser}"/>
</c:forEach>
</ul>

<h2>Scopes</h2>
<c:set var="test" value="Page Level Value" scope="page" />

    <c:set var="test" value="Request Level Value" scope="request" />

    <c:set var="test" value="Session Level Value" scope="session" />

    <c:set var="test" value="Application Level Value" scope="application" />

    <table border="1">
<tr>
        <td>
          <b>Default Level</b>
        </td>

        <td>
          <c:out value="${test}" />
        </td>
      </tr>
      <tr>
        <td>
          <b>Page Level</b>
        </td>

        <td>
          <c:out value="${pageScope.test}" />
        </td>
      </tr>

      <tr>
        <td>
          <b>Request Level</b>
        </td>

        <td>
          <c:out value="${requestScope.test}" />
        </td>
      </tr>

      <tr>
        <td>
          <b>Session Level</b>
        </td>

        <td>
          <c:out value="${sessionScope.test}" />
        </td>
      </tr>

      <tr>
        <td>
          <b>Application Level</b>
        </td>

        <td>
          <c:out value="${applicationScope.test}" />
        </td>
      </tr>
    </table>
</body>
</html>