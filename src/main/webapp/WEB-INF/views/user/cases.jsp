<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <span>Dodaj</span>
            </a>
        </div>
    </div>
    <div class="block">
        <table class="table is-striped is-narrow is-hoverable is-fullwidth is-bordered">
            <thead>
            <tr>
                <th>Id</th>
                <th>Imie i nazwisko pacjenta</th>
                <th>Data przyjęcia pracy</th>
                <th>Termin oddania</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${cases}" var="case">
            <tr>
                <td>${case.id}</td>
                <td>${case.patientName}</td>
                <td>${case.orderTime}</td>
                <td>${case.deadline}</td>
                <td><a href="#" class="button is-small is-info"><span class="icon is-small is-left">
            <i class="fas fa-flag" title="W trakcie"></i>
          </span></a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
