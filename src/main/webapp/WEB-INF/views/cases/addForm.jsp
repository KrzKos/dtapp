<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 03/10/2020
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="newCase" method="post">
    <spring:message code="app.patient"/> <form:input path="patientName"/><br>
    <spring:message code="app.caseTechnician"/>
<form:select path="technicianId" multiple="false">
    <form:option value="0" label=" "/>
    <form:options items="${technicians}" itemValue="id" itemLabel="fullName"/>
</form:select><br>
    <spring:message code="app.caseDeadline"/> <form:input path="deadline" type="date"/><br>
    <spring:message code="app.tooth"/> <form:input path="toothNumber" maxlength="2"/><br>
    <spring:message code="app.toothColor"/> <form:input path="toothColor"/><br>
    <spring:message code="app.note"/>
    <form:textarea path="note" cols="10" rows="5"/><br>
<input type="submit" value="<spring:message code="button.save"/>"/>

</form:form>
</body>
</html>
