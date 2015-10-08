<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
	<form method="POST" action="uploadResumeSubmit" enctype="multipart/form-data">
		<div class="form-group col-lg-12">
				<label for="file" class="control-label">Select Resume:</label>
				<input type="file" name="file" class="form-control" required/>
		</div>
		<div class="col-lg-12">
			<input type="submit" name="fileUpload" value="Upload Resume"/>
		</div>
		<c:if test="${id != 'NA'}">
			<div class="col-lg-12">
				<a href="download">Previously Uploaded Resume</a>
			</div>
		</c:if>
	</form>
</div>
