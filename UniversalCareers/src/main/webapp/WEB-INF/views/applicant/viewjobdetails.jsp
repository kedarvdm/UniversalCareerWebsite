<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="panel panel-primary">
	  <div class="panel-heading">
	    	<h3 class="panel-title">Job Details</h3>
	  </div>
	  <div class="panel-body">
	  	<table class="table table-hover">
	  		<tbody>
		  		<tr>
		  			<td><label for="jobTitle" class="control-label">Job Title:</label></td>
		  			<td colspan="3"><label class="control-label">${job.jobTitle}</label></td>
		  		</tr>
		  		<tr>
		  			<td><label for="description" class="control-label">Description:</label></td>
		  			<td colspan="3"><label class="control-label">${job.description}:</label></td>
		  		</tr>
		  		<tr>
		  			<td><label for="durationFrom" class="control-label">Duration From:</label></td>
		  			<td><label class="control-label">${job.durationFrom}</label></td>
		  			<td><label for="durationTo" class="control-label">Duration To:</label></td>
		  			<td><label class="control-label">${job.durationTo}</label></td>
		  		</tr>
		  		<tr>
		  			<td><label for="jobType" class="control-label">Job Type:</label></td>
		  			<td><label class="control-label">${job.jobType}</label></td>
		  			<td><label for="skills" class="control-label">Skills:</label></td>
		  			<td><label class="control-label">${job.skills}</label></td>
		  		</tr>
		  		<tr>
		  			<td><label for="city" class="control-label">City:</label></td>
		  			<td><label class="control-label">${job.city}</label></td>
		  			<td><label for="state" class="control-label">State:</label></td>
		  			<td><label class="control-label">${job.state}</label></td>
		  		</tr>
		  		<tr>
		  			<td><label for="country" class="control-label">Country:</label></td>
		  			<td><label class="control-label">${job.country}</label></td>
		  			<td><label for="hourlyWage" class="control-label">Hourly Wage:</label></td>
		  			<td><label class="control-label">${job.hourlyWage}</label></td>
		  		</tr>
		  		<c:if test="${noShow =='no'}">
		  			<tr>
			  			<td colspan="4"><a href="applyToJob?id=${job.id}" class="btn btn-success">Apply</a></td>
			  		</tr>
		  		</c:if>
	  		</tbody>
	  	</table>
	</div>
</div>