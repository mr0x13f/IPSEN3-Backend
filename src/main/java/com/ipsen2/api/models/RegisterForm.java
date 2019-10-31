package com.ipsen2.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterForm {

    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("name")
    private String name;

    public RegisterForm(@JsonProperty("email") String email, @JsonProperty("password") String password, @JsonProperty("name") String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
