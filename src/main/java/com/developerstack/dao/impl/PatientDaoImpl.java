package com.developerstack.dao.impl;

import com.developerstack.dao.PatientDao;
import com.developerstack.model.Patient;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoImpl implements PatientDao {

    @Autowired
    private SessionFactory session;

    @Override
    public boolean add(Patient patient) {
        session.getCurrentSession().save(patient);
        return true;
    }

    @Override
    public boolean edit(Patient patient) {
        session.getCurrentSession().merge(patient);
        return true;
    }

    @Override
    public boolean delete(int id) {
        Query query = session.getCurrentSession().createQuery("delete Patient where patientId = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        return true;
    }

    @Override
    public Patient getPatient(int id) {
        Patient patient = (Patient) session.getCurrentSession().get(Patient.class, id);
        return patient;
    }

    @Override
    public List<Patient> getAllPatients() {
        Query query = session.getCurrentSession().createQuery("from Patient");
        List<Patient> patients = query.list();
        return patients;
    }

    @Override
    public List<Patient> searchByPhoneNumber(String phoneNumber) {
        Criteria criteria = session.getCurrentSession().createCriteria(Patient.class);
        criteria.add(Restrictions.eq("phoneNumber", phoneNumber));
        List<Patient> list = criteria.list();
        return list;
    }

    @Override
    public List<Patient> searchByLastNameAndFirstNameAndPatronymic(String lastName, String firstName, String patronymic) {
        Query query = session.getCurrentSession().createQuery("from Patient where lastName = :lastName and firstName =:firstName and patronymic =:patronymic");
        query.setParameter("lastName", lastName);
        query.setParameter("firstName", firstName);
        query.setParameter("patronymic", patronymic);
        List<Patient> patients = query.list();
        return patients;
    }

    @Override
    public List<Patient> searchByLastNameAndFirstName(String lastName, String firstName) {
        Query query = session.getCurrentSession().createQuery("from Patient where lastName = :lastName and firstName =:firstName");
        query.setParameter("lastName", lastName);
        query.setParameter("firstName", firstName);
        List<Patient> patients = query.list();
        return patients;
    }

    @Override
    public List<Patient> searchByLastName(String lastName) {
        Query query = session.getCurrentSession().createQuery("from Patient where lastName = :lastName");
        query.setParameter("lastName", lastName);
        List<Patient> patients = query.list();
        return patients;
    }
}
