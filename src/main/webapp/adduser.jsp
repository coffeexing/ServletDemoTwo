<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>add a user.</title>
</head>
<body >
<form action="AddUserServlet" method="post" style="padding-top:-700px;">
    name:<input name="name" type="text"><br><br>
    phone:<input name="phone" type="text"><br><br>
    friends:<input name="friends" type="text"><br><br>
    <input type="submit" value="submit">
</form>
</body>
</html>
