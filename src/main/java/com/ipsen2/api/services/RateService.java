package com.ipsen2.api.services;

import com.ipsen2.api.dao.RateDAO;
import com.ipsen2.api.models.Rate;

import java.util.ArrayList;

/**
 * Service for handling and completing requests revolving rates.
 *
 * @author TimvHal
 * @version 14/10/2019
 */
public class RateService {

    public static ArrayList<Rate> GETRateList() {
        return RateDAO.GETRateData();
    }

    public static String POSTRate(ArrayList<Object> rList) {
        return RateDAO.POSTRate(rList);
    }
}
