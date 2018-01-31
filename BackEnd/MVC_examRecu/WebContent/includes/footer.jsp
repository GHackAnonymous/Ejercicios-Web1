<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

</section><aside class="faq" >
	<fmt:bundle basename="resources.View">
	<h2><fmt:message key="faq.title"/></h2>
	<form id="tableForm" action="Faq" method="get" >
		
		<c:forEach items="${sessionScope.faq}" var="faq">
		
			<tr>
				<td form="tableForm" name="faqId">
					<hr/>
						<input form="tableForm" type="radio" name="faqId" value="<c:out value="${faq.faqId}"/>" required/>
						<h3><c:out value="${faq.question}" /></h3>
						<p><c:out value="${faq.answer}" /></p>
				</td>
				
				<c:if test="${not empty sessionScope.user}" >
					<td><button form="tableForm" type="submit" name="action" value="edit">edit</button></td>
					<td><button form="tableForm" type="submit" name="action" value="delete">delete</button></td>
				</c:if>
			</tr>
		</c:forEach>
	</form>
	
</aside>

<footer>
	<fmt:message key="footer.copyright"/>
	<span><fmt:message key="footer.name"/></span>
</footer>
</fmt:bundle>
</body>
</html>