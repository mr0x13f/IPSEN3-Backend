package com.ipsen2.api.dao;

import com.ipsen2.api.models.Company;
import com.ipsen2.api.services.DatabaseService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class for interacting with database revolving Companies.
 *
 * @author TimvHal
 * @version 28/10/2019
 */
public class CompanyDAO {

    public static ArrayList<Company> getCompany() {
        PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM companies");
        ResultSet rs = DatabaseService.executeQuery(ps);
        ArrayList<Company> companyList = new ArrayList<>();

        try {
            while(rs.next()) {
                String companyId = rs.getString("companyId");
                String name = rs.getString("name");

                companyList.add(new Company(companyId, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companyList;
    }

    public static String postCompany(ArrayList<Object> cList) {
        try {
            for (Object o : cList) {
                Company c = (Company) o;
                String query = "INSERT INTO companies VALUES(?,?);";
                PreparedStatement ps = DatabaseService.prepareQuery(query);
                ps.setString( 1, c.getCompanyId());
                ps.setString( 2, c.getName());
                DatabaseService.executeQuery(ps);
            }
            return "200 OK";
        } catch (java.sql.SQLException e) {
            return "500 SQL error";
        }
    }
}
