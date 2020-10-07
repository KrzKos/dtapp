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
            <a class="navbar-item">
                Home
            </a>

            <a class="navbar-item">
                Documentation
            </a>

            <div class="navbar-item has-dropdown is-hoverable">
                <a class="navbar-link">
                    More
                </a>

                <div class="navbar-dropdown">
                    <a class="navbar-item">
                        About
                    </a>
                    <a class="navbar-item">
                        Jobs
                    </a>
                    <a class="navbar-item">
                        Contact
                    </a>
                    <hr class="navbar-divider">
                    <a class="navbar-item">
                        Report an issue
                    </a>
                </div>
            </div>
        </div>
        <div class="navbar-end">
            <div class="navbar-item">
                <div class="buttons">
                    <a href="/register" class="button is-primary">
                        <strong><spring:message code="button.signIn"/></strong>
                    </a>
                    <a href="/login" class="button is-light">
                        Log in
                    </a>
                </div>
            </div>
        </div>
        <sec:authorize access="isAuthenticated()">
        <div class="navbar-end">
            <div class="navbar-item">
                <p>Witaj, <sec:authentication property="name"/></p>
                <div class="control">
                        <form action="<c:url value="/logout"/>" method="post">
                            <button class="button is-primary"><spring:message code="button.logout"/></button>
                            <sec:csrfInput/>
                        </form>
                </div>
            </div>
        </div>
        </sec:authorize>
    </div>
</nav>

