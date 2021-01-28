<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jspf"%>
	<div class="container">
		<form action="forget" method="post">
			<div class="row">
				<div class="col-md-3">Please enter you emailId</div>
				<div class="col-md-9">
					<input type="text" name="emailId">
				</div>
			</div>

			<button type="submit" class="btn btn-success">Submit</button>
		</form>
		<c:choose>
				<c:when test="${password ne null}">
					<h3>Your password is ${password}</h3>
				</c:when>
				<c:otherwise>
					<h3 class="text-danger">${Wrong}</h3>
				</c:otherwise>

			</c:choose>
	</div>
</body>
</html>