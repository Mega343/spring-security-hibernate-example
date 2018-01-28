<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="">
    <meta name="author" content="Arthur Segeda">
    <link rel="icon" href="/icon.jpg">

    <title>Медицинский центр</title>

    <!-- Bootstrap core CSS -->
    <link href="/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/signin.css" rel="stylesheet">

</head>

<body>

<div class="container">
    <img src="/icon.jpg" alt="Red Cross" class="center-block">
    <form class="form-signin" action="/login" method="post">
        <h2 class="form-signin-heading">Войдите в систему</h2>
        <label for="username" class="sr-only">Логин</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Логин" required
               autofocus>
        <label for="pwd" class="sr-only">Пароль</label>
        <input type="password" id="pwd" name="password" class="form-control" placeholder="Пароль" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
        <c:if test="${param.error ne null}">
            <div style="color: red">Неправильный логин или пароль.</div>
        </c:if>
    </form>
    <form class="form-signin" action="add_user" method="get">
        <button class="btn btn-lg btn-success btn-block" type="submit">Забыли пароль</button>
    </form>
</div>

<!-- Bootstrap core JavaScript================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="/bootstrap.min.js"></script>
</body>
</html>
