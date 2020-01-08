package com.ipsen2.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String userId;
    @JsonProperty("email")
    private String email;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String salt;



    public User(String userId, RegisterForm registerForm) {
        this.userId = userId;
        this.email = registerForm.getEmail();
        this.name = registerForm.getName();
        this.password = registerForm.getPassword();
    }

    public User(String userId, String email, String name, String password, String salt) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.password = password;
        this.salt = salt;
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
