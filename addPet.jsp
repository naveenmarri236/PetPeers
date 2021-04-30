<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pet Details</title>
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

.petinfo {
background-color: LightGray;
text-align: center;
}
</style>
</head>
<body>
<ul>
  <li><a href="/PetUser/home">PetShop</a></li>
  <li><a href="/PetUser/home">Home</a></li>
  <li><a href="/PetUser/myPets">My Pet</a></li>
  <li><a class="active" href="/PetUser/addPet">Add Pet</a></li>
  <li style="float: right;"><a href="/PetUser/logout">  <img class="logoutimg" src = "C:\Users\marri\OneDrive\Desktop\logout.JPG" alt = "Tutorials Point" border = "0"/> Logout</a></li>
</ul>
<c:url var="addPet" value="/savePet"/>
<form:form action="${addPet}" method="post" modelAttribute="addPet">
<table align="center">
<tr>
 	 <h3 class="petinfo">Pet Information</h3>
  </tr>
 <tr>
	<td>Pet Id:</td>
	
	<td><form:input type="text" path="petId"/><font color="red"><form:errors path="petId"/></td>
 </tr>
 <tr>
 	<td>Pet Name:</td>
 	<td><form:input type="text" path="petName"/><font color="red"><form:errors path="petName"/></td>
 </tr>
 <tr>
 	<td>Pet Age:</td>
 	<td><form:input type="text" path="petAge"/><font color="red"><form:errors path="petAge"/></td>
 </tr>
 <tr>
 	<td>Pet Place:</td>
 	<td><form:input type="text" path="petPlace"/><font color="red"><form:errors path="petPlace"/></td>
 </tr>
 <tr>
 	<td><input type="submit" value="addPet"/></td>
 </tr>
</table>
</form:form>
</body>
</html>