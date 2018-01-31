<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="domain.user.model.*" %>
<jsp:include page="../includes/header.jsp"></jsp:include>

<fmt:bundle basename="resources.View">
<article>
<form action="SocialNet?save" method="post">
	<input type="hidden" name="socialItemId" value="${requestScope.socialItem.socialItemId}"/>
	<label>
		Name:<br/>
		<input type="text" name="name" value="${requestScope.socialItem.name}" required/>
	</label><br/>
	<label>
		Logo URL:<br/>
		<input type="text" name="logoUrl" value="${requestScope.socialItem.logoUrl}" required/>
	</label><br/>
	<label>
		Social URL:<br/>
		<input type="text" name="socialUrl" value="${requestScope.socialItem.socialUrl}" required/>
	</label><br/>

<button type="Submit" name="action" value="save">save</button>
</form>
</article>
</fmt:bundle>

<jsp:include page="../includes/footer.jsp"></jsp:include>
