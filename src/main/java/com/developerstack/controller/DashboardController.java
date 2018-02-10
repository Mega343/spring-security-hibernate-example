package com.developerstack.controller;

import com.developerstack.model.Analysis;
import com.developerstack.model.Appointments;
import com.developerstack.model.Patient;
import com.developerstack.service.AnalysisService;
import com.developerstack.service.AppointmentsService;
import com.developerstack.service.EmployeeService;
import com.developerstack.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.developerstack.Constants.*;

@Controller
public class DashboardController {

	@Autowired
	private PatientService patientService;
	@Autowired
	private EmployeeService userService;
	@Autowired
	private AppointmentsService appointmentsService;
	@Autowired
	private AnalysisService analysisService;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() throws Exception {
    	ModelAndView model = new ModelAndView();
    	model.addObject(EMPLOYEES, userService.getEmployees());
    	model.setViewName(DASHBOARD);
    	return model;
    }

	@RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("search") String search) {
		ModelAndView model = new ModelAndView();
		List<Patient> patients = patientService.searchPatient(search);
		if (patients.isEmpty()) {
			model.addObject(ERROR, "Не найдено ни одного пацента с такими данными: " + search + "\"." +
					" Попробуйте сократить параметры поиска или проверить все ли введено правильно.");
			model.setViewName(DASHBOARD);
		} else if (patients.size() == 1) {
			Patient patient = patients.get(0);
			List<Appointments> appointmentsList = appointmentsService.findAppointmentsByPatientId(patient.getPatientId());
			List<Analysis> analysisList = analysisService.findAnalysisByPatientId(patient.getPatientId());
			model.addObject(PATIENT, patient);
			model.addObject(EMPLOYEE, patient.getEmployee());
			model.addObject(ANALYSIS, analysisList);
			model.addObject(APPOINTMENTS, appointmentsList);
			model.setViewName(VIEW_PATIENT);
		} else {
			model.addObject(PATIENTS, patients);
			model.setViewName(PATIENTS);
		}

    	return model;
    }



}
