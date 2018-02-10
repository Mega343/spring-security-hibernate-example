package com.developerstack.dao.impl;

import com.developerstack.dao.AppointmentsDao;
import com.developerstack.model.Appointments;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppointmentsDaoImpl implements AppointmentsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean add(Appointments appointments) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(appointments);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return true;
    }

    @Override
    public boolean edit(Appointments appointments) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.merge(appointments);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return true;
    }

    @Override
    public boolean delete(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("delete Appointments where appointmentsId = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return true;
    }

    @Override
    public Appointments getAppointments(int id) {
        Session session = null;
        Appointments appointments = new Appointments();
        try {
            session = sessionFactory.openSession();
            appointments = (Appointments) session.get(Appointments.class, id);

        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return appointments;
    }

    @Override
    public List<Appointments> findAppointmentsByPatientId(int id) {
        Session session = null;
        List<Appointments> appointments = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Appointments.class);
            criteria.add(Restrictions.eq("patientId", id));
            appointments = criteria.list();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return appointments;
    }
}
