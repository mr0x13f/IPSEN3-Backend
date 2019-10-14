package com.ipsen2.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model containing data about a certain rate.
 *
 * @author TimvHal, Tim W
 * @version 14/10/2019
 */
public class Rate {

    @JsonProperty("name")
    private String name;
    @JsonProperty("amount")
    private double amount;

    public Rate(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }
}
