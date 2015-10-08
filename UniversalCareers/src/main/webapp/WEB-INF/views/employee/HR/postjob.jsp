<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<form:form commandName="job" action="hrpostJobSubmit">
	<div class="row">
		<div class="form-group col-lg-12">
			<label for="jobTitle" class="control-label">Job Title:</label>
			<form:input path="jobTitle" cssClass="form-control"/>
		</div>
		<div class="form-group col-lg-12">
			<label for="description" class="control-label">Description:</label>
			<form:input path="description" cssClass="form-control"/>
		</div>
		<div class="form-group col-lg-6">
			<label for="durationFrom" class="control-label">Duration From:</label>
			<form:input path="durationFrom" cssClass="form-control"/>
		</div>
		<div class="form-group col-lg-6">
			<label for="durationTo" class="control-label">Duration To:</label>
			<form:input path="durationTo" cssClass="form-control"/>
		</div>
		<div class="form-group col-lg-6">
			<label for="jobType" class="control-label">Job Type:</label>
			<form:input path="jobType" cssClass="form-control"/>
		</div>
		<div class="form-group col-lg-6">
			<label for="skills" class="control-label">Skills:</label>
			<form:input path="skills" cssClass="form-control"/>
		</div>
		<div class="form-group col-lg-6">
			<label for="city" class="control-label">City:</label>
			<form:input path="city" cssClass="form-control"/>
		</div>
		<div class="form-group col-lg-6">
			<label for="state" class="control-label">State:</label>
			<form:input path="state" cssClass="form-control"/>
		</div>
		<div class="form-group col-lg-6">
			<label for="country" class="control-label">Country:</label>
			<form:input path="country" cssClass="form-control"/>
		</div>
		<div class="form-group col-lg-6">
			<label for="hourlyWage" class="control-label">Hourly Wage:</label>
			<form:input path="hourlyWage" cssClass="form-control"/>
		</div>
		<div class="form-group col-lg-6">
			<label for="positions" class="control-label">Positions:</label>
			<form:input path="positions" cssClass="form-control"/>
		</div>
		<div class="form-group col-lg-12">
			<input type="submit" name="postjob" value="Post Job" class="btn btn-success">
		</div>
	</div>
</form:form>
