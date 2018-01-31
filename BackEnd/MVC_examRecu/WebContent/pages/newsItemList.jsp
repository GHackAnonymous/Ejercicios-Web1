<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="domain.news.model.*" %>
<jsp:include page="../includes/header.jsp"></jsp:include>

<c:if test="${not empty sessionScope.user }">
	<fmt:bundle basename="resources.View">
	<form action="NewsItemEdit" method="get">
		<button type="submit" name="action" value="new"><fmt:message key="action.newNewsItem"/></button>
	</form>
	</fmt:bundle>
</c:if>
<c:choose>
	<c:when test="${not empty requestScope.news}">
	<c:forEach items="${requestScope.news}" var="newsItem">
	<article class="newsItem">
		<h1><a href="NewsItemView?newsItemId=${newsItem.newsItemId}"><c:out value="${newsItem.title}"/></a></h1>
		<p class="otherInfo">
			<span class="author">
				<a href="UserInfo?userId=${newsItem.author.userId}">
					<c:out value="${newsItem.author.username}"/>
				</a>
			</span>
			<span class="lang"><c:out value="${newsItem.lang.language}"/></span>
			<span class="date"><c:out value="${newsItem.date}"/></span>
		</p>
		<div class="body"><c:out value="${newsItem.body}" escapeXml="false"/></div>
	</article>
	</c:forEach>
	</c:when>
	<c:otherwise>
		<fmt:bundle basename="resources.Errors">
		<p><fmt:message key="newsItemList.mainSection"/></p>
		</fmt:bundle>
	</c:otherwise>
</c:choose>

<jsp:include page="../includes/footer.jsp"></jsp:include>