<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=utf-8" %>
<t:admin title="Список сотрудников">
<jsp:attribute name="table">
 <table class="table table-striped">
     <thead>
     <tr>
         <th>Фамилия</th>
         <th>Имя</th>
         <th>Отчество</th>
         <th>Телефон</th>
         <th>Дата рождения</th>
         <th>Логин</th>
         <th>E-mail</th>
         <th>Роль</th>
         <th></th>
         <th></th>
     </tr>
     </thead>
     <tbody>
     <c:forEach var="employee" items="${employees}">
         <tr>
             <td class="col-xs-2 col-sm-2 col-md-2">
                 <p readonly="">${employee.lastName}</p>
             </td>
             <td class="col-xs-2 col-sm-2 col-md-2">
                 <p readonly="">${employee.firstName}</p>
             </td>
             <td class="col-xs-2 col-sm-2 col-md-2">
                 <p readonly="">${employee.patronymic}</p>
             </td>
             <td class="col-xs-2 col-sm-2 col-md-2">
                 <p readonly="">${employee.phoneNumber}</p>
             </td>
             <td class="col-xs-2 col-sm-2 col-md-2">
                 <p readonly="">${employee.dateOfBirth}</p>
             </td>
             <td class="col-xs-2 col-sm-2 col-md-2">
                 <p readonly="">${employee.login}</p>
             </td>
             <td class="col-xs-2 col-sm-2 col-md-2">
                 <p readonly="">${employee.email}</p>
             </td>
             <td class="col-xs-2 col-sm-2 col-md-2">
                 <p readonly="">${employee.role.userRole}</p>
             </td>
             <td class="col-xs-2 col-sm-2 col-md-2">
                 <form action="/staff/edit_employee" method="get">
                     <input type="hidden" name="employee_id" value="${employee.employeeId}"/>
                     <button type="submit" class="btn btn-xs btn-info">Редактировать</button>
                 </form>
             </td>
             <td class="col-xs-2 col-sm-2 col-md-2">
                 <form action="/staff/remove_employee" method="get">
                     <input type="hidden" name="employee_id" value="${employee.employeeId}"/>
                     <button type="submit" class="btn btn-xs btn-danger"
                            onclick="return confirm('Вы уверены, что хотите удалить ${employee.lastName} ${employee.firstName}?')">Удалить</button>
                 </form>
             </td>
         </tr>
     </c:forEach>
     </tbody>
 </table>
    <form class="form-signin" action="/staff/add_employee" method="get">
        <center>
        <button class="btn btn-lg btn-success btn-block left-button" type="submit" style="WIDTH: 235px; HEIGHT: 51px">
                Добавить сотрудника
        </button>
        </center>
    </form>

    </jsp:attribute>
    <jsp:attribute name="action">/dashboard</jsp:attribute>
    <jsp:attribute name="actionDescription">На главную страницу</jsp:attribute>
    <jsp:attribute name="error">${error}</jsp:attribute>
    <jsp:attribute name="informationMessage">${informationMessage}</jsp:attribute>
</t:admin>
