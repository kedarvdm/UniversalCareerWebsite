<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
<form:form commandName="applicant">
	<div class="container">
		<div class="table-responsive col-md-10">
			<table class="table table-striped table-bordered">
				<tbody>
					<tr>
						<td>Country/Region:</td>
						<td>
							<div class="col-md-10">
								<form:input path="" cssClass="form-control" name="country"/>
							</div>
						</td>
						<td></td>
					</tr>
					<tr >
						<td>First (Given) Name:</td>
						<td>
							<div class="col-md-10">
								<form:input path="" cssClass="form-control" name="fname"/>
							</div>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>Middle Name:</td>
						<td>
							<div class="col-md-10">
								<form:input path="" cssClass="form-control" name="mname"/>
							</div>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>Last (Family) Name:</td>
						<td>
							<div class="col-md-10">
								<form:input path="" cssClass="form-control" name="lname"/>
							</div>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>Street Address 1:</td>
						<td>
							<div class="col-md-10">
								<form:input path="" cssClass="form-control" name="addr1"/>
							</div>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>Street Address 2:</td>
						<td>
							<div class="col-md-10">
								<form:input path="" cssClass="form-control" name="addr2"/>
							</div>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>Street Address 3:</td>
						<td>
							<div class="col-md-10">
								<form:input path="" cssClass="form-control" name="addr3"/>
							</div>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>City:</td>
						<td>
							<div class="col-md-10">
								<form:input path="" cssClass="form-control" name="city"/>
							</div>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>State:</td>
						<td>
							<div class="col-md-10">
								<form:input path="" cssClass="form-control" name="state"/>
							</div>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>Zip Code:</td>
						<td>
							<div class="col-md-10">
								<form:input path="" cssClass="form-control" name="zip"/>
							</div>
						</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</form:form>
</body>
</html>