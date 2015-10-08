<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${not empty messageType}">
	<c:if test = "${messageType == 'success'}">
		<div class="alert alert-success" role="alert">
			${message}
		</div>		
	</c:if>
	<c:if test = "${messageType == 'failure'}">
		<div class="alert alert-danger" role="alert">
			${message}
		</div>		
	</c:if>
	<c:if test = "${messageType == 'info'}">
		<div class="alert alert-info" role="alert">
			${message}
		</div>		
	</c:if>
</c:if>

