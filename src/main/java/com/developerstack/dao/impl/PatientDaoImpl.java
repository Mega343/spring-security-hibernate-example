package com.developerstack.dao.impl;

import com.developerstack.dao.PatientDao;
import com.developerstack.model.Patient;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientDaoImpl implements PatientDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean add(Patient patient) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(patient);
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
    public boolean edit(Patient patient) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(patient);
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
            Query query = session.createQuery("delete Patient where patientId = :id");
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
    public Patient getPatient(int id) {
        Session session = null;
        Patient patient = new Patient();
        try {
            session = sessionFactory.openSession();
            patient = (Patient) session.get(Patient.class, id);
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return patient;
    }

    @Override
    public List<Patient> getAllPatients() {
        Session session = null;
        List<Patient> patients = new ArrayList<>();
        try {
            session = sessionFactory.openSession();

            Query query = session.createQuery("from Patient");
            patients = query.list();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return patients;
    }

    @Override
    public List<Patient> searchByPhoneNumber(String phoneNumber) {
        Session session = null;
        List<Patient> patients = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Patient.class);
            criteria.add(Restrictions.eq("phoneNumber", phoneNumber));
            patients = criteria.list();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return patients;
    }

    @Override
    public List<Patient> searchByLastNameAndFirstNameAndPatronymic(String lastName, String firstName, String patronymic) {
        Session session = null;
        List<Patient> patients = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from Patient where lastName = :lastName and firstName = :firstName and patronymic = :patronymic");
            query.setParameter("lastName", lastName);
            query.setParameter("firstName", firstName);
            query.setParameter("patronymic", patronymic);
            patients = query.list();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return patients;
    }

    @Override
    public List<Patient> searchByLastNameAndFirstName(String lastName, String firstName) {
        Session session = null;
        List<Patient> patients = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from Patient where lastName = :lastName and firstName = :firstName");
            query.setParameter("lastName", lastName);
            query.setParameter("firstName", firstName);
            patients = query.list();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return patients;
    }

    @Override
    public List<Patient> searchByLastName(String lastName) {
        Session session = null;
        List<Patient> patients = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from Patient where lastName = :lastName");
            query.setParameter("lastName", lastName);
            patients = query.list();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return patients;
    }
}
