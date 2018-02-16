<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ page contentType="text/html;charset=utf-8" %>
<t:admin title="Список сотрудников">
    <jsp:attribute name="tableName">Сотрудники</jsp:attribute>
    <jsp:attribute name="error">${error}</jsp:attribute>
    <jsp:attribute name="action">/patients/add_patient</jsp:attribute>
    <jsp:attribute name="actionDescription">Добавить пациента</jsp:attribute>
    <jsp:attribute name="table">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>User ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>E-mail</th>
            <th>Phone number</th>
            <th>Karma</th>
            <th>Role</th>
            <th>Document</th>
            <th>Address</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
                    <tbody>
                    <c:forEach var="employee" items="${employees}">
                        <tr>
                            <td><c:out value="${employee.employeeId}"/></td>
                            <td><c:out value="${employee.firstName}"/></td>
                            <td><c:out value="${employee.lastName}"/></td>
                            <td><c:out value="${employee.email}"/></td>
                            <td><c:out value="${employee.phoneNumber}"/></td>
                            <td><c:out value="${employee.role.userRole}"/></td>
                            <%--<td>--%>
                                <%--<form action="document" method="get">--%>
                                    <%--<input type="hidden" name="user_id" value="${user.userID}"/>--%>
                                    <%--<button type="submit" class="btn btn-xs btn-info">Document</button>--%>
                                <%--</form>--%>
                            <%--</td>--%>
                            <%--<td>--%>
                                <%--<form action="address" method="get">--%>
                                    <%--<input type="hidden" name="user_id" value="${user.userID}"/>--%>
                                    <%--<button type="submit" class="btn btn-xs btn-info">Address</button>--%>
                                <%--</form>--%>
                            <%--</td>--%>
                            <%--<td>--%>
                                <%--<form action="update_user" method="get">--%>
                                    <%--<input type="hidden" name="user_id" value="${user.userID}"/>--%>
                                    <%--<button type="submit" class="btn btn-xs btn-warning">Update</button>--%>
                                <%--</form>--%>
                            <%--</td>--%>
                            <%--<td>--%>
                                <%--<form action="delete" method="get">--%>
                                    <%--<input type="hidden" name="user_id" value="${user.userID}"/>--%>
                                    <%--<button type="submit" class="btn btn-xs btn-danger">Delete</button>--%>
                                <%--</form>--%>
                            <%--</td>--%>
                        </tr>
                    </c:forEach>
                    </tbody>
    </table>
    </jsp:attribute>
</t:admin>

