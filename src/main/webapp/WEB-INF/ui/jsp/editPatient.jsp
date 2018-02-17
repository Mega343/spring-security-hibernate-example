<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=utf-8" %>
<t:admin title="Редактировать пациента - ${patient.lastName} ${patient.firstName} ">
<jsp:attribute name="table">
<link rel="stylesheet" type="text/css" href="/collapse.css">
<link rel="stylesheet" type="text/css" href="/fileUpload.css">

<script type="text/javascript" src="/dateMask.js"></script>
<script type="text/javascript" src="/accordeon.js"></script>
<script type="text/javascript" src="/fileUpload.js"></script>
<script type="text/javascript" src="/openImages.js"></script>

<c:set var="selectedEmployeeId" value="${selectedEmployeeId}"/>

<div class="col-xs-12 col-sm-12 col-md-12">
    <form class="form-signin" action="/patients/update_patient" method="post">
        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary required">Фамилия</label>
                    <input class="form-control input-md" type="text" name="lastName" value="${patient.lastName}"
                           id="lastName" required="required">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary required">Имя</label>
                    <input class="form-control input-md" type="text" name="firstName" value="${patient.firstName}"
                           id="firstName" required="required">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary">Отчество</label>
                    <input class="form-control input-md" type="text" name="patronymic" value="${patient.patronymic}"
                           id="patronymic">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                    <div class="form-group row">
                        <label class="col-2 col-form-label text-primary required">Телефон</label>
                        <input class="form-control input-md" type="text" name="phoneNumber" value="${patient.phoneNumber}"
                               id="phoneNumber" required="required">
                    </div>
                </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary required">Дата Рождения</label>
                    <input class="form-control input-md" type="text" name="dateOfBirth" value="${patient.dateOfBirth}"
                           id="dateOfBirth" required="required" placeholder="ДД-ММ-ГГГГ">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary required">Дата первого визита</label>
                    <input class="form-control input-md" type="text" name="dateOfFirstVisit" value="${patient.dateOfFirstVisit}"
                           id="dateOfFirstVisit" required="required" placeholder="ДД-ММ-ГГГГ">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <fieldset class="form-group">
                        <label class="required">Лечащий врач</label>
                        <select class="form-control" name="employee.employeeId" id="employee.employeeId" required="required">
                            <c:forEach var="employee" items="${employees}">
                                <option value="${employee.employeeId}" ${(employee.employeeId == selectedEmployeeId)?"selected":""}>${employee.lastName} ${employee.firstName}</option>
                            </c:forEach>
                        </select>
                    </fieldset>
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary">Диагноз</label>
                    <input class="form-control input-md" type="text" name="diagnosis" value="${patient.diagnosis}"
                           id="diagnosis">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4">
                <input class="form-control input-md" name="patientId" value="${patient.patientId}"
                           id="patientId" type="hidden">

            </div>
        </div>

        <div class="container">
            <div class="accordion-option">
                <a href="javascript:void(0)" class="toggle-accordion active" accordion-id="#accordion"></a>
            </div>
        </div>

        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingOne">
                    <h4 class="panel-title">
                        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                           aria-expanded="true" aria-controls="collapseOne">
                            Анализы
                        </a>
                    </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel"
                     aria-labelledby="headingOne">
                    <td class="panel-body">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>Название анализа</th>
                                <th>Дата</th>
                                <th>Анализ</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="analysis" items="${analysis}" varStatus="loop">
                                <tr>
                                    <td class="col-xs-8 col-sm-8 col-md-8">
                                        <input class="form-control input-md" type="text" name="analysis[${loop.index}].analysisName" value="${analysis.analysisName}" readonly>
                                    </td>
                                    <td class="col-xs-2 col-sm-2 col-md-2">
                                        <input class="form-control input-md" type="text" name="analysis[${loop.index}].analysisDate" value="${analysis.analysisDate}" readonly>
                                    </td>
                                    <td class="col-xs-2 col-sm-2 col-md-2">
                                        <input type="button"  class="btn btn-xs btn-warning" value="Открыть анализ"
                                               id="analysis_button" onclick="openAnalysis(${analysis.analysisId})" />
                                    </td>
                                    <td>
                                        <input class="form-control input-md" name="analysis[${loop.index}].analysisId" value="${analysis.analysisId}"
                                               id="analysisId" type="hidden">
                                    </td>
                                    <td>
                                        <input class="form-control input-md" name="analysis[${loop.index}].patientId" value="${analysis.patientId}" type="hidden">
                                    </td>
                                </tr>

                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingTwo">
                    <h4 class="panel-title">
                        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                           href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                            Назначения
                        </a>
                    </h4>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse in" role="tabpanel"
                     aria-labelledby="headingTwo">
                    <div class="panel-body">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>Название назначения</th>
                                <th>Дата</th>
                                <th>Назначение</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="appointments" items="${appointments}" varStatus="loop">
                                <tr>
                                    <td class="col-xs-8 col-sm-8 col-md-8">
                                        <input class="form-control input-md" type="text" name="appointments[${loop.index}].appointmentsName" value="${appointments.appointmentsName}" readonly>
                                    </td>
                                    <td class="col-xs-2 col-sm-2 col-md-2">
                                        <input class="form-control input-md" type="text" name="appointments[${loop.index}].appointmentsDate" value="${appointments.appointmentsDate}" readonly>
                                    </td>
                                    <td class="col-xs-2 col-sm-2 col-md-2">
                                        <input type="button"  class="btn btn-xs btn-warning" value="Открыть назначение"
                                               id="appointments_button" onclick="openAppointments(${appointments.appointmentsId})" />
                                    </td>
                                    <td>
                                        <input class="form-control input-md" name="appointments[${loop.index}].appointmentsId" value="${appointments.appointmentsId}"
                                               id="appointmentsId" type="hidden">

                                    </td>
                                    <td>
                                        <input class="form-control input-md" name="appointments[${loop.index}].patientId" value="${appointments.patientId}" type="hidden">
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
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
    <%@ include file="addAnalysis.jsp"%>
    <%@ include file="addAppointments.jsp"%>

    </jsp:attribute>
    <jsp:attribute name="action">/dashboard</jsp:attribute>
    <jsp:attribute name="actionDescription">На главную страницу</jsp:attribute>
    <jsp:attribute name="error">${error}</jsp:attribute>
    <jsp:attribute name="informationMessage">${informationMessage}</jsp:attribute>
</t:admin>