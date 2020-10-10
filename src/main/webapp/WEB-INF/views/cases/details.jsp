<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">

    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/fragments/menu.jsp"/>
<section class="hero">
    <div class="hero-body">
        <div class="container">
            <h1 class="title">
                ${caseById.patient}
            </h1>
            <h2 class="subtitle">
                Termin do oddania: <strong>${caseById.deadLine}</strong>
            </h2>
        </div>
    </div>
</section>
<nav class="level">
    <!-- Left side -->
    <div class="level-left">

    </div>

    <!-- Right side -->
    <div class="level-right">
        <a href="/u/cases/edit/${caseById.id}" class="button is-success is-small">Edytuj</a>

    </div>
</nav>
<div class="container">
    <div class="columns">
        <div class="column is-one-third">

            <div class="notification is-primary is-light">
                <h5 class="subtitle is-5"><u>Notatka</u></h5>
                ${caseById.note}
            </div>
        </div>
        <div class="column">
            <div class="table">
                <table class="table is-fullwidth">
                    <tr>
                        <th>Data zlecenia</th>
                        <th>Nr zęba</th>
                        <th>Kolor zęba</th>
                        <th>Rodzaj pracy</th>
                        <th>Technik</th>
                    </tr>
                    <tr>

                        <td>${caseById.createdOn}</td>
                        <td>${caseById.toothNumber}</td>
                        <td>${caseById.toothColor}</td>
                        <td>${caseById.toothProstheticType}</td>
                        <td>${caseById.technician}</td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>

</div>
<section class="section">
    <div class="columns">
        <div class="column is-one-third">
            <c:forEach items="${comments}" var="comment">
                <article class="message is-small">
                    <div class="message-header">
                        <p>${comment.user.lastName}</p>
                            ${comment.createdOn}
                    </div>
                    <div class="message-body">
                            ${comment.text}
                    </div>
                </article>
            </c:forEach>
        </div>
        <div class="column">
            <div class="control">
                <form:form method="post" modelAttribute="comment">
                    <form:textarea cssClass="textarea" cols="10" rows="5" path="text"/>
                    <p>
                        <button class="button" type="submit">Skomentuj</button>
                    </p>
                </form:form>
            </div>

        </div>
    </div>
</section>
<section class="section">
<nav class="level m5">
    <!-- Left side -->
    <div class="level-left">

    </div>

    <!-- Right side -->
    <div class="level-right">
        <p><a href="/u/cases/delete/${caseById.id}" class="button is-danger is-small">Usuń</a> </p>
    </div>
</nav>
</section>


</body>
</html>
