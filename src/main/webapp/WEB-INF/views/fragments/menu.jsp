<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav class="navbar" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
        <a class="navbar-item" href="">
            <h1 class="title is-4">DentApp</h1>
        </a>
        <a role="button" class="navbar-burger burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
        </a>
    </div>

    <div id="navbarBasicExample" class="navbar-menu">
        <div class="navbar-start">


            <a href="/u/cases" class="navbar-item">
                Zlecenia
            </a>
            <sec:authorize access="hasAuthority('SUPER_TECH')">
            <a href="/u/tech" class="navbar-item">
                Technicy
            </a>
            </sec:authorize>

            </div>
        </div>
        <sec:authorize access="isAuthenticated()">
        <div class="navbar-end">
            <div class="navbar-item">
                Witaj, <sec:authentication property="name"/>
                        <form action="<c:url value="/logout"/>" method="post">
                            <button class="button is-link is-rounded is-small"><spring:message code="button.logout"/></button>
                            <sec:csrfInput/>
                        </form>
            </div>
        </div>
        </sec:authorize>
    </div>
</nav>

