package com.developerstack.controller;

import com.developerstack.model.Ads;
import com.developerstack.service.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

import static com.developerstack.Constants.DASHBOARD;

@Controller
public class AdsController {

    @Autowired
    private AdsService adsService;

    @RequestMapping(value = "/add_ads", method = RequestMethod.POST)
    public ModelAndView addAds(@RequestParam("ads") String adsText) {
        ModelAndView model = new ModelAndView();
        Ads ads = new Ads();
        ads.setAds(adsText);
        ads.setAdsDate(new Date());
        adsService.add(ads);

        List<Ads> adsList = adsService.findAllAds();
        Collections.reverse(adsList);
        model.addObject("adsList", adsList);

        model.setViewName(DASHBOARD);
        return model;
    }

    @RequestMapping(value = "/remove_ads", method = RequestMethod.GET)
    public ModelAndView removeEmployee(@RequestParam("ads_id") String adsId) {
        ModelAndView model = new ModelAndView();
        adsService.delete(Integer.parseInt(adsId));
        List<Ads> adsList = adsService.findAllAds();
        Collections.reverse(adsList);
        model.addObject("adsList", adsList);
        model.setViewName(DASHBOARD);
        return model;
    }
}
