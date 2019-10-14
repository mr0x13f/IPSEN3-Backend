package com.ipsen2.api.services;
import com.ipsen2.api.models.Vehicle;

/**
 * Service for handling and completing requests revolving companies.
 *
 * @author TimvHal
 */
public class VehicleService {

    public static Vehicle GETVehicleData() {
        //TODO implement SQL-method in DAO layer to get JSON.
        Vehicle vehicle = new Vehicle("1", "1");
        return vehicle;
    }


}
