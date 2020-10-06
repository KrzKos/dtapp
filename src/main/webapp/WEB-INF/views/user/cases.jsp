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
    <div class="columns">
        <div class="column is-half">
        </div>
        <div class="column" align="right">
            <a href="#" class="button is-round is-primary"><span class="icon is-large">
          <i class="fas fa-plus-circle" title="W trakcie"></i>
        </span>
                <span><spring:message code="button.add"/></span>
            </a>
        </div>
    </div>
    <div class="block">
        <table class="table is-striped is-narrow is-hoverable is-fullwidth is-bordered">
            <thead>
            <tr>
                <th>Lp.</th>
                <th><spring:message code="app.patientFullName" /></th>
                <th><spring:message code="app.caseReceivedTime"/></th>
                <th><spring:message code="app.caseDeadline"/> </th>
                <th><spring:message code="app.caseTechnician"/> </th>

                <th><spring:message code="app.status"/></th>
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

                <td><a href="#" class="button is-small is-info"><span class="icon is-small is-left">
            <i class="fas fa-flag" title="<spring:message code="status.active" />"></i>
          </span></a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
