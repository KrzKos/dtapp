<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 07/10/2020
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/security/tags"
          prefix ="security" %>
<html>
<head>

    <security:csrfMetaTags />
    <title>Title</title>
</head>
<body>
    <form:form method="post">
        <button type="submit">Potwierdź</button>
        <security:csrfInput/>
    </form:form>
</body>
</html>
