package com.developerstack.controller;

import com.developerstack.model.Analysis;
import com.developerstack.model.Patient;
import com.developerstack.service.AnalysisService;
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
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.developerstack.config.Constants.*;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AnalysisService analysisService;


    @RequestMapping(value = "/add_patient", method = RequestMethod.GET)
    public ModelAndView patientAddView() {
        ModelAndView model = new ModelAndView();
        model.addObject("employees", employeeService.getEmployees());
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
            model.setViewName("viewPatient");
        } catch (Exception e) {
            model.addObject(ERROR, "Во время добавления пациента " + patient.getLastName()
                    + " " + patient.getFirstName() + " что-то пошло не так. Пожалуйста, попробуйте еще раз.");
            model.setViewName("addPatient");
        }
        return model;
    }

    @RequestMapping(value = "/new_analysis", method = RequestMethod.POST)
    public ModelAndView addPatient(@ModelAttribute(ANALYSIS) Analysis analysis,
                                   @RequestParam("analysisFile") MultipartFile analysisFile) {
        ModelAndView model = new ModelAndView();
        try {
            analysisService.add(analysis, analysisFile);
            Patient patient = patientService.getPatient(analysis.getPatientId());
            model.addObject(INFORMATION_MESSAGE, "Анализ для " + patient.getLastName()
                    + " " + patient.getFirstName() + " успешно добавлен.");
            model.addObject(PATIENT, patient);
            model.addObject(EMPLOYEE, patient.getEmployee());
            model.setViewName("viewPatient");
        } catch (Exception e) {
            model.addObject(ERROR, "Ошибка во время добавления анализа. Попробуйте, пожалуйста, еще раз." + e.getMessage());
            Patient patient = patientService.getPatient(analysis.getPatientId());
            model.addObject(PATIENT, patient);
            model.addObject(EMPLOYEE, patient.getEmployee());
            model.setViewName("viewPatient");
        }
        return model;
    }

    @RequestMapping(value = "/view_analysis", method = RequestMethod.POST)
    public ModelAndView addPatient(@ModelAttribute(ANALYSIS) Analysis analysis,
                                   @RequestParam("analysisFile") MultipartFile analysisFile) {
        ModelAndView model = new ModelAndView();
        try {
            analysisService.add(analysis, analysisFile);
            Patient patient = patientService.getPatient(analysis.getPatientId());
            model.addObject(INFORMATION_MESSAGE, "Анализ для " + patient.getLastName()
                    + " " + patient.getFirstName() + " успешно добавлен.");
            model.addObject(PATIENT, patient);
            model.addObject(EMPLOYEE, patient.getEmployee());
            model.setViewName("viewPatient");
        } catch (Exception e) {
            model.addObject(ERROR, "Ошибка во время добавления анализа. Попробуйте, пожалуйста, еще раз." + e.getMessage());
            Patient patient = patientService.getPatient(analysis.getPatientId());
            model.addObject(PATIENT, patient);
            model.addObject(EMPLOYEE, patient.getEmployee());
            model.setViewName("viewPatient");
        }
        return model;
    }



    @RequestMapping(value = "/analysis_image", method = RequestMethod.GET)
    public void analysisImage(@RequestParam("analysisId") String analysisId, HttpServletResponse res) throws IOException {
        Analysis analysis = analysisService.getAnalysis(Integer.parseInt(analysisId));
        res.setContentType("image/jpg");
        ServletOutputStream outputStream = res.getOutputStream();
        outputStream.write(analysis.getAnalysisPicture());
        outputStream.close();
    }
}
