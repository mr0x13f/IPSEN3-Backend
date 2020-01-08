package com.ipsen2.api.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipsen2.api.dao.UserDAO;
import com.ipsen2.api.models.RegisterForm;
import com.ipsen2.api.models.User;
import io.dropwizard.auth.basic.BasicCredentials;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

/**
 * Service for handling and completing requests revolving users.
 *
 * @author TimvHal, Tim W
 * @version 28/10/2019
 */
public class UserService {

    public static Optional<User> getUserByCredentials(BasicCredentials credentials) {
        return UserDAO.getUserByCredentials(credentials);
    }

    public static Optional<User> getUserById(String userId) {
        return UserDAO.getUserById(userId);
    }

    public static void deleteUser(User user) { UserDAO.deleteUser(user); }

    public static boolean registerUser(String registerData) {

        RegisterForm registerForm = (RegisterForm) JacksonService.readValue(registerData, RegisterForm.class);

        if (registerForm.getPassword().length() < 8
                || registerForm.getName().length() < 2
                || !registerForm.getEmail().contains("@")) {
            return false; // Foutieve registratie
        }
        User user = new User(UUID.randomUUID(), registerForm);
        user.setSalt(AuthenticationService.generateSalt());
        user.setPassword(AuthenticationService.hashWithSalt(user.getSalt(), user.getPassword()));

        UserDAO.registerUser(user);
        return true; // Successvolle registratie

    }

    public static void resetPassword(User user, String newPassword) {UserDAO.resetPassword(user, newPassword);
    }

}
