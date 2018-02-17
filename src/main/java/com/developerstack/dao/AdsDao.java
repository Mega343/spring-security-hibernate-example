package com.developerstack.dao;

import com.developerstack.model.Ads;

import java.util.List;

public interface AdsDao {

    boolean add(Ads ads);

    boolean edit(Ads ads);

    boolean delete(int id);

    Ads getAds(int id);

    List<Ads> findAllAds();
}
