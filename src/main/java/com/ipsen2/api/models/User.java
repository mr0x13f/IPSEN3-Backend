package com.ipsen2.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.security.Principal;

/**
 * Model containing data about a certain user, retrieved from the BasicAuthenticationService.
 *
 * @author TimvHal, Tim W
 * @version 14/10/2019
 */
public class User implements Principal {

    @JsonProperty("userId")
    private String userId;
    @JsonProperty("email")
    private String email;
    @JsonProperty("name")
    private String name;

    public User(String userId, String email, String name) {
        this.userId = userId;
        this.email = email;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
