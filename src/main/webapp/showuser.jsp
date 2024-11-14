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
<a href='users'> <- Go back to users list</a>
<h2>Hello ${model.name}, your phone number is: ${model.phone}!</h2>
<h3>Friends</h3>
<c:forEach items="${model.friends}" var="name">
<a href='showuser?id=${name}'>${name}</a>
<p>
    </c:forEach>

</body>
</html>