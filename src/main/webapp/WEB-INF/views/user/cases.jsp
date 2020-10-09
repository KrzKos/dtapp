<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">

    <title>Title</title>
</head>
<body>
<c:import url="/WEB-INF/views/fragments/menu.jsp"/>



<div class="section">
    <nav class="level">
        <!-- Left side -->
        <div class="level-left">

            <div class="level-item">
                <form method="get" action="/u/cases/search">
                    <div class="field has-addons">
                        <p class="control">
                            <input class="input" name="name" type="text" placeholder="Szukaj pacjenta">
                        </p>
                        <p class="control">
                            <button class="button" type="submit">
                                Szukaj
                            </button>
                        </p>
                    </div>
                </form>
            </div>
        </div>

        <!-- Right side -->
        <div class="level-right">
            <p class="level-item"><a href="/u/cases/add" class="button is-round is-primary"><span class="icon is-large">
          <i class="fas fa-plus-circle" title="Dodaj"></i>
        </span>
                <span><spring:message code="button.add"/></span>
            </a></p>
        </div>
    </nav>

    <div class="block">
        <table class="table is-striped is-narrow is-hoverable is-fullwidth is-bordered">
            <thead>
            <tr>
                <th>Lp.</th>
                <th><spring:message code="app.patientFullName"/></th>
                <th><spring:message code="app.caseReceivedTime"/></th>
                <th><spring:message code="app.caseDeadline"/></th>
                <th><spring:message code="app.caseTechnician"/></th>

                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${cases}" var="case" varStatus="lp">
                <tr>
                    <td>${lp.index + 1}</td>
                    <td>${case.patientName}</td>
                    <td>${case.orderTime}</td>
                    <td>${case.deadline}</td>
                    <td>${case.technicianFullName}</td>

                    <td>

                        <a href="/u/cases/detail/${case.id}" class="button is-small is-light">
                            szczegóły
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:if test="${emptyResult == 0}">
            <div class="constainer">
                <strong>Nie znaleziono pacjenta o podanej nazwie</strong>
            </div>
        </c:if>

    </div>
</div>
</body>
</html>
