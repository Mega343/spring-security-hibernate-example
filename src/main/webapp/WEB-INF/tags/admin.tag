<%@tag pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@attribute name="title" %>
<%@attribute name="tableName" %>
<%@attribute name="action" %>
<%@attribute name="actionDescription" %>
<%@attribute name="error" %>
<%@attribute name="informationMessage" %>
<%@attribute name="helpimage" %>
<%@attribute name="table" fragment="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="Arthur Segeda" content="">
    <link rel="icon" href="/icon.jpg">

    <title>${title}</title>

    <!-- Bootstrap core CSS -->
    <link href="/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href="/styles.css">
    <script type="text/javascript" src="/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/jquery.mask.min.js"></script>
    <script type="text/javascript" src="/jquery-ui.js"></script>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">

            <a class="navbar-brand" href="/dashboard">Медицинский центр</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/spec_search">Расширенный поиск</a></li>
                <li><a href="/office">Личный кабинет</a></li>
                <li><a href="/logout">Выйти</a></li>
            </ul>
            <form class="navbar-form navbar-right" action="/search" method="post">
                <input type="text" class="form-control" placeholder="Поиск..." name="search" id="search">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="/dashboard">Пациенты <span class="sr-only">(current)</span></a></li>
                <li><a href="/employees">Сотрудники</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <form class="form-signin" action="${action}" method="get">
                <button class="btn btn-lg btn-success btn-block left-button" type="submit" style="WIDTH: 235px; HEIGHT: 51px">
                    ${actionDescription}
                </button>
                ${helpimage}
            </form>
            <div class="text-center">
                <c:if test="${not empty informationMessage}">
                    <div class="error" style="color: #008000">${informationMessage}</div>
                </c:if>
            </div>
            <div class="text-center">
                <c:if test="${not empty error}">
                    <div class="error" style="color: red">${error}</div>
                </c:if>
            </div>
            <h1 class="page-header">${tableName}</h1>
            <div class="table-responsive">
                    <jsp:invoke fragment="table"/>
            </div>
        </div>
    </div>
</div>


<!-- Bootstrap core JavaScript================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/bootstrap.min.js"></script>
</body>
</html>