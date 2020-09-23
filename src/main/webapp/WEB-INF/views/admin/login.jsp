
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">
    <title>Title</title>
</head>
<body>
<c:if test="${param['error'] != null}">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        Błędne dane logowania!
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</c:if>
<form method="post">
    <div><label><spring:message code="app.username"/>: <input type="text" name="email"/> </label></div>
    <div><label><spring:message code="app.password"/>: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="<spring:message code="button.signin">"/></div>
    <sec:csrfInput/>

</form>
</body>
</html>
