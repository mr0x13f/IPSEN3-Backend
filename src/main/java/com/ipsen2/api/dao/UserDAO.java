package com.ipsen2.api.dao;

import com.ipsen2.api.models.User;
import com.ipsen2.api.models.Vehicle;
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
                int id = rs.getInt("userId");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String name = rs.getString("name");
                userList.add(new User(id, email, password, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static String POSTUser(ArrayList<Object> uList) {
        String query = "";
        for(Object o : uList) {
            User u = (User) o;
            query = query + "INSERT INTO vehicles VALUES(" + u.getUserId() + ", " + u.getEmail() + ", " + u.getPassword()
        + ", " + u.getName() + ")";
        }
        PreparedStatement ps = DatabaseService.prepareQuery(query);
        DatabaseService.executeQuery(ps);
        return "200 OK";
    }
}
