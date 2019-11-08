package com.ipsen2.api.dao;

import com.ipsen2.api.models.RegisterForm;
import com.ipsen2.api.models.User;
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
 * @version 28/10/2019
 */
public class UserDAO {

    /**
     * Authenticate existing user
     *
     * @param credentials
     * @return (Optional) user object
     * @author Tim W
     * @version 30/10/2019
     */
    public static Optional<User> getUser(BasicCredentials credentials) {
        try {
            PreparedStatement ps = DatabaseService.prepareQuery(
                "SELECT u.user_id, u.email, u.name FROM users u " +
                "WHERE u.email = ? " +
                "AND crypt(?, u.password) = u.password;");

            ps.setString(1, credentials.getUsername());
            ps.setString(2, credentials.getPassword());

            ResultSet rs = DatabaseService.executeQuery(ps);

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

    /**
     * Register new user
     *
     * @param registerForm
     * @author Tim W
     * @version 30/10/2019
     */
    public static void registerUser(RegisterForm registerForm) {
        try {
            PreparedStatement ps = DatabaseService.prepareQuery(
                    "INSERT INTO users (email,name,password) VALUES (?,?, crypt(?, gen_salt('bf')));");

            ps.setString(1, registerForm.getEmail());
            ps.setString(2, registerForm.getName());
            ps.setString(3, registerForm.getPassword());

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
            PreparedStatement ps = DatabaseService.prepareQuery(
                    "UPDATE users SET password = crypt(?, gen_salt('bf')) WHERE user_id = ?;");

            ps.setString(1, newPassword);
            ps.setObject(2, UUID.fromString(user.getUserId()));

            ResultSet rs = DatabaseService.executeQuery(ps);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
