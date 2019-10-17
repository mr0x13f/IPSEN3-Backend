package com.ipsen2.api.dao;

import com.ipsen2.api.models.Vehicle;
import com.ipsen2.api.services.DatabaseService;
import com.ipsen2.api.services.JacksonService;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class for interacting with database revolving Vehicles.
 *
 * @author TimvHal
 * @version 16/10/2019
 */
public class VehicleDAO {

    public static ArrayList<Vehicle> GETVehicleData() {
        PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM vehicles");
        ResultSet rs = DatabaseService.executeQuery(ps);
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        try {
              while(rs.next()) {
                  String licensePlate = rs.getString("licensePlate");
                  String description = rs.getString("description");
                  vehicleList.add(new Vehicle(licensePlate, description));
              }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicleList;
    }

    public static String POSTVehicle(ArrayList<Object> vList) {
        String query = "";
        for(Object o : vList) {
            Vehicle v = (Vehicle) o;
            query = query + "INSERT INTO vehicles VALUES(" + v.getLicensePlate() + ", " + v.getDescription() + ")";
        }
        PreparedStatement ps = DatabaseService.prepareQuery(query);
        DatabaseService.executeQuery(ps);
        return "200 OK";
    }
}
