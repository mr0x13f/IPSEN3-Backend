package com.ipsen2.api.dao;

import com.ipsen2.api.models.Journey;
import com.ipsen2.api.models.User;
import com.ipsen2.api.services.DatabaseService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class for interacting with database revolving Journeys.
 *
 * @author TimvHal
 * @version 28/10/2019
 */
public class JourneyDAO {

    public static ArrayList<Journey> getJourney(User user) {

        ArrayList<Journey> journeyList = new ArrayList<>();
        try {
            PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM journeys WHERE creatorId = ?;");
            ps.setString(1, user.getUserId());

            ResultSet rs = DatabaseService.executeQuery(ps);

            while(rs.next()) {

                String journeyId = rs.getString("journeyId");
                int kilometers = rs.getInt("kilometers");
                String destination = rs.getString("destination");
                String description = rs.getString("description");
                String date = rs.getString("date");
                String licensePlate = rs.getString("licensePlate");
                boolean isBilled = rs.getBoolean("isBilled");
                double parkingCost = rs.getDouble("parkingCost");
                double otherCost = rs.getDouble("otherCost");
                double rate = rs.getDouble("rate");
                String projectId = rs.getString("projectId");
                String creatorId = rs.getString("creatorId");

                journeyList.add(new Journey(journeyId, kilometers, destination, description, date, licensePlate, isBilled, parkingCost, otherCost, rate, projectId, creatorId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return journeyList;
    }

    public static String postJourney(ArrayList<Object> jList, User user) {
        try {
            for (Object o : jList) {
                Journey j = (Journey) o;
                String query = "INSERT INTO journeys VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
                PreparedStatement ps = DatabaseService.prepareQuery(query);
                ps.setString( 1, j.getJourneyId());
                ps.setInt(    2, j.getKilometers());;
                ps.setString( 3, j.getDestination());
                ps.setString( 4, j.getDescription());
                ps.setString( 5, j.getDate());
                ps.setString( 6, j.getLicensePlate());
                ps.setBoolean(7, j.isBilled());
                ps.setDouble( 8, j.getParkingCost());
                ps.setDouble( 9, j.getOtherCost());
                ps.setDouble(10, j.getRate());
                ps.setString(11, j.getProjectId());
                ps.setString(12, user.getUserId());
                DatabaseService.executeQuery(ps);
            }
            return "200 OK";
        } catch (java.sql.SQLException e) {
            return "500 SQL error";
        }

    }
}
