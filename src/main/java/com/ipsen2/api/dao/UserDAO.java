package com.ipsen2.api.dao;

import com.ipsen2.api.models.User;
import com.ipsen2.api.services.DatabaseService;
import io.dropwizard.auth.basic.BasicCredentials;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Class for interacting with database revolving Users.
 *
 * @author TimvHal
 * @version 28/10/2019
 */
public class UserDAO {

    public static Optional<User> getUser(BasicCredentials credentials) {
        try {
            PreparedStatement ps = DatabaseService.prepareQuery(
                "SELECT u.user_id, u.email, u.name FROM users u " +
                "WHERE u.email = ? " +
                "AND crypt(?, u.password) = u.password;");

            ps.setString(1, credentials.getUsername());
            ps.setString(2, credentials.getPassword());

            ResultSet rs = DatabaseService.executeQuery(ps);
            ArrayList<User> userList = new ArrayList<>();

            String userId = "";
            String email = "";
            String name = "";


            int resultCount = 0;
            while(rs.next()) {
                resultCount++;

                userId = rs.getString("user_id");
                email = rs.getString("email");
                name = rs.getString("name");
            }

            if (resultCount == 1) {
                User user = new User(userId, email, name);
                return Optional.of(user);
            } else {
                return Optional.empty();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
