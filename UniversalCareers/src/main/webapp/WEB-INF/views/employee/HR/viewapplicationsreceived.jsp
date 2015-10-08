<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table-responsive col-md-10">
	<table class="table table-striped table-bordered">
	<caption>View Applications</caption>
		<tbody>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>View Full Profile</th>
				<th>View Resume</th>
				<th>Send Email</th>
			</tr>
			<c:forEach var="application" items="${applications}">
				<tr>
					<td>${application.user.firstName}</td>
					<td>${application.user.lastName}</td>
					<td class="text-center"><a class="btn btn-primary btn-md" href="viewApplicantDetails?applicantId=${application.user.id}">Details <span class="glyphicon glyphicon-search"></span></a></td>
					<c:if test="${not empty application.user.resumePath}">
						<td class="text-center"><a class="btn btn-primary btn-md" href="viewApplicantResume?applicantId=${application.user.id}">Resume <span class="glyphicon glyphicon-list-alt"></span></a></td>
					</c:if>
					<c:if test="${empty application.user.resumePath}">
						<td class="text-center"><span class="btn btn-danger glyphicon glyphicon-remove-circle"></span></a></td>
					</c:if>
					<td class="text-center"><a class="btn btn-primary btn-md" href="sendEmail?applicantId=${application.user.id}">Email <span class="glyphicon glyphicon-envelope"></span></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>