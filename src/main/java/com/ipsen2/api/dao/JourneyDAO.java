package com.ipsen2.api.dao;

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
 * @version 14/10/2019
 */
public class JourneyDAO {

    public static ArrayList<Journey> GETJourneyData() {
        PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM journeys");
        ResultSet rs = DatabaseService.executeQuery(ps);
        ArrayList<Journey> journeyList = new ArrayList<>();

        try {
            while(rs.next()) {
                int journeyId = rs.getInt("journeyId");
                int km = rs.getInt("kilometers");
                String lPlate = rs.getString("vehicleLicensePlate");
                String dest = rs.getString("destination");
                int rateId = rs.getInt("rateId");
                int projectId = rs.getInt("projectId");
                String desc = rs.getString("description");
                double parkingC = rs.getDouble("parkingCost");
                double otherC = rs.getDouble("otherCost");
                int creatorId = rs.getInt("creatorId");
                boolean isBilled = rs.getBoolean("isBilled");

                journeyList.add(new Journey(journeyId, km, lPlate, dest, rateId, projectId,
                        desc, parkingC, otherC, creatorId, isBilled));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return journeyList;
    }

    public static String POSTJourney(ArrayList<Object> jList) {
        String query = "";
        for(Object o : jList) {
            Journey j = (Journey) o;
            query = query + "INSERT INTO journeys VALUES(" + j.getJourneyId() + ", " + j.getKilometers() + ", "
                    + j.getVehicleLicensePlate() + ", " + j.getDestination() + ", " + j.getRateId() + ", " + j.getProjectId()
                    + ", " + j.getDescription() + ", " + j.getParkingCost() + ", " + j.getOtherCost() + ", "
                    + j.getCreatorId() + ", " + j.isBilled() + ");";
        }
        PreparedStatement ps = DatabaseService.prepareQuery(query);
        DatabaseService.executeQuery(ps);
        return "200 OK";

    }
}
