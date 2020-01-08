package com.ipsen2.api.dao;

import com.ipsen2.api.models.Company;
import com.ipsen2.api.services.DatabaseService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Class for interacting with database revolving Companies.
 *
 * @author TimvHal, Tim W
 * @version 03/11/2019
 */
public class CompanyDAO {

    public static Company getCompany(String companyId) {
        String name = "";
        try {
            PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM companies WHERE company_id = ?;");
            ps.setObject(1, UUID.fromString(companyId));
            ResultSet rs = DatabaseService.executeQuery(ps);

            while(rs.next()) {
                name = rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Company(companyId, name);
    }

    public static Company[] getCompanies() {
        ArrayList<Company> cList = new ArrayList<>();
        try {
            PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM companies;");
            ResultSet rs = DatabaseService.executeQuery(ps);
            while(rs.next()) {
                String companyId = rs.getString("company_id");
                String name = rs.getString("name");
                cList.add(new Company(companyId, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Company[] cArray = new Company[cList.size()];
        for(int i = 0; i < cList.size(); i++) {
            cArray[i] = cList.get(i);
        }
        return cArray;
    }

    public static String postCompany(Company c) {
        try {
            String query = "INSERT INTO companies (name) VALUES(?);";
            PreparedStatement ps = DatabaseService.prepareQuery(query);
            ps.setString( 1, c.getName());
            DatabaseService.executeQuery(ps);
            return "200 OK";
        }
        catch (java.sql.SQLException e) {
            return "500 Server Error";
        }
    }

    public static String updateCompany(Company c) {
        try {
            String query = "UPDATE companies SET name = ? WHERE company_id = ?;";
            PreparedStatement ps = DatabaseService.prepareQuery(query);
            ps.setString(1, c.getName());
            ps.setObject(2, UUID.fromString(c.getCompanyId()));
            DatabaseService.executeQuery(ps);
            return "200 OK";
        }
        catch(java.sql.SQLException e) {
            return "500 Server Error";
        }
    }

    public static String deleteCompany(String companyId) {
        try{
            String query = "DELETE FROM companies WHERE company_id = ?;";
            PreparedStatement ps = DatabaseService.prepareQuery(query);
            ps.setObject(1, UUID.fromString(companyId));
            DatabaseService.executeQuery(ps);
            return "200 OK";
        }
        catch(java.sql.SQLException e) {
            e.printStackTrace();
            return "500 Server Error";
        }

    }


}
