package com.developerstack.dao.impl;

import com.developerstack.dao.AnalysisDao;
import com.developerstack.model.Analysis;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnalysisDaoImpl implements AnalysisDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean add(Analysis analysis) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(analysis);
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
    public boolean edit(Analysis analysis) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(analysis);
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
        Query query = session.createQuery("delete Analysis where analysisId = :id");
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
    public Analysis getAnalysis(int id) {
        Session session = null;
        Analysis analysis = new Analysis();
        try {
            session = sessionFactory.openSession();
            analysis = (Analysis) session.get(Analysis.class, id);
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return analysis;
    }

    @Override
    public List<Analysis> findAnalysisByPatientId(int id) {
        Session session = null;
        List<Analysis> analysis = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Analysis.class);
             criteria.add(Restrictions.eq("patientId", id));
            analysis = criteria.list();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return analysis;
    }
}
