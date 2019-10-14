package com.ipsen2.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model containing data about a certain vehicle.
 *
 * @author TimvHal, Tim W
 * @version 14/10/2019
 */
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
