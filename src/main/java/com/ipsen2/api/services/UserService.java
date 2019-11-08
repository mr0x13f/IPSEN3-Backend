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

/**
 * Service for handling and completing requests revolving users.
 *
 * @author TimvHal, Tim W
 * @version 28/10/2019
 */
public class UserService {

    public static Optional<User> getUser(BasicCredentials credentials) {
        return UserDAO.getUser(credentials);
    }

    public static void deleteUser(User user) { UserDAO.deleteUser(user); }

    public static boolean registerUser(String registerData) {

        RegisterForm registerForm = (RegisterForm) JacksonService.readValue(registerData, RegisterForm.class);

        if (registerForm.getPassword().length() < 8
                || registerForm.getName().length() < 2
                || !registerForm.getEmail().contains("@")) {
            return false; // Foutieve registratie
        }

        UserDAO.registerUser(registerForm);
        return true; // Successvolle registratie

    }

}
