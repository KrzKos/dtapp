<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">

    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/fragments/menu.jsp"/>
<div class="container">
    <div>
        <form:form modelAttribute="regularTech" method="post">
            <spring:message code="app.firstName"/> <form:input path="firstName"/>
            <spring:message code="app.lastName"/> <form:input path="lastName"/>
            <spring:message code="app.email"/> <form:input path="email"/>
            <spring:message code="app.phoneNumber"/> <form:input path="phoneNumber"/>
            <button type="submit"><spring:message code="button.save"/> </button>
        </form:form>
    </div>
    <div class="table">
        <table class="table">
            <tr>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Numer telefonu</th>
                <th>Email</th>
            </tr>
            <c:forEach items="${techList}" var="tech">
                <tr>
                <td>${tech.firstName}</td>
                <td>${tech.lastName}</td>
                <td>${tech.phoneNumber}</td>
                <td>${tech.email}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
