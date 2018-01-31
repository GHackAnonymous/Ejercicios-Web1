<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="domain.user.model.*" %>
<jsp:include page="../includes/header.jsp"></jsp:include>
<fmt:bundle basename="resources.View">
<article>
<c:choose>
<c:when test="${not empty requestScope.socialItem}">
	<h1><fmt:message key="socialItem.edit"/></h1>
</c:when>
<c:otherwise>
	<h1><fmt:message key="socialItem.create"/></h1>
</c:otherwise>
</c:choose>
<form action="./SocailItemEdit" method="post">
	<!-- SoacialItemID -->
	<input type="hidden" name="socialId" value="${requestScope.socialItem.socialItemId}"/>
	<input type="hidden" name="lang" value="${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session']}"/>
	<label>
		<fmt:message key="socialItemProp.name"/>:<br/>
		<input type="text" name="name" value="${requestScope.socialItem.name}" required/>
	</label><br/>
	<label>
		<fmt:message key="socialItemProp.logo"/>:<br/>
		<input type="text" name="logo" value="${requestScope.socialItem.logoUrl}" required/>
	</label><br/>
	<label>
		<fmt:message key="socialItemProp.url"/>:<br/>
		<input type="text" name="url" value="${requestScope.socialItem.socialUrl}" required/>
	</label><br/>

<button type="Submit" name="action" value="save"><fmt:message key="action.save"/></button>
</form>
</article>
</fmt:bundle>
<jsp:include page="../includes/footer.jsp"></jsp:include>