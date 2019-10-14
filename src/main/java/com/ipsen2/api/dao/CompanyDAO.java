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
 * @version 14/10/2019
 */
public class CompanyDAO {

    public static ArrayList<Company> GETCompanyData() {
        PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM companies");
        ResultSet rs = DatabaseService.executeQuery(ps);
        ArrayList<Company> companyList = new ArrayList<>();

        try {
            while(rs.next()) {
                int id = rs.getInt("companyId");
                String name = rs.getString("name");

                companyList.add(new Company(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companyList;
    }
}
