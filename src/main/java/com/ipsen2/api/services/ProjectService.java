package com.ipsen2.api.services;

import com.ipsen2.api.models.Project;

/**
 * Service for handling and completing requests revolving projects.
 *
 * @author TimvHal
 */
public class ProjectService {

    public static Project GETProjectData() {
        //TODO implement DAO method.
        Project p = new Project(1, "1");
        return p;
    }
}
