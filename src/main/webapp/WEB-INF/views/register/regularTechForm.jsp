<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">

    <title>Title</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/fragments/menu.jsp"/>
<section class="hero is-dark mb-3">
    <div class="hero-body">
        <div class="container">
            <h1 class="title">
                Technicy
            </h1>
            <h2 class="subtitle">
                Zarządzaj swoim teamem
            </h2>
        </div>
    </div>
</section>
<div class="container is-widescreen">
    <div class="columns">
        <div class="column is-two-fifths">
            <div class="box">
                <h3 class="subtitle is-3">Dodaj technika do teamu</h3>
                <form:form modelAttribute="regularTech" method="post">
                <div class="field">
                    <label class="label"><spring:message code="app.firstName"/></label>
                    <div class="controll">
                        <form:input cssClass="input is-small" path="firstName"/>
                    </div>
                </div>
                <div class="field">
                    <label class="label"><spring:message code="app.lastName"/> </label>
                    <div class="controll">
                        <form:input cssClass="input is-small" path="lastName"/>
                    </div>
                </div>
                <div class="field">
                    <label class="label"><spring:message code="app.email"/></label>
                    <div class="controll">
                        <form:input cssClass="input is-small" path="email"/>
                    </div>
                </div>
                <div class="field">
                    <label class="label"><spring:message code="app.phoneNumber"/> </label>
                    <div class="controll">
                        <form:input cssClass="input" path="phoneNumber"/>
                    </div>
                </div>
                <button class="button is-info" type="submit"><spring:message code="button.save"/></button>
            </div>
            </form:form>
            </div>

        <div class="column is-full is-info is-light">
            <div class="table is-fullwidth">
                <table class="table is-striped is-hoverable">
                    <tr>
                        <th>Imię</th>
                        <th>Nazwisko</th>
                        <th>Numer telefonu</th>
                        <th>Email</th>
                        <th>Prace</th>
                        <th>Akcje</th>
                    </tr>
                    <c:forEach items="${techList}" var="tech">
                        <tr>
                            <td>${tech.firstName}</td>
                            <td>${tech.lastName}</td>
                            <td>${tech.phoneNumber}</td>
                            <td>${tech.email}</td>
                            <td>${tech.casesNumber}</td>
                            <td>
                                <c:if test="${tech.active == 'true'}"><a class="button is-warning is-small" href="/u/tech/active/disable/${tech.id}">Dezaktywuj</a></c:if>
                                <c:if test="${tech.active == 'false'}"><a class="button is-success is-small" href="/u/tech/active/enable/${tech.id}">Aktywuj</a></c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>

</div>


</div>

</body>
</html>
