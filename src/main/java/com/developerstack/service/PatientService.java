package com.developerstack.service;

import com.developerstack.model.Patient;

import java.util.List;

public interface PatientService {

    boolean add(Patient patient);

    boolean edit(Patient patient);

    boolean delete(int id);

    Patient getPatient(int id);

    List<Patient> searchPatient(String input);

    List<Patient> getAllPatients();

}
