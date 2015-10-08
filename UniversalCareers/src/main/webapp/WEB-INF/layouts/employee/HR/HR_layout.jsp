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
		<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
	       <div class="container">
	           <div class="navbar-header">
	               <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	                   <span class="sr-only">Toggle navigation</span>
	                   <span class="icon-bar"></span>
	                   <span class="icon-bar"></span>
	                   <span class="icon-bar"></span>
	               </button>
	               <a class="navbar-brand" href="/controllers/">Universal Careers</a>
	           </div>
	           <!-- Collect the nav links, forms, and other content for toggling -->
	           <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	               <ul class="nav navbar-nav">
	                   <li>
	                       <a href="hrviewJobs">View Jobs</a>
	                   </li>
	                   <li>
	                       <a href="hrpostJob">Post Job</a>
	                   </li>
	                   <li>
	                       <a href="hrprofile">My Profile</a>
	                   </li>
	                   <li>
	                       <a href="hrchangepassword">Change Password</a>
	                   </li>
	                   <li>
	                      <a href="logout">Logout</a>
	                   </li>
	               </ul>
	           </div>
	       </div>
	   </nav>
	    <div class="container">
	       	<div class="row">
	            <div class="col-md-3">
	                <tiles:insertAttribute name="menu" />
	            </div>
	            <div class="col-md-9">
	            	<tiles:insertAttribute name="body" />
	            </div>
			</div>
		</div>			
</body>
</html>