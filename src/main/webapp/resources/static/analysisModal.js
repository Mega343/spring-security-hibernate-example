$(document).ready(function($) {
    $('#add_analysis_image').click(function (e) {

        //get data-id attribute of the clicked element
        var analysisId = $(this).attr("data-analysisId");

        //populate the textbox
        $('#addAnalysisImage').find('input[name="analysisId"]').val(analysisId);
    });
});