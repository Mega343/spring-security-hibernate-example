<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=utf-8" %>
<t:admin title="Добавить Пациента">
    <jsp:attribute name="error">${error}</jsp:attribute>
    <jsp:attribute name="table">

<link rel="stylesheet" type="text/css" href="/collapse.css">
<script type="text/javascript" src="/jquery.mask.min.js"></script>
<script type="text/javascript" src="/dateMask.js"></script>
<script type="text/javascript" src="/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/blockButton.js"></script>

<div class="col-xs-12 col-sm-12 col-md-12">
    <form class="form-signin" action="/add_employee" method="post" id="add_employee_form">
        <p style="color: red">${error}</p>
        <div class="row">
            <div class="col-xs-6 col-sm-6 col-md-6">
                <div class="form-group row">
                    <label class="col-2 col-form-label required">Фамилия</label>
                    <input class="form-control input-md" type="text" name="lastName"
                           id="lastName" required="required">
                </div>
            </div>
            <div class="col-xs-6 col-sm-6 col-md-6">
                <div class="form-group row">
                    <label class="col-2 col-form-label required">Имя</label>
                    <input class="form-control input-md" type="text" name="firstName" id="firstName" required="required">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-6 col-sm-6 col-md-6">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Отчество</label>
                    <input class="form-control input-md" type="text" name="patronymic" id="patronymic">
                </div>
            </div>
            <div class="col-xs-6 col-sm-6 col-md-6">
                <div class="form-group row">
                    <label class="col-2 col-form-label required">Дата Рождения</label>
                    <input class="form-control input-md" type="text" name="dateOfBirth" id="dateOfBirth" required="required" placeholder="ДД-ММ-ГГГГ">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-6 col-sm-6 col-md-6">
                <div class="form-group row">
                    <label class="col-2 col-form-label required">Телефон</label>
                    <input class="form-control input-md" type="text" name="phoneNumber" id="phoneNumber" required="required">
                </div>
            </div>
            <div class="col-xs-6 col-sm-6 col-md-6">
                <div class="form-group row">
                    <fieldset class="form-group">
                        <label class="required">Роль</label>
                        <select class="form-control" name="role.roleID" id="role.roleID" required="required">
                            <c:forEach var="role" items="${roles}">
                                <option value="${role.roleID}"}>${role.userRole}</option>
                            </c:forEach>
                        </select>
                    </fieldset>
                </div>
            </div>
        </div>


        <div class="form-group row">
            <center>
                <button class="btn btn-lg btn-primary btn-block" type="submit" id="btn_add_patient" style="WIDTH: 235px; HEIGHT: 51px">Добавить Сотрудника
                </button></center>
        </div>
    </form>
</div>
</jsp:attribute>
    <jsp:attribute name="action">/dashboard</jsp:attribute>
    <jsp:attribute name="actionDescription">Назад</jsp:attribute>
</t:admin>
