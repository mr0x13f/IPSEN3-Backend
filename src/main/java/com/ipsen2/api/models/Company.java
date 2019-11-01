package com.ipsen2.api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model containing data about a certain company.
 *
 * @author TimvHal, Tim W
 * @version 14/10/2019
 */
public class Company {

    @JsonProperty("companyId")
    private String companyId;
    @JsonProperty("name")
    private String name;

/*
    @JsonCreator
    public Company(@JsonProperty("companyId") String companyId, @JsonProperty("name") String name) {
        this.companyId = companyId;
        this.name = name;
    }
*/

    @JsonCreator
    public Company(@JsonProperty("name") String name) {
        this.name = name;
    }

    public Company (String companyId, String name) {
        this.companyId = companyId;
        this.name = name;
    }



    public String getCompanyId() {
        return this.companyId;
    }

    public String getName() {
        return this.name;
    }
}
