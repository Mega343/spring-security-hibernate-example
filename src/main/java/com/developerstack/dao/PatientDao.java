package com.developerstack.dao;

import com.developerstack.model.Patient;

import java.util.List;

public interface PatientDao {

    boolean add(Patient patient);

    boolean edit(Patient patient);

    boolean delete(int id);

    Patient getPatient(int id);

    List<Patient> searchByLastName(String lastName);

    List<Patient> searchByLastNameAndFirstName(String lastName, String firstName);

    List<Patient> searchByLastNameAndFirstNameAndPatronymic(String lastName, String firstName, String patronymic);

    List<Patient> searchByPhoneNumber(String phoneNumber);

    List<Patient> getAllPatients();
}
