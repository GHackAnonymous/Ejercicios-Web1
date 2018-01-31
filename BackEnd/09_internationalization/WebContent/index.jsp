<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.Locale" %>
<%@ page import="javax.servlet.*,javax.servlet.http.* "%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>Detecting Locale</title>
</head>
<body>
<h1>Detecting Locale</h1>
<nav>
<fmt:bundle basename="resources.Resources">
<a href="LocaleController?language=en&country=UK"><fmt:message key="language.en"/></a>
<a href="LocaleController?language=es&country=ES"><fmt:message key="language.es"/></a>
<a href="LocaleController?language=eu&country=ES"><fmt:message key="language.eu"/></a>
</fmt:bundle>
</nav>
<section>
<p>Current Locale: <c:out value="${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session']}"/></p>
<fmt:bundle basename="resources.Resources">
   <p><fmt:message key="string.hello"/><p/>
   <p><fmt:message key="string.welcome"/><p/>
</fmt:bundle>
</section>
</body>
</html>