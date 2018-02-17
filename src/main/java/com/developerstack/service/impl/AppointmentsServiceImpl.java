package com.developerstack.service.impl;

import com.developerstack.dao.AppointmentsDao;
import com.developerstack.model.Appointments;
import com.developerstack.service.AppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class AppointmentsServiceImpl implements AppointmentsService {

    @Autowired
    private AppointmentsDao appointmentsDao;

    @Override
    public boolean add(Appointments appointments, MultipartFile[] appointmentsFile) throws IOException {
        byte[] file;
        for (int i = 0; i < appointmentsFile.length; i++) {
            file = appointmentsFile[i].getBytes();
            if (i == 0) {
                appointments.setAppointmentsPicture(file);
                appointments.setImagesCount(1);
            }
            if (i == 1) {
                appointments.setAppointmentsPictureTwo(file);
                appointments.setImagesCount(2);
            }
            if (i == 2) {
                appointments.setAppointmentsPictureThree(file);
                appointments.setImagesCount(3);
            }
            if (i == 3) {
                appointments.setAppointmentsPictureFour(file);
                appointments.setImagesCount(4);
            }
            if (i == 4) {
                appointments.setAppointmentsPictureFive(file);
                appointments.setImagesCount(5);
            }
            if (i == 5) {
                break;
            }
        }

        appointmentsDao.add(appointments);
        return true;
    }

    @Override
    public boolean edit(Appointments appointments) {
        appointmentsDao.edit(appointments);
        return true;
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
