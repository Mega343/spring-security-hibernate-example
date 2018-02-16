<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=utf-8" %>
<t:admin title="Найденные пациенты">
<jsp:attribute name="table">
 <table class="table table-striped">
     <thead>
     <tr>
         <th>Фамилия</th>
         <th>Имя</th>
         <th>Отчество</th>
         <th>Телефон</th>
         <th>Дата рождения</th>
         <th>Дата первого визита</th>
         <th>Лечащий врач</th>
         <th>Диагноз</th>
         <th></th>
     </tr>
     </thead>
     <tbody>
     <c:forEach var="patient" items="${patients}">
         <tr>
             <td class="col-xs-2 col-sm-2 col-md-2">
                 <p readonly="">${patient.lastName}</p>
             </td>
             <td class="col-xs-2 col-sm-2 col-md-2">
                 <p readonly="">${patient.firstName}</p>
             </td>
             <td class="col-xs-2 col-sm-2 col-md-2">
                 <p readonly="">${patient.patronymic}</p>
             </td>
             <td class="col-xs-2 col-sm-2 col-md-2">
                 <p readonly="">${patient.phoneNumber}</p>
             </td>
             <td class="col-xs-2 col-sm-2 col-md-2">
                 <p readonly="">${patient.dateOfBirth}</p>
             </td>
             <td class="col-xs-2 col-sm-2 col-md-2">
                 <p readonly="">${patient.dateOfFirstVisit}</p>
             </td>
             <td class="col-xs-2 col-sm-2 col-md-2">
                 <p readonly="">${patient.employee.lastName} ${patient.employee.firstName}</p>
             </td>
             <td class="col-xs-2 col-sm-2 col-md-2">
                 <p readonly="">${patient.diagnosis} ${patient.diagnosis}</p>
             </td>
             <td class="col-xs-2 col-sm-2 col-md-2">
                 <form action="/patients/view_patient" method="get">
                     <input type="hidden" name="patient_id" value="${patient.patientId}"/>
                     <button type="submit" class="btn btn-xs btn-info">Открыть пациента</button>
                 </form>
             </td>
         </tr>
     </c:forEach>
     </tbody>
 </table>

    </jsp:attribute>
    <jsp:attribute name="action">/dashboard</jsp:attribute>
    <jsp:attribute name="actionDescription">На главную страницу</jsp:attribute>
    <jsp:attribute name="error">${error}</jsp:attribute>
    <jsp:attribute name="informationMessage">${informationMessage}</jsp:attribute>
</t:admin>
