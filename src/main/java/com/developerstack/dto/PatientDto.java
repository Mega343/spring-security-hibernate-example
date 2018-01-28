package com.developerstack.dto;

import java.util.Date;

public class PatientDto {

    private int patientId;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Date dateOfBirth;
    private String phoneNumber;
    private String diagnosis;
    private Date dateOfFirstVisit;
    private int employeeId;


    public PatientDto() {
    }

    public PatientDto(int patientId, String firstName, String lastName, String patronymic, Date dateOfBirth,
                      String phoneNumber, String diagnosis, Date dateOfFirstVisit, int employeeId) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.diagnosis = diagnosis;
        this.dateOfFirstVisit = dateOfFirstVisit;
        this.employeeId = employeeId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Date getDateOfFirstVisit() {
        return dateOfFirstVisit;
    }

    public void setDateOfFirstVisit(Date dateOfFirstVisit) {
        this.dateOfFirstVisit = dateOfFirstVisit;
    }


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
