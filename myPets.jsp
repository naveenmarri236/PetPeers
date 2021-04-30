<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Pet Page</title>
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
  <li><a class="active" href="/PetUser/myPets">My Pet</a></li>
  <li><a href="/PetUser/addPet">Add Pet</a></li>
  <li style="float: right;"><a href="/PetUser/logout">  <img class="logoutimg" src = "C:\Users\marri\OneDrive\Desktop\logout.JPG" alt = "Tutorials Point" border = "0"/> Logout</a></li>
</ul>
<table align="center",boarder="1">
  <tr>
  	<h3 class=petinfo>Pet List</h3>
  </tr>
  <tr>
  	<th>Pet ID</th>
  	<th>Pet Name</th>
  	<th>Pet Age</th>
  	<th>Pet Place</th>
  </tr>
  <c:forEach items="${pets}" var="myPets">
  <tr>
 	  <td>${myPets.petId}</td>
	  <td>${myPets.petName}</td>
	  <td>${myPets.petAge}</td>
	  <td>${myPets.petPlace}</td>
  </tr>
 </c:forEach> 
 </table>
</body>
</html>