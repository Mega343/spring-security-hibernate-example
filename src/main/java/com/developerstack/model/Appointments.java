package com.developerstack.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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
    @Column(name = "ads", length = Integer.MAX_VALUE)
    private String appointmentsText;
    @Column(name = "appointments_picture")
    @Lob
    private byte[] appointmentsPicture;
    @Column(name = "appointments_picture_2")
    @Lob
    private byte[] appointmentsPictureTwo;
    @Column(name = "appointments_picture_3")
    @Lob
    private byte[] appointmentsPictureThree;
    @Column(name = "appointments_picture_4")
    @Lob
    private byte[] appointmentsPictureFour;
    @Column(name = "appointments_picture_5")
    @Lob
    private byte[] appointmentsPictureFive;
    @Column(name = "appointments_picture_6")
    @Lob
    private byte[] appointmentsPictureSix;


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

    public byte[] getAppointmentsPicture() {
        return appointmentsPicture;
    }

    public byte[] getAppointmentsPictureTwo() {
        return appointmentsPictureTwo;
    }

    public void setAppointmentsPictureTwo(byte[] appointmentsPictureTwo) {
        this.appointmentsPictureTwo = appointmentsPictureTwo;
    }

    public byte[] getAppointmentsPictureThree() {
        return appointmentsPictureThree;
    }

    public void setAppointmentsPictureThree(byte[] appointmentsPictureThree) {
        this.appointmentsPictureThree = appointmentsPictureThree;
    }

    public byte[] getAppointmentsPictureFour() {
        return appointmentsPictureFour;
    }

    public void setAppointmentsPictureFour(byte[] appointmentsPictureFour) {
        this.appointmentsPictureFour = appointmentsPictureFour;
    }

    public byte[] getAppointmentsPictureFive() {
        return appointmentsPictureFive;
    }

    public void setAppointmentsPictureFive(byte[] appointmentsPictureFive) {
        this.appointmentsPictureFive = appointmentsPictureFive;
    }

    public void setAppointmentsPicture(byte[] appointmentsPicture) {
        this.appointmentsPicture = appointmentsPicture;
    }

    public byte[] getAppointmentsPictureSix() {
        return appointmentsPictureSix;
    }

    public void setAppointmentsPictureSix(byte[] appointmentsPictureSix) {
        this.appointmentsPictureSix = appointmentsPictureSix;
    }

    public String getAppointmentsText() {
        return appointmentsText;
    }

    public void setAppointmentsText(String appointmentsText) {
        this.appointmentsText = appointmentsText;
    }
}
