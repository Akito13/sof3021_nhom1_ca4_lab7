<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/4/2023
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<b>${uri}</b>
<c:forEach var="item" items="${loai}">
    <li>${item.tenloai}</li>
</c:forEach>
</body>
</html>
