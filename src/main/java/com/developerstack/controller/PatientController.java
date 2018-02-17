package com.developerstack.controller;

import com.developerstack.model.Analysis;
import com.developerstack.model.Appointments;
import com.developerstack.model.Employee;
import com.developerstack.model.Patient;
import com.developerstack.service.AnalysisService;
import com.developerstack.service.AppointmentsService;
import com.developerstack.service.EmployeeService;
import com.developerstack.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

import static com.developerstack.Constants.*;

@Controller
@RequestMapping(value = "/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AnalysisService analysisService;
    @Autowired
    private AppointmentsService appointmentsService;

    @RequestMapping(value = "/add_patient", method = RequestMethod.GET)
    public ModelAndView patientAddView() {
        ModelAndView model = new ModelAndView();
        List<Employee> employees = employeeService.getEmployees().stream()
                .filter(employee -> ADMIN_ROLE.equals(employee.getRole().getUserRole()) || DOCTOR_ROLE.equals(employee.getRole().getUserRole()))
                .collect(Collectors.toList());
        model.addObject(EMPLOYEES, employees);
        model.setViewName("addPatient");
        return model;
    }

    @RequestMapping(value = "/new_patient", method = RequestMethod.POST)
    public ModelAndView addPatient(@ModelAttribute(PATIENT) Patient patient) {
        ModelAndView model = new ModelAndView();
        try {
            patientService.add(patient);
            model.addObject(INFORMATION_MESSAGE, "Пациент " + patient.getLastName()
                    + " " + patient.getFirstName() + " успешно добавлен. Теперь вы можете добавить ему анализы и/или назначения.");
            model.addObject(PATIENT, patient);
            model.addObject(EMPLOYEE, employeeService.getEmployee(patient.getEmployee().getEmployeeId()));
            model.setViewName(VIEW_PATIENT);
        } catch (Exception e) {
            model.addObject(ERROR, "Во время добавления пациента " + patient.getLastName()
                    + " " + patient.getFirstName() + " что-то пошло не так. Пожалуйста, попробуйте еще раз.");
            model.setViewName("addPatient");
        }
        return model;
    }

    @RequestMapping(value = "/view_patient", method = RequestMethod.GET)
    public ModelAndView addPatient(@RequestParam("patient_id") String patientId) {
        ModelAndView model = new ModelAndView();
        Patient patient = patientService.getPatient(Integer.parseInt(patientId));
        model.addObject(PATIENT, patient);
        model.addObject(EMPLOYEE, employeeService.getEmployee(patient.getEmployee().getEmployeeId()));
        model.setViewName(VIEW_PATIENT);

        return model;
    }

    @RequestMapping(value = "/new_analysis", method = RequestMethod.POST)
    public ModelAndView addAnalysis(@ModelAttribute(ANALYSIS) Analysis analysis,
                                   @RequestParam("analysisFile") MultipartFile analysisFile) {
        ModelAndView model = new ModelAndView();
        try {
            analysisService.add(analysis, analysisFile);
            Patient patient = patientService.getPatient(analysis.getPatientId());
            model.addObject(INFORMATION_MESSAGE, "Анализ для " + patient.getLastName()
                    + " " + patient.getFirstName() + " успешно добавлен.");
            List<Appointments> appointmentsList = appointmentsService.findAppointmentsByPatientId(patient.getPatientId());
            List<Analysis> analysisList = analysisService.findAnalysisByPatientId(patient.getPatientId());
            model.addObject(PATIENT, patient);
            model.addObject(EMPLOYEE, patient.getEmployee());
            model.addObject(ANALYSIS, analysisList);
            model.addObject(APPOINTMENTS, appointmentsList);
            model.setViewName(VIEW_PATIENT);
        } catch (Exception e) {
            model.addObject(ERROR, "Ошибка во время добавления анализа. Попробуйте, пожалуйста, еще раз." + e.getMessage());
            Patient patient = patientService.getPatient(analysis.getPatientId());
            model.addObject(PATIENT, patient);
            model.addObject(EMPLOYEE, patient.getEmployee());
            model.setViewName(VIEW_PATIENT);
        }
        return model;
    }

    @RequestMapping(value = "/new_appointments", method = RequestMethod.POST)
    public ModelAndView addAppointment(@ModelAttribute(APPOINTMENTS) Appointments appointments,
                                   @RequestParam("appointments[]") MultipartFile[] appointmentsFile) {
        ModelAndView model = new ModelAndView();
        try {
            appointmentsService.add(appointments, appointmentsFile);
            Patient patient = patientService.getPatient(appointments.getPatientId());
            List<Appointments> appointmentsList = appointmentsService.findAppointmentsByPatientId(patient.getPatientId());
            List<Analysis> analysisList = analysisService.findAnalysisByPatientId(patient.getPatientId());
            model.addObject(INFORMATION_MESSAGE, "Назначение для " + patient.getLastName()
                    + " " + patient.getFirstName() + " успешно добавлено.");
            model.addObject(PATIENT, patient);
            model.addObject(EMPLOYEE, patient.getEmployee());
            model.addObject(ANALYSIS, analysisList);
            model.addObject(APPOINTMENTS, appointmentsList);
            model.setViewName(VIEW_PATIENT);
        } catch (Exception e) {
            model.addObject(ERROR, "Ошибка во время добавления назначения. Попробуйте, пожалуйста, еще раз. " + e.getMessage());
            Patient patient = patientService.getPatient(appointments.getPatientId());
            model.addObject(PATIENT, patient);
            model.addObject(EMPLOYEE, patient.getEmployee());
            model.setViewName(VIEW_PATIENT);
        }
        return model;
    }

    @RequestMapping(value = "/view_analysis", method = RequestMethod.GET)
    public ModelAndView viewAnalysis(@RequestParam("analysisId") String analysisId,
                                     HttpServletRequest req, HttpServletResponse res) {
        ModelAndView model = new ModelAndView();
        try(ServletOutputStream outputStream =  res.getOutputStream()) {
            Analysis analysis = analysisService.getAnalysis(Integer.parseInt(analysisId));
            res.setContentType("image/jpg");
            outputStream.write(analysis.getAnalysisPicture());
            outputStream.close();
            model.addObject(IMAGE_ONE, outputStream);
            Patient patient = patientService.getPatient(analysis.getPatientId());
            model.addObject(PATIENT, patient);
            model.setViewName("viewAnalysis");
        } catch (Exception e) {
            model.addObject(ERROR, e.getMessage());
            model.setViewName(DASHBOARD);
        }
        return model;
    }

    @RequestMapping(value = "/view_appointments", method = RequestMethod.GET)
        public ModelAndView viewAppointments(@RequestParam("appointmentsId") String appointmentsId,
                HttpServletRequest req, HttpServletResponse res) {
            ModelAndView model = new ModelAndView();
            try(ServletOutputStream outputStream =  res.getOutputStream()) {
                Appointments appointments = appointmentsService.getAppointments(Integer.parseInt(appointmentsId));
                res.setContentType("image/jpg");
                outputStream.write(appointments.getAppointmentsPicture());
                outputStream.write(appointments.getAppointmentsPictureTwo());
                outputStream.close();
//                model.addObject(IMAGE_ONE, outputStream);
//                Patient patient = patientService.getPatient(appointments.getPatientId());
//                model.addObject(PATIENT, patient);
               // model.setViewName("viewAppointments");
            } catch (Exception e) {
                model.addObject(ERROR, e.getMessage());
                model.setViewName(DASHBOARD);
            }
            return model;
    }


    @RequestMapping(value = "/edit_patient", method = RequestMethod.GET)
        public ModelAndView editPatient(@RequestParam("patientId") String patientId) {
            ModelAndView model = new ModelAndView();
        try {
            Patient patient = patientService.getPatient(Integer.parseInt(patientId));
            List<Appointments> appointmentsList = appointmentsService.findAppointmentsByPatientId(patient.getPatientId());
            List<Analysis> analysisList = analysisService.findAnalysisByPatientId(patient.getPatientId());
            model.addObject(PATIENT, patient);
            model.addObject(EMPLOYEES, employeeService.getEmployees());
            model.addObject(ANALYSIS, analysisList);
            model.addObject(APPOINTMENTS, appointmentsList);
            model.addObject("selectedEmployeeId", patient.getEmployee().getEmployeeId());
            model.setViewName("editPatient");
        } catch (Exception e) {
            model.addObject(ERROR, e.getMessage());
            model.setViewName(DASHBOARD);
        }
        return model;
    }

    @RequestMapping(value = "/update_patient", method = RequestMethod.POST)
    public ModelAndView updatePatient(@ModelAttribute(PATIENT) Patient patient) {
        ModelAndView model = new ModelAndView();
        try {
            patientService.edit(patient);
            List<Appointments> appointmentsList = appointmentsService.findAppointmentsByPatientId(patient.getPatientId());
            List<Analysis> analysisList = analysisService.findAnalysisByPatientId(patient.getPatientId());
            model.addObject(EMPLOYEE, employeeService.getEmployee(patient.getEmployee().getEmployeeId()));
            model.addObject(PATIENT, patient);
            model.addObject(ANALYSIS, analysisList);
            model.addObject(APPOINTMENTS, appointmentsList);
            model.setViewName("viewPatient");
        } catch (Exception e) {
            model.addObject(ERROR, "Не получилось обновить пациента. Что-то произошло не так.");
            model.setViewName(DASHBOARD);
        }
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
