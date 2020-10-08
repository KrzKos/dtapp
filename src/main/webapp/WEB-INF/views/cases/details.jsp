<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">

    <title>Title</title>
</head>
<body>
<p><a href="/u/cases/edit/${caseById.id}">Edytuj</a></p>
<table>
    <tr>
        <th>Pacjent</th>
        <th>Data zlecenia</th>
        <th>Data do oddania</th>
        <th>Nr zęba</th>
        <th>Kolor zęba</th>
        <th>Rodzaj pracy</th>
        <th>Technik</th>
        <th>Notatka</th>
    </tr>
    <tr>
        <td>${caseById.patient}</td>
        <td>${caseById.createdOn}</td>
        <td>${caseById.deadLine}</td>
        <td>${caseById.toothNumber}</td>
        <td>${caseById.toothColor}</td>
        <td>${caseById.toothProstheticType}</td>
        <td>${caseById.technician}</td>
        <td>${caseById.note}</td>
    </tr>
</table>
<p><a href="/u/cases/delete/${caseById.id}">Usuń</a> </p>
</body>
</html>
