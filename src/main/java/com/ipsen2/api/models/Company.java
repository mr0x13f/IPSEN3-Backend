package com.ipsen2.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model containing data about a certain company.
 *
 * @author TimvHal, Tim W
 * @version 14/10/2019
 */
public class Company {

    @JsonProperty("companyId")
    private int companyId;
    @JsonProperty("name")
    private String name;

    public Company(int id, String name) {
        this.companyId = id;
        this.name = name;
    }
}
