<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">
    <title>Title</title>
</head>
<body>
<header>
    <div class="block">
        <section class="hero is-primary">
            <div class="hero-body">
                <div class="container">
                    <h1 class="title">Logowanie</h1>
                </div>
            </div>
        </section>
    </div>
</header>
<section class="section">
<div class="columns">
    <div class="column">

    </div>
    <div class="column">
    <c:if test="${param['error'] != null}">
        <div class="notification is-danger">
            Błędne dane logowania!
        </div>
    </c:if>
    <form:form method="post">
        <div class="field"><label class="label"><spring:message code="app.username"/>: <input type="text" class="input" name="email" placeholder="<spring:message code="form.yourEmail"/> "/> </label></div>
        <div class="field"><label class="label"><spring:message code="app.password"/>: <input type="password" class="input" name="password"/> </label></div>
        <div><input type="submit" class="button is-info" value="<spring:message code="button.login" />"/></div>
        <sec:csrfInput/>

    </form:form>
    </div>
    <div class="column">

    </div>
</div>
</section>
</body>
</html>
