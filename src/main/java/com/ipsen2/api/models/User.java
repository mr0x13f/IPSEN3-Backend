package com.ipsen2.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.security.Principal;
import java.util.UUID;

/**
 * Model containing data about a certain user, retrieved from the BasicAuthenticationService.
 *
 * @author TimvHal, Tim W
 * @version 14/10/2019
 */
public class User implements Principal {

    @JsonProperty("userId")
    private UUID userId;
    @JsonProperty("email")
    private String email;
    @JsonProperty("name")
    private String name;
    @JsonProperty("password")
    private String password;
    @JsonProperty("salt")
    private String salt;



    public User(UUID userId, RegisterForm registerForm) {
        this.userId = userId;
        this.email = registerForm.getEmail();
        this.name = registerForm.getName();
        this.password = registerForm.getPassword();
    }

    public User(UUID userId, String email, String name, String password, String salt) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.password = password;
        this.salt = salt;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
