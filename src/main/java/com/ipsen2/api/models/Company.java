package com.ipsen2.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("company")
public class Company {

    @JsonProperty("companyId")
    private int companyId;
    @JsonProperty("name")
    private String name;

}
