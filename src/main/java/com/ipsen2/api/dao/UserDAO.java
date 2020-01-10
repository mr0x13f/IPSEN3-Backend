package com.ipsen2.api.dao;

import com.ipsen2.api.models.RegisterForm;
import com.ipsen2.api.models.User;
import com.ipsen2.api.services.BasicAuthenticationService;
import com.ipsen2.api.services.DatabaseService;
import io.dropwizard.auth.basic.BasicCredentials;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

/**
 * Class for interacting with database revolving Users.
 *
 * @author TimvHal, Tim W
 * @version 08-01-2020
 */
public class UserDAO {

    /**
     * Retrieve User from database
     *
     * @param _userId
     * @return (Optional) user object
     * @author Tim W
     * @version 08/01/2020
     */
    public static Optional<User> getUserById(String _userId) {
        try {
            PreparedStatement ps = DatabaseService.prepareQuery(
                    "SELECT u.user_id, u.email, u.name, u.password, u.salt FROM users u " +
                            "WHERE u.user_id = ? ");

            ps.setObject(1, UUID.fromString(_userId));

            ResultSet rs = DatabaseService.executeQuery(ps);

            String userId = "";
            String email = "";
            String name = "";
            String password = "";
            String salt = "";

            int resultCount = 0;
            while(rs.next()) {
                resultCount++;

                userId = rs.getString("user_id");
                email = rs.getString("email");
                name = rs.getString("name");
                password = rs.getString("password");
                salt = rs.getString("salt");
            }

            if (resultCount == 1) {
                User user = new User(userId, email, name, password, salt);
                return Optional.of(user);
            } else {
                return Optional.empty();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    /**
     * Authenticate existing user
     *
     * @param credentials
     * @return (Optional) user object
     * @author Tim W, TimvHal
     * @version 08-01-2020
     */
    public static Optional<User> getUserByCredentials(BasicCredentials credentials) {
        try {
            PreparedStatement ps = DatabaseService.prepareQuery(
                "SELECT u.user_id, u.email, u.name, u.password, u.salt FROM users u " +
                "WHERE u.email = ?;");

            ps.setString(1, credentials.getUsername());

            ResultSet rs = DatabaseService.executeQuery(ps);

            String userId = "";
            String email = "";
            String name = "";
            String password = "";
            String salt = "";

            int resultCount = 0;
            while(rs.next()) {
                resultCount++;

                userId = rs.getString("user_id");
                email = rs.getString("email");
                name = rs.getString("name");
                password = rs.getString("password");
                salt = rs.getString("salt");
            }

            if (resultCount == 1) {
                User user = new User(userId, email, name, password, salt);
                return Optional.of(user);
            } else {
                return Optional.empty();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    /**
     * Register new user
     *
     * @param user
     * @author Tim W, TimvHal
     * @version 08-01-2020
     */
    public static void registerUser(User user) {
        try {
            PreparedStatement ps = DatabaseService.prepareQuery(
                    "INSERT INTO users VALUES(?,?,?,?,?);");

            ps.setObject(1, UUID.fromString(user.getUserId()));
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getName());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getSalt());

            ResultSet rs = DatabaseService.executeQuery(ps);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete existing user
     *
     * @param user User to delete
     * @author Tim W
     * @version 08/11/2019
     */
    public static void deleteUser(User user) {
        try {
            PreparedStatement ps = DatabaseService.prepareQuery(
                    "DELETE FROM users WHERE user_id = ?;");

            ps.setObject(1, user.getUserId());

            ResultSet rs = DatabaseService.executeQuery(ps);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Change a user's password
     *
     * @param user
     * @param newPassword
     */
    public static void resetPassword(User user, String newPassword) {
        try {
            user.setPassword(BasicAuthenticationService.hashWithSalt(user.getSalt(), newPassword));
            PreparedStatement ps = DatabaseService.prepareQuery(
                    "UPDATE users SET password = ? WHERE user_id = ?;");

            ps.setString(1, user.getPassword());
            ps.setObject(2, user.getUserId());

            ResultSet rs = DatabaseService.executeQuery(ps);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
