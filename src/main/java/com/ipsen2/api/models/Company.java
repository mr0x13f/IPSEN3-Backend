package com.ipsen2.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

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
