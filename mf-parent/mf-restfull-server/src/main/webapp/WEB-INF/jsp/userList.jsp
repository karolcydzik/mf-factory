<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User list</title>
</head>
<body>
    <a href="/mf-restfull-server">Return to the main page.</a>
    <br> this is user List
    <table border=1>
        <thead>
            <tr>
                <th>Id</th>
                <th>Nick</th>
                <th>Email</th>
                <th>Password</th>
            </tr>
        </thead>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.nick}</td>
                <td>${user.email}</td>
                <td>${user.passwordHash}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>