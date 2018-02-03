$(document).ready(function () {
    $('#add_patient_form').submit(function () {
        $('#btn_add_patient').attr("disabled", true);
    });
    $('#add_appointments_form').submit(function () {
        $('#btn_add_appointments').attr("disabled", true);
    });
    $('#add_analysis_form').submit(function () {
        $('#btn_add_analysis').attr("disabled", true);
    });
});

