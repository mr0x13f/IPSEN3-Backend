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
 * @version 28/10/2019
 */
public class ProjectDAO {

    public static ArrayList<Project> getProject() {
        PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM projects");
        ResultSet rs = DatabaseService.executeQuery(ps);
        ArrayList<Project> projectList = new ArrayList<>();

        try {
            while(rs.next()) {
                String projectId = rs.getString("projectId");
                String name = rs.getString("name");
                String companyId = rs.getString("companyId");
                projectList.add(new Project(projectId, name, companyId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectList;
    }

    public static String postProject(ArrayList<Object> pList) {
        try {
            for (Object o : pList) {
                Project p = (Project) o;
                String query = "INSERT INTO projects VALUES(?,?,?);";
                PreparedStatement ps = DatabaseService.prepareQuery(query);
                ps.setString( 1, p.getProjectId());
                ps.setString( 2, p.getName());
                ps.setString( 3, p.getCompanyId());
                DatabaseService.executeQuery(ps);
            }
            return "200 OK";
        } catch (java.sql.SQLException e) {
            return "500 SQL error";
        }
    }
}
