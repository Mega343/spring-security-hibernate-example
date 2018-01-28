<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=utf-8" %>
<t:admin title="Добавить Пациента">
    <jsp:attribute name="error">${error}</jsp:attribute>
<jsp:attribute name="table">
<div class="col-xs-12 col-sm-12 col-md-12">
    <form class="form-signin" action="/new_patient" method="post">
        <p style="color: red">${error}</p>
       <div class="row">
            <div class="col-xs-6 col-sm-6 col-md-6">
                <div class="form-group row">
                    <label class="col-2 col-form-label">Patient Id</label>
                    <input class="form-control input-md" type="text" name="patientId" id="patientId">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-6 col-sm-6 col-md-6">
                <div class="form-group row">
                    <label class="col-2 col-form-label">analysisName</label>
                    <input class="form-control input-md" type="text" name="analysisName" id="analysisName">
                </div>
            </div>
        </div>

        <div class="form-group row">
            <center>
                <button class="btn btn-lg btn-primary btn-block" type="submit" style="WIDTH: 235px; HEIGHT: 51px">Добавить пациента
                </button></center>
        </div>
    </form>
</div>
</jsp:attribute>
    <jsp:attribute name="action">/dashboard</jsp:attribute>
    <jsp:attribute name="actionDescription">Назад</jsp:attribute>
</t:admin>