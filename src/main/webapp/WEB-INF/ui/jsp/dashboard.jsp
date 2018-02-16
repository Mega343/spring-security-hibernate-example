<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <div></div>
    </jsp:attribute>
</t:admin>