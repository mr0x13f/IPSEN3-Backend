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

    public static String updateProject(ArrayList<Object> pList) {
        try {
            for(Object o : pList) {
                Project p = (Project) o;
                String query = "UPDATE projects SET name = ?, companyId = ? WHERE projectId = ?;";
                PreparedStatement ps = DatabaseService.prepareQuery(query);
                ps.setString(1, p.getName());
                ps.setString(2, p.getCompanyId());
                ps.setString(3, p.getProjectId());
                DatabaseService.executeQuery(ps);
            }
            return "200 OK";
        }
        catch(java.sql.SQLException e) {
            return "500 Server Error";
        }
    }

    public static String deleteProject(ArrayList<Object> pList) {
        try{
            for(Object o: pList) {
                Project p = (Project) o;
                String query = "DELETE FROM projects WHERE projectId = ?;";
                PreparedStatement ps = DatabaseService.prepareQuery(query);
                ps.setString(1, p.getProjectId());
                DatabaseService.executeQuery(ps);
            }
            return "200 OK";
        }
        catch(java.sql.SQLException e) {
            e.printStackTrace();
            return "500 Server Error";
        }

    }
}
