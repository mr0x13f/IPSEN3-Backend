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

    public static ArrayList<Project> getProject() {
        return ProjectDAO.getProject();
    }

    public static String postProject(ArrayList<Object> pList) {
        return ProjectDAO.postProject(pList);
    }
}
