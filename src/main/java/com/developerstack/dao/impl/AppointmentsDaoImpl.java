package com.developerstack.dao.impl;

import com.developerstack.dao.AppointmentsDao;
import com.developerstack.model.Appointments;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppointmentsDaoImpl implements AppointmentsDao {

    @Autowired
    private SessionFactory session;

    @Override
    public boolean add(Appointments appointments) {
        session.getCurrentSession().save(appointments);
        return true;
    }

    @Override
    public boolean edit(Appointments appointments) {
        session.getCurrentSession().merge(appointments);
        return true;
    }

    @Override
    public boolean delete(int id) {
        Query query = session.getCurrentSession().createQuery("delete Appointments where appointmentsId = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        return true;
    }

    @Override
    public Appointments getAppointments(int id) {
        return (Appointments) session.getCurrentSession().get(Appointments.class, id);
    }

    @Override
    public List findAppointmentsByPatientId(int id) {
        Criteria criteria = session.getCurrentSession().createCriteria(Appointments.class);
        criteria.add(Restrictions.eq("patientId", id));
        List<Appointments> list = criteria.list();
        return list;
    }
}
