package com.developerstack.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name = "appointments")
public class Appointments implements Serializable {

    @Id
    @Column(name = "appointments_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentsId;
    @Column(name = "patient_id")
    @NotNull
    private int patientId;
    @Column(name = "appointments_name")
    private String appointmentsName;
    @Column(name = "appointments_date")
    @NotNull
    private String appointmentsDate;
    @Column(name = "appointments_picture")
    private Blob appointmentsPicture;

    public Appointments() {
    }

    public String getAppointmentsName() {
        return appointmentsName;
    }

    public void setAppointmentsName(String appointmentsName) {
        this.appointmentsName = appointmentsName;
    }

    public int getAppointmentsId() {
        return appointmentsId;
    }

    public void setAppointmentsId(int appointmentsId) {
        this.appointmentsId = appointmentsId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getAppointmentsDate() {
        return appointmentsDate;
    }

    public void setAppointmentsDate(String appointmentsDate) {
        this.appointmentsDate = appointmentsDate;
    }

    public Blob getAppointmentsPicture() {
        return appointmentsPicture;
    }

    public void setAppointmentsPicture(Blob appointmentsPicture) {
        this.appointmentsPicture = appointmentsPicture;
    }
}
