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
		<form class="form-inline" action="searchforadminuserdetails" method="post">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search" name="searchaddharno">
			<button class="btn btn-outline-success my-1 my-sm-0" type="submit">Search</button>
			
			<a href='adminlogout' style="padding-left: 20px;">
				<button type="button" class="btn btn-danger">Log out</button>
			</a>
		</form>
	</nav>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">User Name</th>
				<th scope="col">Age</th>
				<th scope="col">Gender</th>
				<th scope="col">Aadhar Number</th>
				<th scope="col">Date</th>
				<th scope="col">State</th>
				<!-- <th scope="col">Delete</th>
				<th scope="col">Update</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach var="data" items="${usersview}">
				<tr scope="row"
					style="width: 500px; border-radius: 2px solid red; box-shadow: 4px 4px 5px 0px rgba(0, 0, 0, 0.2);">
					<td><c:out value="${data.name }"></c:out></td>
					<td><c:out value="${data.age }"></c:out></td>
					<td><c:out value="${data.gender }"></c:out></td>
					<td><c:out value="${data.addharno }"></c:out></td>
					<td><c:out value="${data.vacdate }"></c:out></td>
					<td><c:out value="${data.state }"></c:out></td>
					<%-- <td><a href="delete/${data.addharno }"
						style="text-decoration: none"><button type="button"
								class="btn btn-danger">Delete</button> </a></td>
					<td><a href="edit/${data.addharno}"
						style="text-decoration: none"><button type="button"
								class="btn btn-primary">Update</button> </a></td> --%>

				</tr>
			</c:forEach>
		</tbody>
	</table>






</body>
</html>
