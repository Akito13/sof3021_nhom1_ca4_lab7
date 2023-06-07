
<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/7/2023
  Time: 5:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>LOGIN</h3>
<b><i>${message}${param.error }</i></b>
<form action="${pageContext.request.contextPath}/account/login" method="post">

    <label>
        <input name="username" placeholder="Username?">
    </label>
    <label>
        <input name="password" placeholder="Password?">
    </label>
    <button>Login</button>
</form>
</body>
</html>
