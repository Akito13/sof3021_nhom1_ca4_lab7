<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/4/2023
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Send Mail</title>
    <style>
        .flex {
            display: flex;
        }
    </style>
</head>
<body\\\\\\\\\\\\\\\\\\\
    <h3>${message}</h3>
    <form:form method="post" enctype="multipart/form-data" action="/mail/send" modelAttribute="sender">
        <div class="flex">
            <form:label path="from">Form:</form:label>
            <form:input path="from" />
        </div>
        <div class="flex">
            <form:label path="to">To:</form:label>
            <form:input path="to" />
        </div>
        <div class="flex">
            <form:label path="cc">CC:</form:label>
            <form:input path="cc" />
        </div>
        <div class="flex">
            <form:label path="bcc">BCC:</form:label>
            <form:input path="bcc" />
        </div>
        <div class="flex">
            <form:label path="subject">Subject:</form:label>
            <form:input path="subject" />
        </div>
        <div class="flex">
            <form:label path="body">Body:</form:label>
            <form:textarea path="body" />
        </div>
        <div class="flex">
            <form:label path="">Attachments:</form:label>
            <input name="attachments" type="file" multiple="multiple"/>
        </div>
        <form:button>Send</form:button>
    </form:form>
</body>
</html>
