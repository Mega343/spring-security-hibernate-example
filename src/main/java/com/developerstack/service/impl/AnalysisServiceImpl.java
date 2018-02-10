package com.developerstack.service.impl;

import com.developerstack.dao.AnalysisDao;
import com.developerstack.model.Analysis;
import com.developerstack.service.AnalysisService;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
//@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {ObjectNotFoundException.class,
//        ConstraintViolationException.class})
public class AnalysisServiceImpl implements AnalysisService {

    @Autowired
    private AnalysisDao analysisDao;

    @Override
    public boolean add(Analysis analysis, MultipartFile analysisFile) throws IOException {
        byte[] file = analysisFile.getBytes();
        analysis.setAnalysisPicture(file);
        analysisDao.add(analysis);
        return true;
    }

    @Override
    public boolean edit(Analysis analysis) {
        analysisDao.edit(analysis);
        return true;
    }

    @Override
    public boolean delete(int id) {
        analysisDao.delete(id);
        return true;
    }

    @Override
    public Analysis getAnalysis(int id) {
        return analysisDao.getAnalysis(id);
    }

    @Override
    public List<Analysis> findAnalysisByPatientId(int id) {
        return analysisDao.findAnalysisByPatientId(id);
    }
}
