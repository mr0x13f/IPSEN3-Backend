package com.ipsen2.api.dao;

import com.ipsen2.api.models.Project;
import com.ipsen2.api.services.DatabaseService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class for interacting with database revolving Projects.
 *
 * @author TimvHal
 * @version 14/10/2019
 */
public class ProjectDAO {

    public static ArrayList<Project> GETProjectData() {
        PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM projects");
        ResultSet rs = DatabaseService.executeQuery(ps);
        ArrayList<Project> projectList = new ArrayList<>();

        try {
            while(rs.next()) {
                int id = rs.getInt("projectId");
                String name = rs.getString("name");
                projectList.add(new Project(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectList;
    }
}
