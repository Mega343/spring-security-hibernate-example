package com.developerstack.service;

import com.developerstack.model.Analysis;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AnalysisService {

    boolean add(Analysis analysis, MultipartFile analysisFile) throws IOException;

    boolean edit(Analysis analysis, MultipartFile file) throws IOException;

    boolean delete(int id);

    Analysis getAnalysis(int id);

    List<Analysis> findAnalysisByPatientId(int id);
}
