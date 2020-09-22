<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 21/09/2020
  Time: 08:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">
    <title>Title</title>
</head>
<body>
<section class="section">
    <form:form modelAttribute="technicianRegistration" method="post">
        <div class="columns is-mobile is-centered">

            <div class="column is-half">
                <div>
                    <h1 class="title is-3">Rejestracja użytkownika</h1>
                    <h2 class="subtitle is-4">Podaj wymagane dane</h2>
                </div>
                <div class="field">
                    <div class="columns">
                        <div class="column">
                            <div class="field">
                                <label class="label">Imię</label>
                                <div class="control has-icons-left has-icons-right">
                                    <form:input path="firstName" class="input is-success" type="text" placeholder="Text input" value="bulma"/>
                                    <span class="icon is-small is-left">
                                     <i class="fas fa-user"></i>
                                     </span>
                                    <span class="icon is-small is-right">
                                    <i class="fa fa-check"></i>
                                    </span>
                                </div>
                                <p class="help">This username is available</p>
                            </div>
                        </div>
                        <div class="column">
                            <div class="field">
                                <label class="label">Nazwisko</label>
                                <div class="control has-icons-left has-icons-right">
                                    <form:input path="lastName" class="input is-success" type="text" placeholder="Text inpu"/>
                                    <span class="icon is-small is-left">
                                        <i class="fas fa-user"></i>
                                    </span>
                                    <span class="icon is-small is-right">
                                        <i class="fa fa-check"></i>
                                    </span>
                                </div>
                                <p class="help is-success">This username is available</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="field">
                    <label class="label">Email</label>
                    <div class="control has-icons-left has-icons-right">
                        <form:input path="email" class="input is-danger" type="email" placeholder="Email input" value="hello@"/>
                        <span class="icon is-small is-left">
                            <i class="fas fa-envelope"></i>
                        </span>
                        <span class="icon is-small is-right">
                            <i class="fas fa-exclamation-triangle"></i>
                        </span>
                    </div>
                    <p class="help is-danger">This email is invalid</p>
                </div>
                <div class="field">
                    <label class="label">Hasło</label>
                    <div class="control has-icons-left has-icons-right">
                        <form:input path="password" class="input" type="password"/>
                        <span class="icon is-small is-left">
                            <i class="fas fa-locker"></i>
                        </span>
                        <span class="icon is-small is-right">
                            <i class="fa fa-check"></i>
                        </span>
                    </div>
                    <p class="help is-success">This username is available</p>
                </div>
                <div class="field">
                    <label class="label">Nazwa laboratorium</label>
                    <div class="control">
                        <form:input path="labName" class="input" type="text" placeholder="Text input"/>
                    </div>
                </div>
                <div class="field">
                    <label class="label">Nip</label>
                    <div class="control">
                        <form:input path="labTaxNumber" class="input"/>
                    </div>
                </div>
                <div class="field">
                    <label class="label">Adres</label>
                    <div class="columns">
                        <div class="column is-half">
                            <div class="field">
                                <p class="control is-expanded has-icons-left">
                                    <form:input path="labStreet" class="input" type="text" placeholder="Ulica"/>
                                    <span class="icon is-small is-left">
                                        <i class="fas fa-building"></i>
                                    </span>
                                </p>
                            </div>
                        </div>
                        <div class="column is-one-fourth">
                            <div class="field">
                                <p class="control is-expanded">
                                    <form:input path="labStreetNumber" class="input is-half" type="text" placeholder="Nr."/>
                                </p>
                            </div>
                        </div>

                        <div class="column is-one-fourth">
                            <div class="field">
                                <p class="control is-expanded">
                                    <form:input path="labLocalNumber" class="input is-half" type="text" placeholder="Lok."/>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="field">
                    <div class="control">
                        <label class="checkbox">
                            <input type="checkbox">
                            I agree to the <a href="#">terms and conditions</a>
                        </label>
                    </div>
                </div>

                <div class="field is-grouped is-grouped-centered">
                    <div class="control">
                        <button type="submit" class="button is-link">Zakładama konto</button>
                    </div>
                    <div class="control">
                        <button class="button is-link is-light">Rezygnuję</button>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</section>
</body>
</html>
