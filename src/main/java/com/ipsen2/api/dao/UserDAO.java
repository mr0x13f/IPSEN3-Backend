package com.ipsen2.api.dao;

import com.ipsen2.api.models.User;
import com.ipsen2.api.services.DatabaseService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class for interacting with database revolving Users.
 *
 * @author TimvHal
 * @version 14/10/2019
 */
public class UserDAO {

    public static ArrayList<User> GETUserData() {
        PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM users");
        ResultSet rs = DatabaseService.executeQuery(ps);
        ArrayList<User> userList = new ArrayList<>();
        try {
            while(rs.next()) {
                String userId = rs.getString("userId");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String name = rs.getString("name");
                userList.add(new User(userId, email, password, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static String POSTUser(ArrayList<Object> uList) {
        try {
            for (Object o : uList) {
                User c = (User) o;
                String query = "INSERT INTO users VALUES(?,?,?,?);";
                PreparedStatement ps = DatabaseService.prepareQuery(query);
                ps.setString( 1, c.getUserId());
                ps.setString( 2, c.getEmail());
                ps.setString( 3, c.getPassword());
                ps.setString( 4, c.getName());
                DatabaseService.executeQuery(ps);
            }
            return "200 OK";
        } catch (java.sql.SQLException e) {
            return "500 SQL error";
        }
    }
}
