<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="domain.user.model.*" %>
<jsp:include page="../includes/header.jsp"></jsp:include>
<fmt:bundle basename="resources.View">
<article>
<c:choose>
<c:when test="${not empty requestScope.newsItem}">
	<h1><fmt:message key="newsItem.edit"/></h1>
</c:when>
<c:otherwise>
	<h1><fmt:message key="newsItem.create"/></h1>
</c:otherwise>
</c:choose>
<form action="NewsItemEdit" method="post">
	<!-- newsItemID -->
	<input type="hidden" name="newsItemId" value="${requestScope.newsItem.newsItemId}"/>
	<input type="hidden" name="lang" value="${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session']}"/>
	<label>
		<fmt:message key="newsItemProp.title"/>:<br/>
		<input type="text" name="title" value="${requestScope.newsItem.title}" required/>
	</label><br/>
	<label>
		<fmt:message key="newsItemProp.body"/>:<br/>
		<textarea class="contentBody" name="body" required><c:out value="${requestScope.newsItem.body}"/></textarea>
	</label><br/>

<button type="Submit" name="action" value="save"><fmt:message key="action.save"/></button>
</form>
</article>
</fmt:bundle>
<jsp:include page="../includes/footer.jsp"></jsp:include>