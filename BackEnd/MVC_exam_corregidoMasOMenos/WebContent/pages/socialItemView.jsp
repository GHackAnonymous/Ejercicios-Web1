<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="dominio.news.model.*" %>
<jsp:include page="../includes/header.jsp"></jsp:include>
<c:choose>
	<c:when test="${not empty requestScope.socialItem}">
	<article class="newsItem">
		<h1><c:out value="${requestScope.socialItem.name}"/> (<c:out value="${requestScope.socialItem.socialItemId}"/>)</h1>
		
		<div class="body"><c:out value="${requestScope.socialItem.name}" escapeXml="false"/></div>
		<c:if test="${requestScope.socialItem.author.userId==sessionScope.user.userId}">
			<fmt:bundle basename="resources.View">
			<form action="SocialItemEdit" method="get">
				<input type="hidden" name="newsItemId" value="${requestScope.socialItem.newsItemId}"/>
				<button type="submit" name="action" value="edit"><fmt:message key="action.edit"/></button>
				<button type="submit" name="action" value="delete"><fmt:message key="action.delete"/></button>
			</form>
			</fmt:bundle>
		</c:if>
	</article>
	</c:when>
	<c:otherwise>
		<fmt:bundle basename="resources.Errors">
		<p><fmt:message key="newsItemView.mainSection"/></p>
		</fmt:bundle>
	</c:otherwise>
</c:choose>

<jsp:include page="../includes/footer.jsp"></jsp:include>