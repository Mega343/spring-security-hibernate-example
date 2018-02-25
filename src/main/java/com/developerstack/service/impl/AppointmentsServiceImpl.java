package com.developerstack.service.impl;

import com.developerstack.dao.AppointmentsDao;
import com.developerstack.model.Appointments;
import com.developerstack.service.AppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class AppointmentsServiceImpl implements AppointmentsService {

    @Autowired
    private AppointmentsDao appointmentsDao;

    @Override
    public boolean add(Appointments appointments, MultipartFile appointmentsFile) throws IOException {
        if (!appointmentsFile.isEmpty()) {
            byte[] file = appointmentsFile.getBytes();
            appointments.setAppointmentsPicture(file);
        }
        appointmentsDao.add(appointments);
        return true;
    }

    @Override
    public boolean edit(Appointments appointments, MultipartFile appointmentsFile) throws IOException {
        byte[] file = appointmentsFile.getBytes();

        if (Objects.isNull(appointments.getAppointmentsPicture())) {
            appointments.setAppointmentsPicture(file);
            appointmentsDao.edit(appointments);
            return true;
        }
        if (Objects.isNull(appointments.getAppointmentsPictureTwo())) {
            appointments.setAppointmentsPictureTwo(file);
            appointmentsDao.edit(appointments);
            return true;
        }
        if (Objects.isNull(appointments.getAppointmentsPictureThree())) {
            appointments.setAppointmentsPictureThree(file);
            appointmentsDao.edit(appointments);
            return true;
        }
        if (Objects.isNull(appointments.getAppointmentsPictureFour())) {
            appointments.setAppointmentsPictureFour(file);
            appointmentsDao.edit(appointments);
            return true;
        }
        if (Objects.isNull(appointments.getAppointmentsPictureFive())) {
            appointments.setAppointmentsPictureFive(file);
            appointmentsDao.edit(appointments);
            return true;
        }
        if (Objects.isNull(appointments.getAppointmentsPictureSix())) {
            appointments.setAppointmentsPictureSix(file);
            appointmentsDao.edit(appointments);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        appointmentsDao.delete(id);
        return true;
    }

    @Override
    public Appointments getAppointments(int id) {
        return appointmentsDao.getAppointments(id);
    }

    @Override
    public List<Appointments> findAppointmentsByPatientId(int id) {
        return appointmentsDao.findAppointmentsByPatientId(id);
    }
}
