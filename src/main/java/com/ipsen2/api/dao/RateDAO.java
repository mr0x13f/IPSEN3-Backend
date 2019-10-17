package com.ipsen2.api.dao;

import com.ipsen2.api.models.Company;
import com.ipsen2.api.models.Rate;
import com.ipsen2.api.services.DatabaseService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class for interacting with database revolving Rates.
 *
 * @author TimvHal
 * @version 14/10/2019
 */
public class RateDAO {

    public static ArrayList<Rate> GETRateData() {
        PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM rates");
        ResultSet rs = DatabaseService.executeQuery(ps);
        ArrayList<Rate> rateList = new ArrayList<>();

        try {
            while(rs.next()) {
                String name = rs.getString("name");
                double amount = rs.getDouble("amount");
                rateList.add(new Rate(name, amount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rateList;
    }

    public static String POSTRate(ArrayList<Object> rList) {
        String query = "";
        for(Object o : rList) {
            Rate r = (Rate) o;
            query = query + "INSERT INTO rates VALUES(" + r.getName() + ", " + r.getAmount() + ")";

        }
        PreparedStatement ps = DatabaseService.prepareQuery(query);
        DatabaseService.executeQuery(ps);
        return "200 OK";
    }
}
