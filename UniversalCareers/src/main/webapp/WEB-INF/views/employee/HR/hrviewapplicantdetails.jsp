<div class="row">
	<div class="panel panel-default">
	  <div class="panel-heading">
	    	<h3 class="panel-title">Contact Information</h3>
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
	
<div class="row">
	<div class="panel panel-default">
		<div class="panel-heading">
		<h3 class="panel-title">Educational Details</h3>
		</div>
		<div class="panel-body">
		<div class="row">
			<div class="form-group col-lg-4">
				<label for="schoolName" class="control-label">School Name:</label>
				<label>${applicant.education.schoolName}</label>
			</div>
			<div class="form-group col-lg-4">
				<label for="major" class="control-label">Major:</label>
				<label>${applicant.education.major}</label>
			</div>
			<div class="form-group col-lg-4">
				<label for="degreeLevel" class="control-label">Degree Level:</label>
				<label>${applicant.education.degreeLevel}</label>
			</div>
		</div>
			<div class="row">
				<div class="form-group col-lg-4">
					<label for="startDate" class="control-label">Start Date:</label>
					<label>${applicant.education.startDate}</label>
				</div>
				<div class="form-group col-lg-4">
					<label for="endDate" class="control-label">End Date:</label>
					<label>${applicant.education.endDate}</label>
				</div>
				<div class="form-group col-lg-4">
					<label for="gpa" class="control-label">GPA:</label>
					<label>${applicant.education.gpa}</label>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-lg-4">
					<label for="isGraduated" class="control-label">Graduated?:</label>
					<label>${applicant.education.isGraduated}</label>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Work Experience</h3>
		</div>
		<div class="panel-body">
		<div class="row">
			<div class="form-group col-lg-4">
				<label for="employerName" class="control-label">Employer:</label>
				<label>${applicant.workEx.employerName}</label>
			</div>
			<div class="form-group col-lg-4">
				<label for="title" class="control-label">Title:</label>
				<label>${applicant.workEx.title}</label>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-lg-12">
				<label for="description" class="control-label">Description:</label>
				<label>${applicant.workEx.responsibilities}</label>
			</div>
		</div>
			<div class="row">
				<div class="form-group col-lg-4">
					<label for="startDate" class="control-label">Start Date:</label>
					<label>${applicant.workEx.startDate}</label>
				</div>
				<div class="form-group col-lg-4">
					<label for="endDate" class="control-label">End Date:</label>
					<label>${applicant.workEx.endDate}</label>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-lg-4">
					<label for="isCurrentEmployer" class="control-label">Current Employer?:</label>
					<label>${applicant.workEx.isCurrentEmployer}</label>
				</div>
			</div>
		</div>
	</div>
</div>