package com.developerstack.dao;

import com.developerstack.model.Appointments;

import java.util.List;

public interface AppointmentsDao {

    boolean add(Appointments appointments);

    boolean edit(Appointments appointments);

    boolean delete(int id);

    Appointments getAppointments(int id);

    List findAppointmentsByPatientId(int id);

}
