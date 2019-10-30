package com.ipsen2.api.dao;

import com.ipsen2.api.models.Company;
import com.ipsen2.api.models.Journey;
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

    public static ArrayList<Journey> getJourney(String id) {
        ArrayList<Journey> journeyList = new ArrayList<>();
        if(id == null) {
            PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM journeys");
            ResultSet rs = DatabaseService.executeQuery(ps);

            try {
                while (rs.next()) {

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
        }
        else {
            try {
                    PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM journeys WHERE journeyId = ?;");
                    ps.setString(1, id);
                    ResultSet rs = DatabaseService.executeQuery(ps);
                    rs.next();
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

                    journeyList.add(new Journey(journeyId, kilometers, destination, description, date, licensePlate,
                            isBilled, parkingCost, otherCost, rate, projectId, creatorId));

            }
            catch(java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return journeyList;
    }

    public static String postJourney(ArrayList<Object> jList) {
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
                ps.setString(12, j.getCreatorId());
                DatabaseService.executeQuery(ps);
            }
            return "200 OK";
        } catch (java.sql.SQLException e) {
            return "500 SQL error";
        }

    }

    public static String updateJourney(ArrayList<Object> jList) {
        try {
            for(Object o : jList) {
                Journey j = (Journey) o;
                String query = "UPDATE journeys SET kilometers = ?, destination = ?, description = ?, " +
                        "date = ?, licensePlate = ?, isBilled = ?, parkingCost = ?, otherCost = ?, " +
                        "rate = ?, projectId = ?, creatorId = ? WHERE journeyId = ?;";
                PreparedStatement ps = DatabaseService.prepareQuery(query);
                ps.setInt(1, (j.getKilometers()));
                ps.setString( 2, j.getDestination());
                ps.setString( 3, j.getDescription());
                ps.setString( 4, j.getDate());
                ps.setString( 5, j.getLicensePlate());
                ps.setBoolean(6, j.isBilled());
                ps.setDouble( 7, j.getParkingCost());
                ps.setDouble( 8, j.getOtherCost());
                ps.setDouble(9, j.getRate());
                ps.setString(10, j.getProjectId());
                ps.setString(11, j.getCreatorId());
                ps.setString(12, j.getJourneyId());
                DatabaseService.executeQuery(ps);
            }
            return "200 OK";
        }
        catch(java.sql.SQLException e) {
            return "500 Server Error";
        }
    }

    public static String deleteJourney(ArrayList<Object> jList) {
        try{
            for(Object o: jList) {
                Journey j = (Journey) o;
                String query = "DELETE FROM journeys WHERE journeyId = ?;";
                PreparedStatement ps = DatabaseService.prepareQuery(query);
                ps.setString(1, j.getJourneyId());
                DatabaseService.executeQuery(ps);
            }
            return "200 OK";
        }
        catch(java.sql.SQLException e) {
            e.printStackTrace();
            return "500 Server Error";
        }

    }
}
