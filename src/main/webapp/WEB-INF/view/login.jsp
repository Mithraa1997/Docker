<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>DOCKER</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
.error {
	color: red
}

form {
	width: 300px;
	height: 600px;
	margin: 0 auto;
}

h2 {
	text-align: center;
	padding: 20px;
}
table {
  border: 1px solid black;
  border-collapse: separate;
  border-spacing: 15px;
}

.button {
	background-color: blue;
	border: none;
	color: white;
	padding: 10px 24px;
	text-align: center;
	text-decoration: none;
	font-size: 1p4x;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
</head> 
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Docker</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Home</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/login"><span
						class="glyphicon glyphicon-log-in"></span>Login</a></li>
			</ul>
		</div>
	</nav>
	<h2>Login</h2>
	<c:if test="${not empty failed}">
		<div align ="center" style="padding: 20px;">
			<font color="red">${failed}</font>
		</div>
	</c:if>
	<form:form id="myForm" action="home" modelAttribute="loginModel">
		<table>
			<tr>
				<td>Email:</td>
				<td><form:input path="emailId" size="30" /> <form:errors
						path="emailId" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" size="30" /> <form:errors
						path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" class="button" value="login" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>