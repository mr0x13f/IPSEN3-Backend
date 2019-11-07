package com.ipsen2.api.services;

import com.ipsen2.api.dao.JourneyDAO;
import com.ipsen2.api.models.Journey;
import com.ipsen2.api.models.User;

import java.util.ArrayList;

/**
 * Service for handling and completing requests revolving journeys.
 *
 * @author TimvHal, Tim W
 * @version 28/10/2019
 */
public class JourneyService {

    public static Journey getJourney(String creatorId, String journeyId) {
        return JourneyDAO.getJourney(creatorId, journeyId);
    }

    public static Journey[] getJourneys(String creatorId) {
        return JourneyDAO.getJourneys(creatorId);
    }

    public static String postJourney(Journey j) {
        return JourneyDAO.postJourney(j);
    }

    public static String updateJourney(Journey j) {
        return JourneyDAO.updateJourney(j);
    }

    public static String deleteJourney(String creatorId, String journeyId) {
        return JourneyDAO.deleteJourney(creatorId, journeyId);
    }
}
