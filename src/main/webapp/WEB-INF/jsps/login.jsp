<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


</head>
<body>
<%@ include file="header.jspf" %>
<div class="container">
		<h1>Employee Login Page</h1><br><br>
		
		<form action="authenticate" method="post">
			<div class="row">
				<div class="col-md-3">Email Id</div><div class="col-md-9"><input type="text" name="emailId"></div>
			</div>
			</br>
			<div class="row">
				<div class="col-md-3">Password</div><div class="col-md-9"><input type="text" name="password"></div>
			</div>
			
			<button type="submit" class="btn btn-success">Login</button>
		</form>
		<a href="/forgotpassword">Forgot Password</a>
	</div>
 
 
 
</div>


</body>


</body>
</html>