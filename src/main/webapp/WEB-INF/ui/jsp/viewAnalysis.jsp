<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
</head>
<body>
<div class="modal fade" id="viewAnalysis" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title" style="color: #2b669a">Анализ ${analysis.analysisName}
                - ${patient.lastName} ${patient.firstName}</h4>
            </div>
            <div class="modal-body">
                <img src="/analysis_image?analysisId=${analysis.analysisId}" width="500" height="500" alt="Analysis image"/>
            </div>
    </div>
</div>
</div>
</body>
</html>
