package com.ipsen2.api.services;

import com.ipsen2.api.dao.JourneyDAO;
import com.ipsen2.api.models.Journey;

import java.util.ArrayList;

/**
 * Service for handling and completing requests revolving journeys.
 *
 * @author TimvHal
 * @version 28/10/2019
 */
public class JourneyService {

    public static Journey getJourney(String creatorId, String journeyId) {
        return JourneyDAO.getJourney(creatorId, journeyId);
    }

    public static Journey[] getJourneys(String creatorId) {
        return JourneyDAO.getJourneys(creatorId);
    }

    public static String postJourney(Object j) {
        return JourneyDAO.postJourney(j);
    }

    public static String updateJourney(Object j) {
        return JourneyDAO.updateJourney(j);
    }

    public static String deleteJourney(String journeyId) {
        return JourneyDAO.deleteJourney(journeyId);
    }
}
