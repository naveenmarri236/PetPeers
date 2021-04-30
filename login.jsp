<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

logout {
	float: right;
}

li a:hover {
	background-color: #111;
}

.logoutimg {
	width: 0.5rem;
	height: 0.7rem;
}
</style>
</head>
<body>
<p id="message">${message}</p>
<ul>
	<li><a href="#PetShop">PetShop</a></li>
	<li style="float: right;"><a href="/PetUser/logout"><img class="logoutimg" src="C:\Users\marri\OneDrive\Desktop\signup.jpg"
			alt="Tutorials Point" border="0" />SignUp</a></li>
</ul>
<c:url var="user" value="/login"/>
<form:form action="${user}" method="post" modelAttribute="user">
<table>
	<tr>
		<h3>Login</h3>
	</tr>
	<tr>
		<td>Name:<form:input type="text" path="userName"/></td>
	</tr>
	<tr>
		<td>Password:<form:password path="userPassword"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="login"/></td>
	</tr>
</table>
</form:form>
</body>
</html>