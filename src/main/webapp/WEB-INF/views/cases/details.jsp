<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
</body>
</html>
