<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <script type="text/javascript" src="/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/blockButton.js"></script>
    <script type="text/javascript" src="/analysisModal.js"></script>
</head>
<body>

<div class="modal fade" id="addAnalysisImage" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title" style="color: #2b669a">Добавить фото анализа
                    для ${patient.lastName} ${patient.firstName}</h4>
            </div>
            <form action="/patients/update_analysis" method="post" enctype="multipart/form-data" id="add_analysis_image">
                <div class="modal-body col-xs-12 col-sm-12 col-md-12">
                </div>
                <div class="modal-footer">
                    <div class="input-group image-preview">
                        <input type="text" class="form-control image-preview-filename" disabled="disabled" required="required">
                        <span class="input-group-btn">
                          <button type="button" class="btn btn-default image-preview-clear" style="display:none;">
                              <span class="glyphicon glyphicon-remove"></span> Очистить
                          </button>
                          <div class="btn btn-default image-preview-input">
                              <span class="glyphicon glyphicon-folder-open"></span>
                              <span class="image-preview-input-title">Выбрать</span>
                              <input type="file" accept="image/png, image/jpeg, image/gif" name=" analysisFile" required="required"/>
                              <input type="hidden" name="analysisId" value="${analysisId}"/>
                          </div>
                          </span>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 pop-up-input" style="margin-top: 20pt; margin-left: 285pt;">
                        <div class="form-group row">
                            <button class="btn btn-sm btn-primary btn-block" type="submit" id="btn_add_analysis">Добавить изображение</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>
</body>
</html>