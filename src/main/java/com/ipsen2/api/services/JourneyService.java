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

    public static ArrayList<Journey> getJourney(String journeyId) {
        return JourneyDAO.getJourney(journeyId);
    }

    public static ArrayList<Journey> getJourney() {
        return JourneyDAO.getJourney(null);
    }

    public static String postJourney(ArrayList<Object> jList) {
        return JourneyDAO.postJourney(jList);
    }

    public static String updateJourney(ArrayList<Object> jList) {
        return JourneyDAO.updateJourney(jList);
    }

    public static String deleteJourney(ArrayList<Object> jList) {
        return JourneyDAO.deleteJourney(jList);
    }
}
