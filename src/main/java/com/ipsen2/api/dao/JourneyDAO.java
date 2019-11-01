package com.ipsen2.api.dao;

import com.ipsen2.api.models.Company;
import com.ipsen2.api.models.Journey;
import com.ipsen2.api.services.DatabaseService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Class for interacting with database revolving Journeys.
 *
 * @author TimvHal
 * @version 28/10/2019
 */
public class JourneyDAO {

    /**
     * Returns a single Journey.
     * @param creatorId as user identifier.
     * @param journeyId as journey identifier.
     * @return a Journey.
     * @author TimvHal
     * @version 31-10-2019
     */
    public static Journey getJourney(String creatorId, String journeyId) {
        Journey journey = null;
        try {
            PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM journeys WHERE creator_id = ? AND " +
                    "journey_id = ?;");
            ps.setObject(1, UUID.fromString(creatorId));
            ps.setObject(2, UUID.fromString(journeyId));
            ResultSet rs = DatabaseService.executeQuery(ps);

            while(rs.next()) {
                int kilometers = rs.getInt("kilometers");
                String destination = rs.getString("destination");
                String description = rs.getString("description");
                String date = rs.getString("date");
                String licensePlate = rs.getString("license_plate");
                boolean isBilled = rs.getBoolean("is_billed");
                double parkingCost = rs.getDouble("parking_cost");
                double otherCost = rs.getDouble("other_cost");
                double rate = rs.getDouble("rate");
                String projectId = rs.getString("project_id");

                journey = new Journey(journeyId, kilometers, destination, description, date, licensePlate, isBilled, parkingCost,
                        otherCost, rate, projectId, creatorId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return journey;
    }

    /**
     * Returns all journeys owned by a user.
     * @param creatorId as user identifier.
     * @return a Journey[].
     * @author TimvHal
     * @version 31-10-2019
     */
    public static Journey[] getJourneys(String creatorId) {
        ArrayList<Journey> jList = new ArrayList<>();
        try {
            PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM journeys WHERE creator_id = ?;");
            ps.setObject(1, UUID.fromString(creatorId));
            ResultSet rs = DatabaseService.executeQuery(ps);

            while(rs.next()) {
                String journeyId = rs.getString("journey_id");
                int kilometers = rs.getInt("kilometers");
                String destination = rs.getString("destination");
                String description = rs.getString("description");
                String date = rs.getString("date");
                String licensePlate = rs.getString("license_plate");
                boolean isBilled = rs.getBoolean("is_billed");
                double parkingCost = rs.getDouble("parking_cost");
                double otherCost = rs.getDouble("other_cost");
                double rate = rs.getDouble("rate");
                String projectId = rs.getString("project_id");

                jList.add(new Journey(journeyId, kilometers, destination, description, date, licensePlate, isBilled,
                        parkingCost, otherCost, rate, projectId, creatorId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Journey[] jArray = new Journey[jList.size()];
        for(int i = 0; i < jList.size(); i++) {
            jArray[i] = jList.get(i);
        }
        return jArray;
    }

    public static String postJourney(Object j) {
        try {
            Journey journey = (Journey) j;
            String query = "INSERT INTO journeys (kilometers, destination, description, date, license_plate, is_billed, " +
                    "parking_cost, other_cost, rate, project_id, creator_id) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = DatabaseService.prepareQuery(query);
            ps.setInt(1, journey.getKilometers());;
            ps.setString(2, journey.getDestination());
            ps.setString(3, journey.getDescription());

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            Date parsedDate = dateFormat.parse(journey.getDate());
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            ps.setObject(4, timestamp);
            ps.setString(5, journey.getLicensePlate());
            ps.setBoolean(6, journey.isBilled());
            ps.setDouble(7, journey.getParkingCost());
            ps.setDouble(8, journey.getOtherCost());
            ps.setDouble(9, journey.getRate());
            ps.setObject(10, UUID.fromString(journey.getProjectId()));
            ps.setObject(11, UUID.fromString(journey.getCreatorId()));
            DatabaseService.executeQuery(ps);
            return "200 OK";
        } catch (SQLException | ParseException e) {
            return "500 Error";
        }

    }

    public static String updateJourney(Object j) {
        try {
            Journey journey = (Journey) j;
            String query = "UPDATE journeys SET kilometers = ?, destination = ?, description = ?, " +
                        "date = ?, licensePlate = ?, isBilled = ?, parkingCost = ?, otherCost = ?, " +
                        "rate = ?, projectId = ?, creatorId = ? WHERE journeyId = ?;";
            PreparedStatement ps = DatabaseService.prepareQuery(query);
            ps.setInt(1, (journey.getKilometers()));
            ps.setString( 2, journey.getDestination());
            ps.setString( 3, journey.getDescription());
            ps.setString( 4, journey.getDate());
            ps.setString( 5, journey.getLicensePlate());
            ps.setBoolean(6, journey.isBilled());
            ps.setDouble( 7, journey.getParkingCost());
            ps.setDouble( 8, journey.getOtherCost());
            ps.setDouble(9, journey.getRate());
            ps.setString(10, journey.getProjectId());
            ps.setString(11, journey.getCreatorId());
            ps.setString(12, journey.getJourneyId());
            DatabaseService.executeQuery(ps);
            return "200 OK";
        }
        catch(java.sql.SQLException e) {
            return "500 Server Error";
        }
    }

    public static String deleteJourney(String journeyId) {
        try{
            String query = "DELETE FROM journeys WHERE journey_id = ?;";
            PreparedStatement ps = DatabaseService.prepareQuery(query);
            ps.setObject(1, UUID.fromString(journeyId));
            DatabaseService.executeQuery(ps);
            return "200 OK";
        }
        catch(java.sql.SQLException e) {
            e.printStackTrace();
            return "500 Server Error";
        }

    }
}
