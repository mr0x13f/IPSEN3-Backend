package com.ipsen2.api.dao;

import com.ipsen2.api.models.Company;
import com.ipsen2.api.models.Journey;
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

    public static ArrayList<Project> getProject(String id) {
        ArrayList<Project> projectList = new ArrayList<>();
        if(id == null) {
            PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM projects");
            ResultSet rs = DatabaseService.executeQuery(ps);
            projectList = new ArrayList<>();

            try {
                while (rs.next()) {
                    String projectId = rs.getString("projectId");
                    String name = rs.getString("name");
                    String companyId = rs.getString("companyId");
                    projectList.add(new Project(projectId, name, companyId));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM projects WHERE projectId = ?;");
                ps.setString(1, id);
                ResultSet rs = DatabaseService.executeQuery(ps);
                rs.next();
                String projectId = rs.getString("projectId");
                String name = rs.getString("name");
                String companyId = rs.getString("companyId");

                projectList.add(new Project(projectId, name, companyId));
            }
            catch(java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return projectList;
    }

    public static String postProject(Object p) {
        try {
            //for (Object o : pList) {
                Project project = (Project) p;
                String query = "INSERT INTO projects VALUES(uuid(?),?,uuid(?));";
                PreparedStatement ps = DatabaseService.prepareQuery(query);
                ps.setString( 1, project.getProjectId());
                ps.setString( 2, project.getName());
                ps.setString( 3, project.getCompanyId());
                DatabaseService.executeQuery(ps);
            //}
            return "200 OK";
        } catch (java.sql.SQLException e) {
            return "500 SQL error";
        }
    }

    public static String updateProject(Object p) {
        try {
            Project project = (Project) p;
            String query = "UPDATE projects SET name = ?, companyId = ? WHERE projectId = ?;";
            PreparedStatement ps = DatabaseService.prepareQuery(query);
            ps.setString(1, project.getName());
            ps.setString(2, project.getCompanyId());
            ps.setString(3, project.getProjectId());
            DatabaseService.executeQuery(ps);
            return "200 OK";
        }
        catch(java.sql.SQLException e) {
            return "500 Server Error";
        }
    }

    public static String deleteProject(String projectId) {
        try{
            String query = "DELETE FROM projects WHERE projectId = ?;";
            PreparedStatement ps = DatabaseService.prepareQuery(query);
            ps.setString(1, projectId);
            DatabaseService.executeQuery(ps);
            return "200 OK";
        }
        catch(java.sql.SQLException e) {
            e.printStackTrace();
            return "500 Server Error";
        }

    }
}
