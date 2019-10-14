package com.ipsen2.api.services;

import com.ipsen2.api.models.Rate;

/**
 * Service for handling and completing requests revolving rates.
 *
 * @author TimvHal
 */
public class RateService {

    public static Rate GETRateData() {
        Rate r = new Rate("1", 1.00);
        return r;
    }
}
