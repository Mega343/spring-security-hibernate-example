$(document).ready(function($) {
    $('#add_appointments_image').click(function (e) {

        //get data-id attribute of the clicked element
        var appointmentsId = $(this).attr("data-appointmentsId");

        //populate the textbox
        $('#addAppointmentsImage').find('input[name="appointmentsId"]').val(appointmentsId);
    });
});