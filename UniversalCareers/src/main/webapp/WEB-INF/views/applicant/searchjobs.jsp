<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-12">
	<div class="search container">
		<form:form commandName="searchCriteria" action="searchJobSubmit">
			<div class="row">
				<div class="form-group col-lg-4">
					<label for="jobTitle" class="control-label">Job Title:</label>
					<form:input path="jobTitle" cssClass="form-control" required="required"/>
				</div>
				<div class="form-group col-lg-4">
					<label for="city" class="control-label">City:</label>
					<form:input path="city" cssClass="form-control"/>
				</div>
				<div class="form-group col-lg-4">
					<label for="state" class="control-label">State:</label>
					<form:input path="state" cssClass="form-control"/>
				</div>
			</div>
			<div class="row text-center">
				<input type="submit" name="searchjob" value="Search" class="btn btn-success"/>
			</div>
		</form:form>
	</div>
	<c:if test="${empty searchResults}">
		<div class="container">
			<label class="control-label">No Results Yet.</label>
		</div>
	</c:if>
	<c:if test="${not empty searchResults}">
		<div class="searchResults container">
			<div class="table-responsive col-md-10">
				<table class="table table-striped table-bordered">
				<caption>View Jobs</caption>
					<tbody>
						<tr>
							<th>Employer</th>
							<th>Title</th>
							<th>Job Type</th>
							<th>From</th>
							<th>To</th>
							<th>City</th>
							<th>State</th>
							<th>Job Details</th>
						</tr>
						<c:forEach var="job" items="${searchResults}">
							<tr>
								<td>${job.employer.companyName}</td>
								<td>${job.jobTitle}</td>
								<td>${job.jobType}</td>
								<td>${job.durationFrom}</td>
								<td>${job.durationTo}</td>
								<td>${job.city}</td>
								<td>${job.state}</td>
								<td><a class="btn btn-primary" href="viewjobdetails?id=${job.id}">View Details <span class="glyphicon glyphicon-search"></span></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</c:if>
</div>

