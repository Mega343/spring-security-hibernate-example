package com.developerstack.dao;

import com.developerstack.model.Analysis;

import java.util.List;

public interface AnalysisDao {

    boolean add(Analysis analysis);

    boolean edit(Analysis analysis);

    boolean delete(int id);

    Analysis getAnalysis(int id);

    List<Analysis> findAnalysisByPatientId(int id);

}
