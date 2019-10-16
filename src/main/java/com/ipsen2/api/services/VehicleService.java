package com.ipsen2.api.services;
import com.ipsen2.api.dao.VehicleDAO;
import com.ipsen2.api.models.Vehicle;

import java.util.ArrayList;

/**
 * Service for handling and completing requests revolving companies.
 *
 * @author TimvHal
 * @version 16/10/2019
 */
public class VehicleService {

    public static ArrayList<Vehicle> GETVehicleList() {
        return VehicleDAO.GETVehicleData();
    }

    public static String POSTVehicle(ArrayList<Object> vList) {
        return VehicleDAO.POSTVehicle(vList);
    }
}
