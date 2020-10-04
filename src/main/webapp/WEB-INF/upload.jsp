<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 04/10/2020
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" enctype="multipart/form-data">
        <label for="addFile">Dodaj plik:
            <input type="file" name="file" id="addFile" accept="application/pdf">
        </label>
        <button type="submit">Dodaj</button>
    </form>
</body>
</html>
