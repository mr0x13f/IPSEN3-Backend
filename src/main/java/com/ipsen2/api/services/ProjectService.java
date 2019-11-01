package com.ipsen2.api.services;

import com.ipsen2.api.dao.ProjectDAO;
import com.ipsen2.api.models.Project;

import java.util.ArrayList;

/**
 * Service for handling and completing requests revolving projects.
 *
 * @author TimvHal
 * @version 28/10/2019
 */
public class ProjectService {

    public static ArrayList<Project> getProject(String projectId) {
        return ProjectDAO.getProject(projectId);
    }

    public static ArrayList<Project> getProject() {
        return ProjectDAO.getProject(null);
    }

    public static String postProject(Object p) {
        return ProjectDAO.postProject(p);
    }

    public static String updateProject(Object p) {
        return ProjectDAO.updateProject(p);
    }

    public static String deleteProject(String projectId) {
        return ProjectDAO.deleteProject(projectId);
    }
}
