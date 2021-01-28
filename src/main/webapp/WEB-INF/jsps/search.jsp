<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Filter</title>
</head>
<body>
	<%@ include file="header.jspf"%>
	<div class="container">

		<h1>Employee Data.............</h1>
		<br>
		<br>
		<c:if test="${msg ne null}">
			<h5 class="alert alert-warning">${msg}</h5>
		</c:if>
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Password</th>
					<th>Salary</th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td>${employee.employeeId}</td>
					<td>${employee.employeeName}</td>
					<td>${employee.emailId}</td>
					<td>${employee.password}</td>
					<td>${employee.salary}</td>
				</tr>
			</tbody>
		</table>


	</div>
</body>
</html>