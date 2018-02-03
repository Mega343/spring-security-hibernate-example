<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=utf-8" %>
<t:admin title="Информация о пациенте - ${patient.lastName} ${patient.firstName} ">
<jsp:attribute name="table">
<link rel="stylesheet" type="text/css" href="/collapse.css">
<link rel="stylesheet" type="text/css" href="/fileUpload.css">

<script type="text/javascript" src="/dateMask.js"></script>
<script type="text/javascript" src="/accordeon.js"></script>
<script type="text/javascript" src="/fileUpload.js"></script>
<script type="text/javascript" src="/openImages.js"></script>

<div class="col-xs-12 col-sm-12 col-md-12">
        <div class="row">
            <div class="col-xs-3 col-sm-3 col-md-3">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary">Фамилия</label>
                    <p class="text-danger" readonly="">${patient.lastName}</p>
                </div>
            </div>
            <div class="col-xs-3 col-sm-3 col-md-3">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary">Имя</label>
                    <p class="text-danger" readonly="">${patient.firstName}</p>
                </div>
            </div>
            <div class="col-xs-3 col-sm-3 col-md-3">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary">Отчество</label>
                    <p class="text-danger" readonly="">${patient.patronymic}</p>
                </div>
            </div>
            <div class="col-xs-3 col-sm-3 col-md-3">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary">Телефон</label>
                    <p class="text-danger" readonly="">${patient.phoneNumber}</p>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-3 col-sm-3 col-md-3">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary">Дата Рождения</label>
                    <p class="text-danger" readonly="">${patient.dateOfBirth}</p>
                </div>
            </div>
            <div class="col-xs-3 col-sm-3 col-md-3">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary">Дата первого визита</label>
                    <p class="text-danger" readonly="">${patient.dateOfFirstVisit}</p>
                </div>
            </div>
            <div class="col-xs-3 col-sm-3 col-md-3">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary">Лечащий врач</label>
                    <p class="text-danger" readonly="">${employee.lastName} ${employee.firstName}</p>
                </div>
            </div>
            <div class="col-xs-3 col-sm-3 col-md-3">
                <div class="form-group row">
                    <label class="col-2 col-form-label text-primary">Диагноз</label>
                    <p class="text-danger" readonly="">${patient.diagnosis}</p>
                </div>
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
                    <div class="panel-body">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>Название анализа</th>
                                <th>Дата</th>
                                <th>Анализ</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="analysis" items="${analysis}">
                            <tr>
                                <td class="col-xs-8 col-sm-8 col-md-8">
                                    <p readonly="">${analysis.analysisName}</p>
                                </td>
                                <td class="col-xs-2 col-sm-2 col-md-2">
                                    <p readonly="">${analysis.analysisDate}</p>
                                </td>
                                <td class="col-xs-2 col-sm-2 col-md-2">
                                        <input type="button"  class="btn btn-xs btn-warning" value="Открыть анализ"
                                               id="analysis_button" onclick="openAnalysis(${analysis.analysisId})" />
                                </td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="form-group row">
                        <center>
                            <button type="button" class="btn btn-xs btn-warning" data-toggle="modal" data-target="#addAnalysis">Добавить анализ</button>
                        </center>
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
                            <c:forEach var="appointment" items="${appointments}">
                                <tr>
                                    <td class="col-xs-8 col-sm-8 col-md-8">
                                        <p readonly="">${appointment.appointmentsName}</p>
                                    </td>
                                    <td class="col-xs-2 col-sm-2 col-md-2">
                                        <p readonly="">${appointment.appointmentsDate}</p>
                                    </td>
                                    <td class="col-xs-2 col-sm-2 col-md-2">
                                        <input type="button"  class="btn btn-xs btn-warning" value="Открыть назначение"
                                               id="appointments_button" onclick="openAppointments(${appointment.appointmentsId})" />
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="form-group row">
                        <center>
                            <button type="button" class="btn btn-xs btn-warning" data-toggle="modal" data-target="#addAppointments">Добавить назначение</button>
                        </center>
                    </div>
                </div>
            </div>
        </div>

    <div class="form-group row">
        <center>
            <form action="/edit_patient" method="get">
                <input type="hidden" name="patientId" value="${patient.patientId}"/>
                <button class="btn btn-lg btn-primary btn-block" type="submit" style="WIDTH: 235px; HEIGHT: 51px">
                    Редактировать пациента
                </button>
            </form>
        </center>
    </div>

    <%@ include file="addAnalysis.jsp"%>
    <%@ include file="addAppointments.jsp"%>

    </jsp:attribute>
    <jsp:attribute name="action">/dashboard</jsp:attribute>
    <jsp:attribute name="actionDescription">На главную страницу</jsp:attribute>
    <jsp:attribute name="error">${error}</jsp:attribute>
    <jsp:attribute name="informationMessage">${informationMessage}</jsp:attribute>
</t:admin>