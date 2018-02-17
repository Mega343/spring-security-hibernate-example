function openAnalysis(analysisId, pictureNumber) {
    var x = screen.width/2 - 700/2;
    var y = screen.height/2 - 450/2;
    window.open('/patients/view_analysis?analysisId=' + analysisId + '&picture=' + pictureNumber,'Анализ' ,'height=800,width=800,left='+x+',top='+y);
}

function openAppointments(appointmentsId, pictureNumber ) {
    var x = screen.width/2 - 700/2;
    var y = screen.height/2 - 450/2;
    window.open('/patients/view_appointments?appointmentsId=' + appointmentsId + '&picture=' + pictureNumber, 'Назначения', 'height=800,width=800,left=' + x + ',top=' + y);
}