package com.ipsen2.api.services;

import com.ipsen2.api.dao.ProjectDAO;
import com.ipsen2.api.models.Project;

import java.util.ArrayList;

/**
 * Service for handling and completing requests revolving projects.
 *
 * @author TimvHal, Tim W
 * @version 03/11/2019
 */
public class ProjectService {

    public static Project getProject(String projectId) {
        return ProjectDAO.getProject(projectId);
    }

    public static Project[] getProjects() {
        return ProjectDAO.getProjects();
    }

    public static String postProject(Project p) {
        return ProjectDAO.postProject(p);
    }

    public static String updateProject(Project p) {
        return ProjectDAO.updateProject(p);
    }

    public static String deleteProject(String projectId) {
        return ProjectDAO.deleteProject(projectId);
    }
}
