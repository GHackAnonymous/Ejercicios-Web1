<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="dominio.social.model.*" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<div id="social" style="position: fixed;padding: 8px;right: 8px;bottom: 3em;background-color: #CECECE;box-shadow: 0 0 16px rgba(0,0,0,0.8);display: inline;">
	<h2>Social:</h2>
	<form id="tableForm" action="./SocialItemEdit" method="get" style="display: inline;">
		
		<c:forEach items="${sessionScope.social}" var="social">
			
				<tr>
				<!-- En la sigiente linea tiene que estar la clave para el boton edit y delete -->
				<!-- el objetico es poder pasar el servlet el id de elemento al que se le ha dado delete o edit -->
				<!-- y desde el servlet modificar -->
					<td form="tableForm" name="socialItemId"><a href= "${social.socialUrl}" value="<c:out value="${social.socialItemId}"/>"><img style="position:relative;bottom:-0.6em;max-width:2em;max-height:2em;" src="./img/<c:out value="${social.logoUrl}"/>"/></a></td>
					<c:if test="${not empty sessionScope.user}" >
						<td><button form="tableForm" type="submit" name="action" value="edit">edit</button></td>
						<td><button form="tableForm" type="submit" name="action" value="delete">delete</button></td>
					</c:if>
				</tr>
		</c:forEach>
	</form>
</div>

</section>

<fmt:bundle basename="resources.View">
<footer>
	<fmt:message key="footer.copyright"/>
	<span><fmt:message key="footer.name"/></span>
</footer>
</fmt:bundle>
</body>
</html>