package com.ipsen2.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterForm {

    @JsonProperty("email")
    private String email;
    @JsonProperty("name")
    private String name;
    @JsonProperty("password")
    private String password;

    public RegisterForm(@JsonProperty("email") String email, @JsonProperty("name") String name, @JsonProperty("password") String password) {
        this.email = email;
        this.password = password;
        this.name = name;
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
}
