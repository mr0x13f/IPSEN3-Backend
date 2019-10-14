package com.ipsen2.api.dao;

import com.ipsen2.api.models.Vehicle;
import com.ipsen2.api.services.DatabaseService;

import java.sql.*;
import java.util.ArrayList;

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

}
