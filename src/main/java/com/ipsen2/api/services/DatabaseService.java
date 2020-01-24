package com.ipsen2.api.services;

import java.sql.*;

/**
 * Database Service for preparing and executing statements.
 *
 * @author TimvHal
 * @version 14/10/2019
 */
public class DatabaseService {

    private static final String DATABASE_IP = "83.86.21.169:5432";
    private static final String DATABASE_NAME = "ipsen2";
    private static final String DATABASE_USERNAME = "API";
    private static final String DATABASE_PASSWORD = "fyNY7cMuB5VGVf9FfxP6";

//    private String conUrl = "jdbc:sqlserver://83.86.21.169:5432;"
//            + "database=ipsen2;"
//            + "user=API@83.86.21.169;"
//            + "password=fyNY7cMuB5VGVf9FfxP6;"
//            + "encrypt=false;"
//            + "loginTimeout=30;";
    private static Connection con;
//    {
//        try {
//            con = DriverManager.getConnection(conUrl);
//            System.out.println("hallo" + con.toString());
//            //con = DriverManager.getConnection("jdbc:mysql://83.86.21.169:5432", "API", "fyNY7cMuB5VGVf9FfxP6");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


    public static PreparedStatement prepareQuery(String query) {
        PreparedStatement ps = null;
        try {
            con = DriverManager.getConnection("jdbc:postgresql://"+DATABASE_IP+"/"+DATABASE_NAME, DATABASE_USERNAME,
                    DATABASE_PASSWORD);
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
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
}
