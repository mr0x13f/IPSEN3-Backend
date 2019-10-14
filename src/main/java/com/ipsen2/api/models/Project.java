package com.ipsen2.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model containing data about a certain project.
 *
 * @author TimvHal, Tim W
 * @version 14/10/2019
 */
public class Project {

    @JsonProperty("projectId")
    private int projectId;
    @JsonProperty("name")
    private String name;

    public Project(int id, String name) {
        this.projectId = id;
        this.name = name;
    }
}
