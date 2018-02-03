package com.developerstack.dao.impl;

import com.developerstack.dao.AnalysisDao;
import com.developerstack.model.Analysis;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnalysisDaoImpl implements AnalysisDao {

    @Autowired
    private SessionFactory session;

    @Override
    public boolean add(Analysis analysis) {
        session.getCurrentSession().save(analysis);
        return true;
    }

    @Override
    public boolean edit(Analysis analysis) {
        session.getCurrentSession().merge(analysis);
        return true;
    }

    @Override
    public boolean delete(int id) {
        Query query = session.getCurrentSession().createQuery("delete Analysis where analysisId = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        return true;
    }

    @Override
    public Analysis getAnalysis(int id) {
        return (Analysis) session.getCurrentSession().get(Analysis.class, id);
    }

    @Override
    public List<Analysis> findAnalysisByPatientId(int id) {
        Criteria criteria = session.getCurrentSession().createCriteria(Analysis.class);
        criteria.add(Restrictions.eq("patientId", id));
        List<Analysis> list = criteria.list();
        return list;
    }
}
