function openAnalysis(analysisId) {
    var x = screen.width/2 - 700/2;
    var y = screen.height/2 - 450/2;
    window.open('/view_analysis?analysisId=' + analysisId,'Анализ' ,'height=800,width=800,left='+x+',top='+y);
}

function openAppointments(appointmentsId, appointmentsCount) {
    var x = screen.width/2 - 700/2;
    var y = screen.height/2 - 450/2;
    window.open('/view_appointments?appointmentsId=', 'Назначения', 'height=800,width=800,left=' + x + ',top=' + y);
}