package com.developerstack.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ads")
public class Ads implements Serializable {

    @Id
    @Column(name = "ads_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adsId;
    @Column(name = "ads", length = Integer.MAX_VALUE)
    private String ads;
    @Column(name = "ads_date")
    private Date adsDate;

    public int getAdsId() {
        return adsId;
    }

    public void setAdsId(int adsId) {
        this.adsId = adsId;
    }

    public String getAds() {
        return ads;
    }

    public void setAds(String ads) {
        this.ads = ads;
    }

    public Date getAdsDate() {
        return adsDate;
    }

    public void setAdsDate(Date adsDate) {
        this.adsDate = adsDate;
    }
}
