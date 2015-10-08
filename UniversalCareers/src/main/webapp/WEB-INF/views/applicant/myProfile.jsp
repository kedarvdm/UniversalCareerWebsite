<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<div class="row">
	<div class="panel panel-default">
	  <div class="panel-heading">
	    	<h3 class="panel-title">Contact Information</h3>
	    	<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#contactinfomodel">+</button>
	  </div>
	  <div class="panel-body">
		<div class="row">
			<div class="form-group col-lg-4">
				<label for="firstName" class="control-label">First Name:</label>
				<label>${applicant.firstName}</label>
			</div>
			<div class="form-group col-lg-4">
				<label for="middleName" class="control-label">Middle Name:</label>
				<label>${applicant.middleName}</label>
			</div>
			<div class="form-group col-lg-4">
				<label for="lastName" class="control-label">Last Name:</label>
				<label>${applicant.lastName}</label>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-lg-4">
				<label for="emailId" class="control-label">Email Id:</label>
				<label>${applicant.emailId}</label>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-lg-4">
				<label for="street1" class="control-label">Street 1:</label>
				<label>${applicant.address.street1}</label>
			</div>
			<div class="form-group col-lg-4">
				<label for="street2" class="control-label">Street 2:</label>
				<label>${applicant.address.street2}</label>
			</div>
			<div class="form-group col-lg-4">
				<label for="city" class="control-label">City:</label>
				<label>${applicant.address.city}</label>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-lg-4">
				<label for="state" class="control-label">State:</label>
				<label>${applicant.address.state}</label>
			</div>
			<div class="form-group col-lg-4">
				<label for="country" class="control-label">Country:</label>
				<label>${applicant.address.country}</label>
			</div>
			<div class="form-group col-lg-4">
				<label for="zip" class="control-label">Zip:</label>
				<label>${applicant.address.zip}</label>
			</div>
		</div>
	  </div>
	</div>
</div>
	<div class="modal fade" id="contactinfomodel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	  <form:form commandName="applicant" action="updatePersonalInfo">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
	      </div>
	      <div class="modal-body">
	        	<div class="row">
					<div class="form-group col-lg-12">
						<form:hidden path="id"/>
						<label for="firstName" class="control-label">First Name:</label>
						<form:input path="firstName" cssClass="form-control"/>
					</div>
					<div class="form-group col-lg-12">
						<label for="middleName" class="control-label">Middle Name:</label>
						<form:input path="middleName" cssClass="form-control"/>
					</div>
					<div class="form-group col-lg-12">
						<label for="lastName" class="control-label">Last Name:</label>
						<form:input path="lastName" cssClass="form-control"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12">
						<label for="emailId" class="control-label">Email Id:</label>
						<form:input path="emailId" cssClass="form-control"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-4">
						<form:hidden path="address.id"/>
						<label for="street1" class="control-label">Street 1:</label>
						<form:input path="address.street1" cssClass="form-control"/>
					</div>
					<div class="form-group col-lg-4">
						<label for="street2" class="control-label">Street 2:</label>
						<form:input path="address.street2" cssClass="form-control"/>
					</div>
					<div class="form-group col-lg-4">
						<label for="city" class="control-label">City:</label>
						<form:input path="address.city" cssClass="form-control"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-4">
						<label for="state" class="control-label">State:</label>
						<form:input path="address.state" cssClass="form-control"/>
					</div>
					<div class="form-group col-lg-4">
						<label for="country" class="control-label">Country:</label>
						<form:input path="address.country" cssClass="form-control"/>
					</div>
					<div class="form-group col-lg-4">
						<label for="zip" class="control-label">Zip:</label>
						<form:input path="address.zip" cssClass="form-control"/>
					</div>
				</div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <input type="submit" class="btn btn-primary" value="Save changes"/>
	      </div>
	    </div>
	    </form:form>
	  </div>
	</div>
	<div class="row">
	<div class="panel panel-default">
		<div class="panel-heading">
		<h3 class="panel-title">Educational Details</h3>
		<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#educationdetailsmodel">+</button>
		</div>
		<div class="panel-body">
		<div class="row">
			<div class="form-group col-lg-4">
				<label for="schoolName" class="control-label">School Name:</label>
				<label>${educationdetails.schoolName}</label>
			</div>
			<div class="form-group col-lg-4">
				<label for="major" class="control-label">Major:</label>
				<label>${educationdetails.major}</label>
			</div>
			<div class="form-group col-lg-4">
				<label for="degreeLevel" class="control-label">Degree Level:</label>
				<label>${educationdetails.degreeLevel}</label>
			</div>
		</div>
			<div class="row">
				<div class="form-group col-lg-4">
					<label for="startDate" class="control-label">Start Date:</label>
					<label>${educationdetails.startDate}</label>
				</div>
				<div class="form-group col-lg-4">
					<label for="endDate" class="control-label">End Date:</label>
					<label>${educationdetails.endDate}</label>
				</div>
				<div class="form-group col-lg-4">
					<label for="gpa" class="control-label">GPA:</label>
					<label>${educationdetails.gpa}</label>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-lg-4">
					<label for="isGraduated" class="control-label">Graduated?:</label>
					<label>${educationdetails.isGraduated}</label>
				</div>
			</div>
		</div>
	</div>
