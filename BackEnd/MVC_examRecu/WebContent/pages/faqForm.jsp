<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="domain.user.model.*" %>
<jsp:include page="../includes/header.jsp"></jsp:include>
<article>
<fmt:bundle basename="resources.View">

<h1><fmt:message key="faq.create"/></h1>
<form action="Faq" method="get">


<label for="question"><fmt:message key="faq.question"/>:</label>
<input id="question" type="text" name="question" value="${requestScope.faqItem.question}" required/><br>
<label for="answer"><fmt:message key="faq.answer"/>:</label>
<input id="answer" type="answer" name="answer" value="${requestScope.faqItem.answer}" required/><br>

<button type="Submit" name="action" value="save"><fmt:message key="action.save"/></button>
</form>
</fmt:bundle>
</article>
<jsp:include page="../includes/footer.jsp"></jsp:include>