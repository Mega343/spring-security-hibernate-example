<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=utf-8" %>
<t:admin title="Редактировать пациента - ${patient.lastName} ${patient.firstName} ">
<jsp:attribute name="table">

<script type="text/javascript" src="/dateMask.js"></script>


<c:set var="selectedRoleId" value="${selectedRoleId}"/>
<div class="col-xs-12 col-sm-12 col-md-12">
    <form class="form-signin" action="/update_employee" method="post">
        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary required">Фамилия</label>
                    <input class="form-control input-md" type="text" name="lastName" value="${employee.lastName}"
                           id="lastName" required="required">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary required">Имя</label>
                    <input class="form-control input-md" type="text" name="firstName" value="${employee.firstName}"
                           id="firstName" required="required">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary">Отчество</label>
                    <input class="form-control input-md" type="text" name="patronymic" value="${employee.patronymic}"
                           id="patronymic">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary required">Телефон</label>
                    <input class="form-control input-md" type="text" name="phoneNumber" value="${employee.phoneNumber}"
                           id="phoneNumber" required="required">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary required">Дата Рождения</label>
                    <input class="form-control input-md" type="text" name="dateOfBirth" value="${employee.dateOfBirth}"
                           id="dateOfBirth" required placeholder="ДД-ММ-ГГГГ">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary">Логин</label>
                    <input class="form-control input-md" type="text" name="login" value="${employee.login}"
                           id="login">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <fieldset class="form-group">
                        <label class="required">Роль</label>
                        <select class="form-control" name="role.roleID" id="role.roleID" required="required">
                            <c:forEach var="role" items="${roles}">
                                <option value="${role.roleID}" ${(role.roleID == selectedRoleId)?"selected":""}>${role.userRole}</option>
                            </c:forEach>
                        </select>
                    </fieldset>
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary">E-mail</label>
                    <input class="form-control input-md" type="text" name="email" value="${employee.email}"
                           id="email">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <input class="form-control input-md" name="employeeId" value="${employee.employeeId}"
                       id="employeeId" type="hidden">

            </div>
        </div>

        <div class="form-group row">
            <center>
                <button class="btn btn-lg btn-primary btn-block" type="submit" style="WIDTH: 235px; HEIGHT: 51px">
                    Сохранить изменения
                </button>
            </center>
        </div>
    </form>
</div>

    </jsp:attribute>
    <jsp:attribute name="action">/dashboard</jsp:attribute>
    <jsp:attribute name="actionDescription">На главную страницу</jsp:attribute>
    <jsp:attribute name="error">${error}</jsp:attribute>
    <jsp:attribute name="informationMessage">${informationMessage}</jsp:attribute>
</t:admin>