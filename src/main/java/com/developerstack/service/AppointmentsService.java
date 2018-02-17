package com.developerstack.service;

import com.developerstack.model.Appointments;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AppointmentsService {

    boolean add(Appointments appointments, MultipartFile appointmentsFile) throws IOException;

    boolean edit(Appointments appointments, MultipartFile appointmentsFile) throws IOException;

    boolean delete(int id);

    Appointments getAppointments(int id);

    List<Appointments> findAppointmentsByPatientId(int id);
}
