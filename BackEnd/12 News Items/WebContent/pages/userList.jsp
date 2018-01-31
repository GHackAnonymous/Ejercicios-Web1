<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="domain.user.model.*" %>
<jsp:include page="../includes/header.jsp"></jsp:include>
<article>
<c:choose>
	<c:when test="${not empty requestScope.users}">
	<fmt:bundle basename="resources.View">
	<h2><fmt:message key="header.users"/></h2>
	<form id="tableForm" action="UserEdit" method="get"></form>
	<table>
		<thead>
			<tr>
				<th></th>
				<th><fmt:message key="userProp.username" /></th>
				<th><fmt:message key="userProp.firstName" /></th>
				<th><fmt:message key="userProp.secondName" /></th>
				<th><fmt:message key="userProp.email" /></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${requestScope.users}" var="registeredUser">
			<tr>
				<td><input form="tableForm" type="radio" name="userId" value="<c:out value="${registeredUser.userId}"/>" required/>
				<td><c:out value="${registeredUser.username}"/></td>
				<td><c:out value="${registeredUser.firstName}"/></td>
				<td><c:out value="${registeredUser.secondName}"/></td>
				<td><c:out value="${registeredUser.email}"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<br/>
	<button form="tableForm"  type="submit" name="action" value="view"><fmt:message key="action.view" /></button>
	<button form="tableForm"  type="submit" name="action" value="edit"><fmt:message key="action.edit" /></button>
	<button form="tableForm"  type="submit" name="action" value="delete"><fmt:message key="action.delete" /></button>
	<hr/>
	
	<form  action="UserEdit" method="get">
	<button type="submit" name="action" value="new"><fmt:message key="action.register" /></button>
	</form>
	</fmt:bundle>
	</c:when>
	<c:otherwise>
		<fmt:bundle basename="resources.Errors">
		<p><fmt:message key="userList.mainSection"/></p>
		</fmt:bundle>
	</c:otherwise>
	
</c:choose>
</article>
<jsp:include page="../includes/footer.jsp"></jsp:include>