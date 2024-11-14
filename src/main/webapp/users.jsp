<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2>Users list</h2>

<c:forEach items="${model}" var="user">
<div id="user" style="display: inline">
    <a href='showuser?id=${user.name}'>${user.name} - ${user.phone}</a>
    <a href="deluser?name=${user.name}"><input type="submit" value="delete"></a>
</div>
<p>
    </c:forEach>
    <br>
<form action="adduser.jsp">
    <input type="submit" value="add new user">
</form>
</body>
</html>

