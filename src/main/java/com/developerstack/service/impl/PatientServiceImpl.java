package com.developerstack.service.impl;

import com.developerstack.dao.PatientDao;
import com.developerstack.model.Patient;
import com.developerstack.service.PatientService;
import org.apache.commons.lang3.math.NumberUtils;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {ObjectNotFoundException.class,
        ConstraintViolationException.class})
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @Override
    public boolean add(Patient patient) {
        patientDao.add(patient);
        return true;
    }

    @Override
    public boolean edit(Patient patient) {
        patientDao.edit(patient);
        return true;
    }

    @Override
    public boolean delete(int id) {
        patientDao.delete(id);
        return true;
    }

    @Override
    public Patient getPatient(int id) {
        return patientDao.getPatient(id);
    }

    @Override
    public List<Patient> searchPatient(String input) {
        List<Patient> result = new ArrayList<>();
        if (input.isEmpty()) {
            return result;
        }
        if (NumberUtils.isDigits(input)) {
            result = patientDao.searchByPhoneNumber(input);
        } else {
            String[] searchCriteria = input.split(" ");
            if (searchCriteria.length == 1) {
                result = patientDao.searchByLastName(searchCriteria[0]);
            } else if (searchCriteria.length == 2) {
                result = patientDao.searchByLastNameAndFirstName(searchCriteria[0], searchCriteria[1]);
            } else if (searchCriteria.length == 3) {
                result = patientDao.searchByLastNameAndFirstNameAndPatronymic(searchCriteria[0], searchCriteria[1], searchCriteria[2]);
            }
        }
        return result;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientDao.getAllPatients();
    }
}
