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
    @Column(name = "analysis_picture_2")
    @Lob
    private byte[] analysisPictureTwo;
    @Column(name = "analysis_picture_3")
    @Lob
    private byte[] analysisPictureThree;
    @Column(name = "analysis_picture_4")
    @Lob
    private byte[] analysisPictureFour;
    @Column(name = "analysis_picture_5")
    @Lob
    private byte[] analysisPictureFive;
    @Column(name = "analysis_picture_6")
    @Lob
    private byte[] analysisPictureSix;

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

    public byte[] getAnalysisPictureTwo() {
        return analysisPictureTwo;
    }

    public void setAnalysisPictureTwo(byte[] analysisPictureTwo) {
        this.analysisPictureTwo = analysisPictureTwo;
    }

    public byte[] getAnalysisPictureThree() {
        return analysisPictureThree;
    }

    public void setAnalysisPictureThree(byte[] analysisPictureThree) {
        this.analysisPictureThree = analysisPictureThree;
    }

    public byte[] getAnalysisPictureFive() {
        return analysisPictureFive;
    }

    public void setAnalysisPictureFive(byte[] analysisPictureFive) {
        this.analysisPictureFive = analysisPictureFive;
    }

    public byte[] getAnalysisPictureFour() {
        return analysisPictureFour;
    }

    public void setAnalysisPictureFour(byte[] analysisPictureFour) {
        this.analysisPictureFour = analysisPictureFour;
    }

    public byte[] getAnalysisPictureSix() {
        return analysisPictureSix;
    }

    public void setAnalysisPictureSix(byte[] analysisPictureSix) {
        this.analysisPictureSix = analysisPictureSix;
    }
}

