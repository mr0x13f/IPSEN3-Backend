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
    private String projectId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("companyId")
    private String companyId;

    public Project(String projectId, String name, String companyId) {
        this.projectId = projectId;
        this.name = name;
        this.companyId = companyId;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getName() {
        return this.name;
    }

    public String getCompanyId() {
        return this.companyId;
    }
}
