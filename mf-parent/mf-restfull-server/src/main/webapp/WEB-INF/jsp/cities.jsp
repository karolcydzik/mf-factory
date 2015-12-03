<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employees</title>
</head>
<body>
    <a href="/mf-restfull-server">Return to the main page.</a>
    <table border=1>
        <br> this is from cities</br>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
            </tr>
        </thead>
        <c:forEach var="city" items="${cities.cities}">
            <tr>
                <td>${city.id}</td>
                <td>${city.name}</td>
                <td>${city.ord}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>