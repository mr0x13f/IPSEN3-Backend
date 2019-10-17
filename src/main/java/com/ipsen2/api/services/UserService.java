package com.ipsen2.api.services;

import com.ipsen2.api.dao.UserDAO;
import com.ipsen2.api.models.User;

import java.util.ArrayList;

/**
 * Service for handling and completing requests revolving users.
 *
 * @author TimvHal
 * @version 14/10/2019
 */
public class UserService {

    public static ArrayList<User> GETUserList() {
        return UserDAO.GETUserData();
    }

    public static String POSTUser(ArrayList<Object> uList) {
        return UserDAO.POSTUser(uList);
    }
}
