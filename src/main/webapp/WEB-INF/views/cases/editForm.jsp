<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">

    <title>Title</title>
</head>
<body>

<form:form modelAttribute="caseToEdit" method="post">
    <form:errors path="patientName"/>
    <spring:message code="app.patient"/> <form:input path="patientName"/><br>
    <sec:authorize access="hasAuthority('SUPER_TECH')">
        <spring:message code="app.caseTechnician"/>
        <form:select path="technicianId" multiple="false">
            <form:option value="0" label="-- Wybierz technika --"/>
            <form:options items="${technicians}" itemValue="id" itemLabel="fullName"/>
        </form:select><br>
        <sec:csrfInput/>
    </sec:authorize>
    <spring:message code="app.caseDeadline"/> <form:input path="deadline" type="date"/><br>
    <form:errors path="toothNumber"/>
    <spring:message code="app.tooth"/> <form:input path="toothNumber" maxlength="2"/><br>
    <spring:message code="app.toothColor"/> <form:input path="toothColor"/><br>
    <spring:message code="app.prostheticType"/><form:input path="toothProstheticType"/><br>
    <spring:message code="app.note"/>
    <form:textarea path="note" cols="10" rows="5"/><br>
    <input type="submit" value="<spring:message code="button.save"/>"/>

</form:form>
</body>
</html>
