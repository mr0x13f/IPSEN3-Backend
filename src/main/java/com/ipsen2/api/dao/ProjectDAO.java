package com.ipsen2.api.dao;

import com.ipsen2.api.models.Project;
import com.ipsen2.api.services.DatabaseService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Class for interacting with database revolving Projects.
 *
 * @author TimvHal, Tim W
 * @version 03/11/2019
 */
public class ProjectDAO {

    public static Project getProject(String projectId) {
        String name = "";
        String companyId = "";
        try {
            PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM projects WHERE project_id = ?;");
            ps.setObject(1, UUID.fromString(projectId));
            ResultSet rs = DatabaseService.executeQuery(ps);

            while(rs.next()) {
                name = rs.getString("name");
                companyId = rs.getString("company_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Project(projectId, name, companyId);
    }

    public static Project[] getProjects() {
        ArrayList<Project> pList = new ArrayList<>();
        try {
            PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM projects;");
            ResultSet rs = DatabaseService.executeQuery(ps);

            while(rs.next()) {
                String projectId = rs.getString("project_id");
                String name = rs.getString("name");
                String companyId = rs.getString("company_id");
                pList.add(new Project(projectId, name, companyId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Project[] pArray = new Project[pList.size()];
        for(int i = 0; i < pList.size(); i++) {
            pArray[i] = pList.get(i);
        }
        return pArray;
    }

    public static String postProject(Project p) {
        try {
            String query = "INSERT INTO projects VALUES(?,?,?);";
            PreparedStatement ps = DatabaseService.prepareQuery(query);
            ps.setObject( 1, UUID.randomUUID());
            ps.setString( 2, p.getName());
            ps.setObject( 3, UUID.fromString(p.getCompanyId()));
            DatabaseService.executeQuery(ps);
            return "200 OK";
        } catch (java.sql.SQLException e) {
            return "500 SQL error";
        }
    }

    public static String updateProject(Project p) {
        try {
            String query = "UPDATE projects SET name = ?, company_id = ? WHERE project_id = ?;";
            PreparedStatement ps = DatabaseService.prepareQuery(query);
            ps.setString(1, p.getName());
            ps.setObject(2, UUID.fromString(p.getCompanyId()));
            ps.setObject(3, UUID.fromString(p.getProjectId()));
            DatabaseService.executeQuery(ps);
            return "200 OK";
        }
        catch(java.sql.SQLException e) {
            return "500 Server Error";
        }
    }

    public static String deleteProject(String projectId) {
        try{
            String query = "DELETE FROM projects WHERE project_id = ?;";
            PreparedStatement ps = DatabaseService.prepareQuery(query);
            ps.setObject(1, UUID.fromString(projectId));
            DatabaseService.executeQuery(ps);
            return "200 OK";
        }
        catch(java.sql.SQLException e) {
            e.printStackTrace();
            return "500 Server Error";
        }

    }
}
