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
	<%@ include file="header.jspf"%>
	<div class="container">
		<h1>Employee Data.............</h1>
		<br> <br>

		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name <a href="/nameasc"><i class="fa fa-arrow-up"
							aria-hidden="true"></i> </a><a href="/namedesc"><i
							class="fa fa-arrow-down" aria-hidden="true"></i> </a></th>
					<th>Email <a href="/emailasc"><i class="fa fa-arrow-up"
							aria-hidden="true"></i> </a><a href="/emaildesc"><i
							class="fa fa-arrow-down" aria-hidden="true"></i> </a></th>
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
						<td><a href="/edit?employee_id=${employee.employeeId}"><i class="fa fa-pencil-square-o" aria-hidden="true"style="font-size:24px;color:blue"></i></a>
							<a href="/delete?employee_id=${employee.employeeId}"><i class="fa fa-trash" aria-hidden="true" style="font-size:24px;color:red"></i></a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>


</body>
</html>
</html>