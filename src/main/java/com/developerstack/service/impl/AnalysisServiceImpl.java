package com.developerstack.service.impl;

import com.developerstack.dao.AnalysisDao;
import com.developerstack.model.Analysis;
import com.developerstack.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
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
    public boolean edit(Analysis analysis, MultipartFile analysisFile) throws IOException {
        byte[] file = analysisFile.getBytes();

        if (Objects.isNull(analysis.getAnalysisPicture())) {
            analysis.setAnalysisPicture(file);
            analysisDao.edit(analysis);
            return true;
        }
        if (Objects.isNull(analysis.getAnalysisPictureTwo())) {
            analysis.setAnalysisPictureTwo(file);
            analysisDao.edit(analysis);
            return true;
        }
        if (Objects.isNull(analysis.getAnalysisPictureThree())) {
            analysis.setAnalysisPictureThree(file);
            analysisDao.edit(analysis);
            return true;
        }
        if (Objects.isNull(analysis.getAnalysisPictureFour())) {
            analysis.setAnalysisPictureFour(file);
            analysisDao.edit(analysis);
            return true;
        }
        if (Objects.isNull(analysis.getAnalysisPictureFive())) {
            analysis.setAnalysisPictureFive(file);
            analysisDao.edit(analysis);
            return true;
        }
        if (Objects.isNull(analysis.getAnalysisPictureSix())) {
            analysis.setAnalysisPictureSix(file);
            analysisDao.edit(analysis);
            return true;
        }
        return false;
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
