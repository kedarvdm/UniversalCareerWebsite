<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<form:form commandName="applicant" action="applicantSignUpSubmit" method="POST" onsubmit="return validate();">
<div class="table-responsive col-md-10">
	<table class="table table-striped table-bordered">
	<caption>Applicant Sign Up</caption>
		<tbody>
			<tr >
				<td>First Name:</td>
				<td>
					<div class="col-md-10">
						<form:input path="firstName" cssClass="form-control" name="fistName" required="required"/>
					</div>
				</td>
			</tr>
			<tr >
				<td>Middle Name:</td>
				<td>
					<div class="col-md-10">
						<form:input path="middleName" cssClass="form-control" name="middleName"/>
					</div>
				</td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td>
					<div class="col-md-10">
						<form:input path="lastName" cssClass="form-control" name="lastName"/>
					</div>
				</td>
			</tr>
			<tr>
				<td>Email Address:</td>
				<td>
					<div class="col-md-10">
						<form:input path="emailId" cssClass="form-control" name="emailId"  required="required"/>
					</div>
				</td>
			</tr>
			<tr>
				<td>Choose Password:</td>
				<td>
					<div class="col-md-10">
					  <input type="password" id="password1" class="form-control" name="password2"  required="required">
					</div>
				</td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td>
					<div class="col-md-10">
						<form:password path="password" cssClass="form-control" name="password"  required="required"/>
					</div>
				</td>
			</tr>
			<tr>
				<td>Street Address 1:</td>
				<td>
					<div class="col-md-10">
						<form:input path="address.street1" cssClass="form-control" name="street1"/>
					</div>
				</td>
			</tr>
			<tr>
				<td>Street Address 2:</td>
				<td>
					<div class="col-md-10">
						<form:input path="address.street2" cssClass="form-control" name="street2"/>
					</div>
				</td>
			</tr>
			<tr>
				<td>City:</td>
				<td>
					<div class="col-md-10">
						<form:input path="address.city" cssClass="form-control" name="city"/>
					</div>
				</td>
			</tr>
			<tr>
				<td>State:</td>
				<td>
					<div class="col-md-10">
						<form:input path="address.state" cssClass="form-control" name="state"/>
					</div>
				</td>
			</tr>
			<tr>
				<td>Country:</td>
				<td>
					<div class="col-md-10">
						<form:input path="address.country" cssClass="form-control" name="country"/>
					</div>
				</td>
			</tr>
			<tr>
				<td>Zip Code:</td>
				<td>
					<div class="col-md-10">
						<form:input path="address.zip" cssClass="form-control" name="zip"/>
					</div>
				</td>
			</tr>
			<tr>
				<td>Cell Phone:</td>
				<td>
					<div class="col-md-10">
						<form:input path="cellphone" cssClass="form-control" name="cellphone"/>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="col-md-offset-4 col-md-3">
						<input type="submit" name="applicantcontactinfo" value="Sign Up!!" class="form-control btn btn-success"/>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</div>
</form:form>

<script type="text/javascript">
	function validate() {
	    //Validate 2 passwords
	    var pass1 = document.getElementById('password1');
	  	//Check password length
	  	if(pass1.value.length<6)
	  	{
	  		alert('Password should be at least 6 characters long.');
	  		return false;
	  	}
	    var pass2 = document.getElementById('password');
	    if(pass1.value != pass2.value){
	    	alert('Passwords do not match.');
	    	return false;
	    }
	    return true;
	}
</script>

