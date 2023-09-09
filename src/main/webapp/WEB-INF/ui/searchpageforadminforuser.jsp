<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<style>
</style>
</head>
<body>


	<nav class="navbar navbar-light bg-light justify-content-between">
		<a class="navbar-brand">Covid19</a>
		<form class="form-inline" action="searchloop" method="post">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search" name="searchuserid" value="${userdetails[0][0] }">
			
			<a href='adminlogout' style="padding-left: 20px;">
				<button type="button" class="btn btn-danger">Log out</button>
			</a>
			</a> <a href='users' style="padding-left: 20px;">
				<button type="button" class="btn btn-success">Back</button>
			</a>
		</form>
	</nav>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">User ID</th>
				<th scope="col">Email</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="data" items="${userdetails}">
				<tr scope="row"
					style="width: 500px; border-radius: 2px solid red; box-shadow: 4px 4px 5px 0px rgba(0, 0, 0, 0.2);">
					<td><c:out value="${data[0] }"></c:out></td>
					<td><c:out value="${data[1] }"></c:out></td>	
				</tr>
			</c:forEach>
		</tbody>
	</table>






</body>
</html>

