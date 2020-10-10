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
<jsp:include page="/WEB-INF/views/fragments/menu.jsp"/>

<section class="section">
    <div class="container">
        <div class="notification">
            Dodaj <strong>nowe zlecenie</strong>, dzięki któremu zarobisz milion monet.
        </div>
    </div>
</section>
<div class="container">
    <form:form modelAttribute="newCase" method="post">
    <div class="columns">
        <div class="column">
            <div class="field">
                <label class="label"><spring:message code="app.patient"/></label>
                <div class="control">
                    <form:input cssClass="input" path="patientName"/>
                </div>
                <form:errors path="patientName"/>
            </div>
            <sec:authorize access="hasAuthority('SUPER_TECH')">
            <div class="field">
                <label class="label"><spring:message code="app.caseTechnician"/></label>
                <div class="control">
                    <div class="select">
                    <form:select path="technicianId" multiple="false">
                        <form:option value="0" label=" "/>
                        <form:options items="${technicians}" itemValue="id" itemLabel="fullName"/>
                    </form:select>
                    </div>
                    <form:errors path="technicianId"/>
                </div>
            </div>
            </sec:authorize>

            <div class="field">
                <label class="label"><spring:message code="app.caseDeadline"/> </label>
                <div class="control">
                    <form:input cssClass="input" path="deadline" type="date"/>
                </div>
                <form:errors path="deadline"/>
            </div>

        </div>
        <div class="column">
            <div class="field">
                <label class="label"><spring:message code="app.tooth"/></label>
                <div class="control">
                    <form:input cssClass="input" path="toothNumber" maxlength="2"/>
                </div>
                <form:errors path="toothNumber"/>
            </div>

            <div class="field">
                <label class="label"><spring:message code="app.toothColor"/> </label>
                <div class="control">
                    <form:input cssClass="input" path="toothColor"/>
                </div>
                <form:errors cssClass="is-warning" path="toothColor"/>
            </div>

            <div class="field">
                <label class="label"><spring:message code="app.prostheticType"/></label>
                <div class="control">
                    <form:input cssClass="input" path="toothProstheticType"/>
                </div>
                <form:errors cssClass="is-warning" path="toothProstheticType"/>
            </div>
            <div class="field">
                <label class="label"></label>
                <div class="control">

                </div>
            </div>
            <div class="field">
                <label class="label"><spring:message code="app.note"/></label>
                <div class="control">
                    <form:textarea cssClass="textarea" path="note" cols="10" rows="5"/>
                </div>
            </div>
            <div class="control">
                <button class="button is-primary"><spring:message code="button.save"/></button>
            </div>
        </div>
    </div>
</div>





</form:form>
</body>
</html>
