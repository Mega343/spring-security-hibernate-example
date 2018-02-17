package com.developerstack.service.impl;

import com.developerstack.dao.AdsDao;
import com.developerstack.model.Ads;
import com.developerstack.service.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdsServiceImpl implements AdsService {

    @Autowired
    private AdsDao adsDao;

    @Override
    public boolean add(Ads ads) {
        return adsDao.add(ads);
    }

    @Override
    public boolean edit(Ads ads) {
        return adsDao.edit(ads);
    }

    @Override
    public boolean delete(int id) {
        return adsDao.delete(id);
    }

    @Override
    public Ads getAds(int id) {
        return adsDao.getAds(id);
    }

    @Override
    public List<Ads> findAllAds() {
        return adsDao.findAllAds();
    }
}
