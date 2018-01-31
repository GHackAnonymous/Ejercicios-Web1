<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.user.model.User" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:forEach items="${requestScope.users}" var="registeredUser">
		<tr>
			<td><input form="tableForm" type="radio" name="userId" value="<c:out value="${registeredUser.userId}"/>" required/>
			<td><c:out value="${registeredUser.username}"/></td>
			<td><c:out value="${registeredUser.firstName}"/></td>
			<td><c:out value="${registeredUser.secondName}"/></td>
			<td><c:out value="${registeredUser.email}"/></td>
		</tr>
	</c:forEach>
	
	
</body>
</html>