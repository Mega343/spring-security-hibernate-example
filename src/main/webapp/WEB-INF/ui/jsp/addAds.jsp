<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <script type="text/javascript" src="/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/blockButton.js"></script>
</head>
<body>
<div class="modal fade" id="addAds" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title" style="color: #2b669a">Добавить объявление</h4>
            </div>
            <form action="/add_ads" method="post" enctype="multipart/form-data" id="add_ads_form">
                <div class="modal-body col-xs-12 col-sm-12 col-md-12">

                    <div class="row">
                        <div class="col-xs-11 col-sm-11 col-md-11 pop-up-input">
                            <div class="form-group row">
                                <label class="col-10 col-form-label required">Объявление</label>
                                <textarea class="form-control input-md" name="ads"
                                    id="ads" required="required"></textarea>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="modal-footer">
                    <div class="col-xs-3 col-sm-3 col-md-3 pop-up-input" style="margin-top: 20pt">
                        <div class="form-group row">
                            <button class="btn btn-sm btn-primary btn-block" type="submit" id="btn_add_analysis">Добавить объявление</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>
</body>
</html>