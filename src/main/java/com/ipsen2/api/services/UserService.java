package com.ipsen2.api.services;

import com.ipsen2.api.models.User;

/**
 * Service for handling and completing requests revolving users.
 *
 * @author TimvHal
 */
public class UserService {

    public static User GETUserData() {
        //TODO use DAO method.
        User user = new User("1", "1", "1");
        return user;
    }
}
