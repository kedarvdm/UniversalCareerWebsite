<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<div class="container">
	<form:form commandName="changePassword" action="applicantChangePasswordSubmit">
		<table class="table table-striped">
			<tr>
				<td><label for="oldPassword" class="control-label">OldPassword</label></td>
				<td><form:input path="oldPassword" cssClass="form-control" required="required"/></td>
			</tr>
			<tr>
				<td><label for="newPassword1" class="control-label">New Password</label></td>
				<td><form:input path="newPassword1" cssClass="form-control" required="required"/></td>
			</tr>
			<tr>
				<td><label for="newPassword2" class="control-label">Confirm Password</label></td>
				<td><form:input path="newPassword2" cssClass="form-control" required="required"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="changepwd" value="Change Password" class="btn btn-success"/>
				</td>
			</tr>
		</table>
	</form:form>
</div>