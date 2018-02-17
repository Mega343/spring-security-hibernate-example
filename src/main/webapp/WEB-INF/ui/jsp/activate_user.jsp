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
	<p><a href="/login"><img src="/icon.jpg" alt="Red Cross" class="center-block"></a></p>
	<form class="form-signin" action="/activate_user" method="post">
		<h3 class="form-signin-heading">Введите свои данные для продолжения активации в системе</h3>
		<label for="lastName" class="sr-only">Фамилия</label>
		<input type="text" id="lastName" name="lastName" class="form-control" placeholder="Фамилия" required
			   autofocus>
		<label for="firstName" class="sr-only">Имя</label>
		<input type="text" id="firstName" name="firstName" class="form-control" placeholder="Имя" required>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Далее</button>
		<input type="hidden" name="${_csrf.parameterName}"
			   value="${_csrf.token}" />
		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>
	</form>
</div>

<!-- Bootstrap core JavaScript================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="/bootstrap.min.js"></script>
</body>
</html>
