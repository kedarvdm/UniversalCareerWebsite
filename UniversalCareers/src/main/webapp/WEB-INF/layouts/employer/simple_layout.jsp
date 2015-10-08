<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	<title><tiles:insertAttribute name="title" /></title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-inverse navbar-static-top">
		  <div class="container">
			<div class="navbar-header">
			  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			  </button>
			  <a class="navbar-brand" href="/controllers/">Universal Careers</a>
			</div>
			<div id="navbar" class="navbar-collapse navbar-inverse collapse">
			  <form class="navbar-form navbar-right" action="loginsubmit" method="POST">
				<div class="form-group">
				  <input type="text" placeholder="Email ID" class="form-control" name="emailid" required>
				</div>
				<div class="form-group">
				  <input type="password" placeholder="Password" class="form-control" name="password" required>
				</div>
				<div class="form-group">
				  <label class="label" for="sel1">Are you?</label>
				  <select class="form-control" id="sel1" name="userType">
					<option value="applicant">Applicant</option>
					<option value="employee">Employee</option>
					<option value="employer">Employer</option>
				  </select>
				</div>
				<button type="submit" class="btn btn-success">Sign in</button>
			  </form>
			</div>
		  </div>
		</nav>
		<tiles:insertAttribute name="body" />
	</div>
</body>
</html>