<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<div class="container">
	<form:form method="POST" commandName="emailDetails" action="sendEmailSubmit">
	<div class="table-responsive col-md-10">
		<table class="table table-striped table-bordered">
		<caption>Update HR Profile</caption>
			<tbody>
				<tr >
					<td>From:</td>
					<td>
						<div class="col-md-10">
							<form:input path="from" class="form-control" readonly="true"/>
						</div>
					</td>
				</tr>
				<tr>
					<td>To:</td>
					<td>
						<div class="col-md-10">
							<form:input path="toName" class="form-control" readonly="true"/>
						</div>
					</td>
				</tr>
				<tr>
					<td>Email:</td>
					<td>
						<div class="col-md-10">
							<form:input path="to" class="form-control" readonly="true"/>
						</div>
					</td>
				</tr>
				<tr>
					<td>Subject:</td>
					<td>
						<div class="col-md-10">
							<form:input path="subject" class="form-control"/>
						</div>
					</td>
				</tr>
				<tr>
					<td>Body:</td>
					<td>
						<form:textarea path="body" rows="4" cols="50" class="form-control"/>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" class="btn btn-success" value="Send" name="sendEmail"/></td>
				</tr>
			</tbody>
			</table>
		</div>
	</form:form>
</div>