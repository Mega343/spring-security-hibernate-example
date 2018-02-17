<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ page contentType="text/html;charset=utf-8" %>
<t:admin title="Список сотрудников">
    <jsp:attribute name="tableName">Объявления</jsp:attribute>
    <jsp:attribute name="error">${error}</jsp:attribute>
    <jsp:attribute name="informationMessage">${informationMessage}</jsp:attribute>
    <jsp:attribute name="action">/patients/add_patient</jsp:attribute>
    <jsp:attribute name="actionDescription">Добавить пациента</jsp:attribute>
    <jsp:attribute name="helpimage">
<style>
    @font-face {
        font-family: Carefree Cyrillic;
        src: url(/11179.ttf);
    }
    P {
        font-family: Carefree Cyrillic;
    }
</style>
        <p class="custom-fonts">Добавьте нового пациента или воспользуйтесь поиском</p>
    </jsp:attribute>
    <jsp:attribute name="table">
        <table class="table table-striped">
        <thead></thead>
        <tbody>
         <c:forEach var="ads" items="${adsList}">
             <tr>
                 <td class="col-xs-10 col-sm-10 col-md-10">
                     ${ads.ads}
                 </td>
                 <sec:authorize access="hasRole('Admin')">
                 <td class="col-xs-1 col-sm-1 col-md-1">
                     <form action="/remove_ads" method="get">
                         <input type="hidden" name="ads_id" value="${ads.adsId}"/>
                         <button type="submit" class="btn btn-xs btn-danger"
                                 onclick="return confirm('Вы уверены, что хотите удалить?')">Удалить</button>
                     </form>
                 </td>
                 </sec:authorize>
             </tr>
         </c:forEach>
         </tbody>
        </table>
        <sec:authorize access="hasRole('Admin')">
                <div class="form-group row">
                    <center>
                        <button type="button" class="btn btn-xs btn-warning" data-toggle="modal" data-target="#addAds">Добавить объявление</button>
                    </center>
                </div>
        </sec:authorize>
        <%@ include file="addAds.jsp"%>
    </jsp:attribute>
</t:admin>