<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employees</title>
</head>
<body>
	<a href="/mf-restfull-server">Return to the main page.</a>
	<br> this is new form
	<table border=1>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
			</tr>
		</thead>
		<tr>
			<td>${newCity.id}</td>
			<td>${newCity.name}</td>
			<td>${newCity.ord}</td>
		</tr>
	</table>

	<c:url var="addAction" value="mpfactory/hello/newCity"></c:url>

	<form action="addAction" method="get">
		<br>id:<input type="text" name="id" value = ${newCity.id}> 
		<br>name:<input type="text" name="name" value = ${newCity.name}> 
		<br>ord:<input type="text" name="ord" value = ${newCity.ord}>
		<br><input type="submit">
	</form>

	<p>this is new page</p>
</body>
</html>