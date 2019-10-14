package com.ipsen2.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vehicle {

    @JsonProperty("licensePlate")
    private String licensePlate;
    @JsonProperty("description")
    private String description;

    public Vehicle(String licensePlate, String description) {
        this.licensePlate = licensePlate;
        this.description = description;
    }
}
