<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css"/>
<fmt:bundle basename="resources.View">
<title><fmt:message key="header.appName"/></title>
</fmt:bundle>
</head>
<body>
<fmt:bundle basename="resources.View">
<header>
	<div class="options">
		<!-- Enable language changing -->
		<div class="lang">
		<form action="Locale" method="post">
		<button type="submit" name="langTag" value="en"><fmt:message key="language.en"/></button>
		<button type="submit" name="langTag" value="es-ES"><fmt:message key="language.es"/></button>
		<button type="submit" name="langTag" value="eu"><fmt:message key="language.eu"/></button>
		</form>
		</div><br/>
		<!-- Logout option if the user is logged -->
		<c:if test="${not empty sessionScope.user}">
			<div class="logout">
				<form action="Login">
					<button type="submit" name="action" value="logout"><fmt:message key="action.logout"/></button>
				</form>
			</div>
		</c:if>
	</div>
	<h1><fmt:message key="header.appName"/></h1>
	<nav>
		<a href="index.jsp"><fmt:message key="header.home"/></a><!--  
		--><a href="UserInfo"><fmt:message key="header.users"/></a><!--
		--><a href="NewsItemView"><fmt:message key="header.news"/></a>
	</nav>
</header>
</fmt:bundle>
<jsp:include page="messages_and_errors.jsp"></jsp:include>
<section class="mainContent">