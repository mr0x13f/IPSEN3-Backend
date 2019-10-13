package com.ipsen2.api.services;
import com.ipsen2.api.models.Vehicle;

/**
 * Service for handling and completing requests revolving companies.
 *
 * @author TimvHal
 */
public class VehicleService {

    private static VehicleService vService;

    static {
        vService = new VehicleService();
    }

    private VehicleService() {

    }

    public static VehicleService getInstance() {
        return vService;
    }

    public Vehicle GETVehicleData() {
        //TODO implement SQL-method in models layer to get JSON.
        Vehicle vehicle = new Vehicle("1", "1");
        return vehicle;
    }


}
