package com.ipsen2.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Used to read fields from change name body.
 *
 * @author Tim W
 * @version 30/10/2019
 */
public class ChangeNameForm {

    @JsonProperty("name")
    private String name;

    public ChangeNameForm(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
