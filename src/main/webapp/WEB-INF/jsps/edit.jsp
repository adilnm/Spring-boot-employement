<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
<%@ include file="header.jspf" %>
	<div class="container">
		<h1>Edit Employee information</h1><br><br>
		
		<form action="update" method="post">
			<div class="row">
				<div class="col-md-3">Employee Name</div><div class="col-md-9"><input type="text" name="empName" value="${employee.employeeName}"></div>
			</div>
			</br>
			<div class="row">
				<div class="col-md-3">Email Id</div><div class="col-md-9"><input type="text" name="emailId" value="${employee.emailId}"></div>
			</div>
			</br>
			<div class="row">
				<div class="col-md-3">Password</div><div class="col-md-9"><input type="text" name="password" value="${employee.password}" ></div>
			</div>
			</br>
			<div class="row">
				<div class="col-md-3">Salary</div><div class="col-md-9"><input type="text" name="salary" value="${employee.salary}"></div>
			</div>
			</br>
			<input type="hidden" value="${employee.employeeId}" name="employeeId">
			<button type="submit" class="btn btn-success">Update</button>
		</form>
	</div>
</body>
</html>