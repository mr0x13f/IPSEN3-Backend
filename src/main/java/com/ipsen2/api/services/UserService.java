package com.ipsen2.api.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ipsen2.api.dao.UserDAO;
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

    public static void createUser(String registerData) {



    }

}
