package com.ipsen2.api.services;

import com.ipsen2.api.dao.JourneyDAO;
import com.ipsen2.api.models.Journey;
import com.ipsen2.api.models.User;

import java.util.ArrayList;

/**
 * Service for handling and completing requests revolving journeys.
 *
 * @author TimvHal
 * @version 28/10/2019
 */
public class JourneyService {

    public static ArrayList<Journey> getJourney(User user) {
        return JourneyDAO.getJourney(user);
    }

    public static String postJourney(ArrayList<Object> jList, User user) {
        return JourneyDAO.postJourney(jList, user);
    }
}
