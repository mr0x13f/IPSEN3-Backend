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
 * @author TimvHal
 * @version 28/10/2019
 */
public class UserService {

    public static Optional<User> getUser(BasicCredentials credentials) {
        return UserDAO.getUser(credentials);
    }

    public static void registerUser(String registerData) {

        // TIJDELIJK totdat Jacksonservice wordt geupdate

        try {
            ObjectMapper mapper = new ObjectMapper();
            RegisterForm registerForm = mapper.readValue(registerData, mapper.getTypeFactory().constructType(RegisterForm.class));

            if (registerForm.getPassword().length() < 8
            || registerForm.getName().length() < 2
            || !registerForm.getEmail().contains("@")) {
                return; // Foutieve registratie
            }

            UserDAO.registerUser(registerForm);

        }catch(com.fasterxml.jackson.core.JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
