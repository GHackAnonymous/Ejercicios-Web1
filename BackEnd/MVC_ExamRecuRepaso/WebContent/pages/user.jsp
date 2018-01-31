<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="domain.user.model.*" %>
<jsp:include page="../includes/header.jsp"></jsp:include>
<article>
<c:choose>
	<c:when test="${not empty requestScope.user}">
	<fmt:bundle basename="resources.View">
	<h1><fmt:message key="header.user"/></h1>
	<ul>
		<li><fmt:message key="userProp.userId"/>:<c:out value="${requestScope.user.userId}"/></li>
		<li><fmt:message key="userProp.username"/>:<c:out value="${requestScope.user.username}"/></li>
		<li><fmt:message key="userProp.firstName"/>: <c:out value="${requestScope.user.firstName}"/></li>
		<li><fmt:message key="userProp.secondName"/>: <c:out value="${requestScope.user.secondName}"/></li>
		<li><fmt:message key="userProp.email"/>: <c:out value="${requestScope.user.email}"/></li>
	</ul>
	</fmt:bundle>
	</c:when>
	<c:otherwise>
		<fmt:bundle basename="resources.Errors">
		<p><fmt:message key="user.mainSection"/></p>
		</fmt:bundle>
	</c:otherwise>
</c:choose>
</article>
<jsp:include page="../includes/footer.jsp"></jsp:include>