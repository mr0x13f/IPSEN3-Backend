package com.ipsen2.api.services;

import java.sql.*;

/**
 * Database Service for preparing and executing statements.
 *
 * @author TimvHal
 * @version 14/10/2019
 */
public class DatabaseService {
    private String conUrl = "jdbc:sqlserver://83.86.21.169:5432;"
            + "database=ipsen2;"
            + "user=API@83.86.21.169;"
            + "password=fyNY7cMuB5VGVf9FfxP6;"
            + "encrypt=false;"
            + "loginTimeout=30;";
    private static Connection con;
    {
        try {
            con = DriverManager.getConnection(conUrl);
            System.out.println("hallo" + con.toString());
            //con = DriverManager.getConnection("jdbc:mysql://83.86.21.169:5432", "API", "fyNY7cMuB5VGVf9FfxP6");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static PreparedStatement prepareQuery(String query) {
        PreparedStatement ps = null;
        try {
            con = DriverManager.getConnection("jdbc:postgresql://83.86.21.169:5432/ipsen2", "iipsen2", "VPX3zd4a");
            ps = con.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public static ResultSet executeQuery(PreparedStatement ps) {
        ResultSet rs = null;
        try {
            ps.execute();
            rs = ps.getResultSet();
            } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }
}
