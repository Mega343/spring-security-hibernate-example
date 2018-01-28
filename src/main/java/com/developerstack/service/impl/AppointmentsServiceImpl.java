package com.developerstack.service.impl;

import com.developerstack.dao.AppointmentsDao;
import com.developerstack.model.Appointments;
import com.developerstack.service.AppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AppointmentsServiceImpl implements AppointmentsService {

    @Autowired
    private AppointmentsDao appointmentsDao;

    @Override
    public boolean add(Appointments appointments) {
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
