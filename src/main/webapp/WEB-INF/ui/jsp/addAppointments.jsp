<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <script type="text/javascript" src="/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/blockButton.js"></script>
</head>
<body>
<div class="modal fade" id="addAppointments" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title" style="color: #2b669a">Добавить назначение
                    для ${patient.lastName} ${patient.firstName}</h4>
            </div>
            <form action="/patients/new_appointments" method="post" enctype="multipart/form-data" id="add_appointments_form">
                <div class="modal-body col-xs-12 col-sm-12 col-md-12">

                    <input type="hidden" name="patientId" id="patientId" value="${patient.patientId}"/>
                    <div class="row">
                        <div class="col-xs-5 col-sm-5 col-md-5 pop-up-input">
                            <div class="form-group row">
                                <label class="col-4 col-form-label required">Название назначения</label>
                                <input class="form-control input-md" type="text" name="appointmentsName"
                                       id="appointmentsName" required="required">
                            </div>
                        </div>
                        <div class="col-xs-3 col-sm-3 col-md-3 pop-up-input">
                            <div class="form-group row">
                                <label class="col-2 col-form-label required">Дата назначения</label>
                                <input class="form-control input-md" type="text" name="appointmentsDate" id="appointmentsDate"
                                       required="required" placeholder="ДД-ММ-ГГГГ">
                            </div>
                        </div>
                        <div class="col-xs-3 col-sm-3 col-md-3 pop-up-input" style="margin-top: 20pt">
                            <div class="form-group row">
                                <button class="btn btn-sm btn-primary btn-block" type="submit" id="btn_add_appointments">Добавить назначение</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-11 col-sm-11 col-md-11 pop-up-input">
                        <div class="form-group row">
                            <label class="col-10 col-form-label">Текст назначения</label>
                            <textarea class="form-control input-md" name="appointmentsText"
                                      id="appointmentsText"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="input-group image-preview">
                        <input type="text" class="form-control image-preview-filename" disabled="disabled">
                          <span class="input-group-btn">
                          <button type="button" class="btn btn-default image-preview-clear" style="display:none;">
                              <span class="glyphicon glyphicon-remove"></span> Очистить
                          </button>
                          <div class="btn btn-default image-preview-input">
                              <span class="glyphicon glyphicon-folder-open"></span>
                              <span class="image-preview-input-title">Выбрать</span>
                              <input type="file" accept="image/png, image/jpeg, image/gif" name="appointments"/>
                          </div>
                          </span>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>
</body>
</html>