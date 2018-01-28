package com.developerstack.service;

import com.developerstack.model.Appointments;

import java.util.List;

public interface AppointmentsService {

    boolean add(Appointments appointments);

    boolean edit(Appointments appointments);

    boolean delete(int id);

    Appointments getAppointments(int id);

    List<Appointments> findAppointmentsByPatientId(int id);
}
