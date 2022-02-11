<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>New/Edit Contact</title>
</head>
<body>
	<div class="container mt-3">
		<h1 class="text-center">New/Edit Contact</h1>
		<br> <br>

	</div>


	<div class="container col-md-4 col-md-offset-4">

		<form:form action="save" method="post" modelAttribute="contact">
			<div class="form-group">
				<form:hidden path="id"/>
			</div>
			<div class="form-group">
				<form:label path="name" for="userName">Name</form:label>
				<form:input path="name" type="text" class="form-control"
					id="userName" placeholder="Enter name" />
			</div>
			<div class="form-group">
				<form:label path="email" for="userEmail">Email</form:label>
				<form:input path="email" type="email" class="form-control"
					id="userEmail" aria-describedby="emailHelp"
					placeholder="Enter email" />
			</div>
			<div class="form-group">
				<form:label path="address" for="userAddress">Address</form:label>
				<form:textarea path="address" class="form-control" id="userAddress"
					placeholder="Enter address" />
			</div>
			<div class="form-group">
				<form:label path="phone" for="userPhone">Name</form:label>
				<form:input path="phone" type="text" class="form-control"
					id="userPhone" placeholder="Enter phone number" />
			</div>
			<div class="col text-center">
			<br>
			<form:button type="submit" value="Save" class="btn btn-primary">Submit</form:button>
			</div>
		</form:form>

		<br>

	</div>







	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>