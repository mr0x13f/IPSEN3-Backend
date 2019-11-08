package com.ipsen2.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Used to read fields from password reset body.
 *
 * @author Tim W
 * @version 30/10/2019
 */
public class PasswordResetForm {

    @JsonProperty("password")
    private String password;

    public PasswordResetForm(@JsonProperty("password") String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
