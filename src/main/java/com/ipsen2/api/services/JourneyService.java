package com.ipsen2.api.services;

import com.ipsen2.api.models.Journey;

/**
 * Service for handling and completing requests revolving journeys.
 *
 * @author TimvHal
 */
public class JourneyService {

    public static Journey GETJourneyData() {
        //TODO implement SQL-method in DAO layer to get JSON.
        Journey journey = new Journey(1, 1, "1", "1", 1, 1, "1",
                1.00, 1.00, 1, true);
        return journey;
    }
}
