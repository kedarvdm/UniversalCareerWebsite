<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table-responsive col-md-10">
	<table class="table table-striped table-bordered">
	<caption>My Applications</caption>
		<tbody>
			<tr>
				<th>Employer</th>
				<th>Job Title</th>
				<th>Job Type</th>
				<th>Status</th>
				<th>Date Applied</th>
				<th>View Job Details</th>
			</tr>
			<c:forEach var="application" items="${applications}">
				<tr>
					<td>${application.job.employer.companyName}</td>
					<td>${application.job.jobTitle}</td>
					<td>${application.job.jobType}</td>
					<td>${application.appStatus}</td>
					<td>${application.dateCreated}</td>
					<td><a class="btn btn-primary" href="viewjobdetails?id=${application.job.id}&noShow=yes">View Details <span class="glyphicon glyphicon-search"></span></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>