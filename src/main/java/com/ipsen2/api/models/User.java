package com.ipsen2.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model containing data about a certain user.
 *
 * @author TimvHal, Tim W
 * @version 14/10/2019
 */
public class User {

    @JsonProperty("userId")
    private int userId;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("name")
    private String name;

    public User(int id, String email, String password, String name) {
        this.userId = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
