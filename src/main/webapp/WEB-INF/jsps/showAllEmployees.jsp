<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jspf" %>
	<div class="container">
		<h1>Employee Data.............</h1>
		<br> <br>

		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Password</th>
					<th>Salary</th>
					<th>Edit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employeesList}" var="employee">
					<tr>
						<td>${employee.employeeId}</td>
						<td>${employee.employeeName}</td>
						<td>${employee.emailId}</td>
						<td>${employee.password}</td>
						<td>${employee.salary}</td>
						<td><a
							href="/spring-mvc2-day7/edit?employee_id=${employee.employeeId}">Edit</a>
							<a
							href="/spring-mvc2-day7/delete?employee_id=${employee.employeeId}">Delete</a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>


</body>
</html>
</html>