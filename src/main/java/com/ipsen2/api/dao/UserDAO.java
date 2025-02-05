package com.ipsen2.api.dao;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
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

                userId = rs.getObject("user_id").toString();
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

                userId = rs.getObject("user_id").toString();
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

            ps.setObject(1, UUID.fromString(user.getUserId()));

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
            user.setSalt(BasicAuthenticationService.generateSalt());
            user.setPassword(BasicAuthenticationService.hashWithSalt(newPassword, user.getSalt()));

            PreparedStatement ps = DatabaseService.prepareQuery(
                    "UPDATE users SET password = ?, salt = ? WHERE user_id = ?;");

            ps.setString(1, user.getPassword());
            ps.setString(2, user.getSalt());
            ps.setObject(3, UUID.fromString(user.getUserId()));

            ResultSet rs = DatabaseService.executeQuery(ps);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Change a user's name
     *
     * @param user
     * @param newName
     * @author Tim W
     * @version 17/01/2020
     */
    public static void changeName(User user, String newName) {
        try {
            PreparedStatement ps = DatabaseService.prepareQuery(
                    "UPDATE users SET name = ? WHERE user_id = ?;");

            ps.setString(1, newName);
            ps.setObject(2, UUID.fromString(user.getUserId()));

            ResultSet rs = DatabaseService.executeQuery(ps);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
