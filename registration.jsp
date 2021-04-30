<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registartion</title>
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
<ul>
	<li><a href="#PetShop">PetShop</a></li>
	<li style="float: right;"><a href="/PetUser/loginuser"><img class="logoutimg" src="C:\Users\marri\OneDrive\Desktop\logout.JPG"
			alt="Tutorials Point" border="0" /> Login</a></li>
</ul>
<c:url var="user" value="/saveUser"/>
<form:form action="${user}" method="post" modelAttribute="user">
<table>
	<tr>
		<h3>Register</h3>
	</tr>
	<tr>
		<td>Name:</td>
		<td><form:input type="text" path="userName" placeholder="Enter User Name"/><font color="red"><form:errors path="userName"/></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><form:password path="userPassword" placeholder="Enter Password"/><font color="red"><form:errors path="userPassword"/></td>
	</tr>
	<tr>
		<td>Confirm Password:</td>
		<td><form:password path="confirmPassword" placeholder="ConfirmPassword"/><font color="red"><form:errors path="confirmPassword"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="Register"/>
	</tr>
</table>
</form:form>
</body>
</html>