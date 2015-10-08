<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="table-responsive col-md-10">
	<table class="table table-striped table-bordered">
	<caption>View Jobs</caption>
		<tbody>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Job Type</th>
				<th>From</th>
				<th>To</th>
				<th>Date Posted</th>
				<th>Positions</th>
				<th>Applications</th>
				<th>Edit</th>
			</tr>
			<c:forEach var="job" items="${jobs}">
				<tr>
					<td>${job.id}</td>
					<td>${job.jobTitle}</td>
					<td>${job.jobType}</td>
					<td>${job.durationFrom}</td>
					<td>${job.durationTo}</td>
					<td>${job.dateCreated}</td>
					<td>${job.positions}</td>
					<td><a class="btn btn-warning" href="viewApplications?jobId=${job.id}" >View</span></a></td>
					<td><a href="updatejob?id=${job.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>