</div>
	<div class="modal fade" id="educationdetailsmodel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	  <form:form commandName="educationdetails" action="updateEducationalDetails">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">Educational Details</h4>
	      </div>
	      <div class="modal-body">
	       	<div class="row">
				<div class="form-group col-lg-4">
					<form:hidden path="id"/>
					<label for="schoolName" class="control-label">School Name:</label>
					<form:input cssClass="form-control" path="schoolName"/>
				</div>
				<div class="form-group col-lg-4">
					<label for="major" class="control-label">Major:</label>
					<form:input cssClass="form-control" path="major"/>
				</div>
				<div class="form-group col-lg-4">
					<label for="degreeLevel" class="control-label">Degree Level:</label>
					<form:input cssClass="form-control" path="degreeLevel"/>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-lg-4">
					<label for="startDate" class="control-label">Start Date:</label>
					<form:input cssClass="form-control" path="startDate"/>
				</div>
				<div class="form-group col-lg-4">
					<label for="endDate" class="control-label">End Date:</label>
					<form:input cssClass="form-control" path="endDate"/>
				</div>
				<div class="form-group col-lg-4">
					<label for="gpa" class="control-label">GPA:</label>
					<form:input cssClass="form-control" path="gpa"/>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-lg-4">
					<label for="isGraduated" class="control-label">Graduated?:</label>
					<form:input cssClass="form-control" path="isGraduated"/>
				</div>
			</div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <input type="submit" class="btn btn-primary" value="Save changes"/>
	      </div>
	    </div>
	    </form:form>
	  </div>
	</div>
	
<div class="row">
	<div class="panel panel-default">
		<div class="panel-heading">
		<h3 class="panel-title">Work Experience</h3>
		<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#workexmodel">+</button>
		</div>
		<div class="panel-body">
		<div class="row">
			<div class="form-group col-lg-4">
				<label for="employerName" class="control-label">Employer:</label>
				<label>${workEx.employerName}</label>
			</div>
			<div class="form-group col-lg-4">
				<label for="title" class="control-label">Title:</label>
				<label>${workEx.title}</label>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-lg-12">
				<label for="description" class="control-label">Description:</label>
				<label>${workEx.responsibilities}</label>
			</div>
		</div>
			<div class="row">
				<div class="form-group col-lg-4">
					<label for="startDate" class="control-label">Start Date:</label>
					<label>${workEx.startDate}</label>
				</div>
				<div class="form-group col-lg-4">
					<label for="endDate" class="control-label">End Date:</label>
					<label>${workEx.endDate}</label>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-lg-4">
					<label for="isCurrentEmployer" class="control-label">Current Employer?:</label>
					<label>${workEx.isCurrentEmployer}</label>
				</div>
			</div>
		</div>
	</div>
</div>
	<div class="modal fade" id="workexmodel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	  <form:form commandName="workEx" action="updateWorkExDetails">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">Work Experience</h4>
	      </div>
	      <div class="modal-body">
			<div class="row">
				<div class="form-group col-lg-4">
					<form:hidden path="id"/>
					<label for="employerName" class="control-label">Employer:</label>
					<form:input cssClass="form-control" path="employerName"/>
				</div>
				<div class="form-group col-lg-4">
					<label for="title" class="control-label">Title:</label>
					<form:input cssClass="form-control" path="title"/>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-lg-12">
					<label for="responsibilities" class="control-label">Description:</label>
					<form:input cssClass="form-control" path="responsibilities"/>
				</div>
			</div>
				<div class="row">
					<div class="form-group col-lg-4">
						<label for="startDate" class="control-label">Start Date:</label>
						<form:input cssClass="form-control" path="startDate"/>
					</div>
					<div class="form-group col-lg-4">
						<label for="endDate" class="control-label">End Date:</label>
						<form:input cssClass="form-control" path="endDate"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-4">
						<label for="isCurrentEmployer" class="control-label">Current Employer?:</label>
						<form:input path="isCurrentEmployer"/>
					</div>
				</div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <input type="submit" class="btn btn-primary" value="Save changes">
	      </div>
	      </div>
	      </form:form>
	    </div>
	  </div>