package com.developerstack.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "analysis")
public class Analysis implements Serializable {

    @Id
    @Column(name = "analysis_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int analysisId;
    @Column(name = "patient_id")
    @NotNull
    private int patientId;
    @Column(name = "analysis_date")
    @NotNull
    private String analysisDate;
    @Column(name = "analysis_name")
    @NotNull
    private String analysisName;
    @Column(name = "analysis_picture")
    @Lob
    private byte[] analysisPicture;

    public Analysis() {
    }

    public int getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(int analysisId) {
        this.analysisId = analysisId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getAnalysisDate() {
        return analysisDate;
    }

    public void setAnalysisDate(String analysisDate) {
        this.analysisDate = analysisDate;
    }

    public String getAnalysisName() {
        return analysisName;
    }

    public void setAnalysisName(String analysisName) {
        this.analysisName = analysisName;
    }

    public byte[] getAnalysisPicture() {
        return analysisPicture;
    }

    public void setAnalysisPicture(byte[] analysisPicture) {
        this.analysisPicture = analysisPicture;
    }
}
