<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 04/10/2020
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Galeria plików</title>
</head>
<body>
    <c:forEach items="${files}" var="file">
        <img src="/files/${file.id}">
    </c:forEach>
</body>
</html>
