package com.ipsen2.api.resources;

import com.ipsen2.api.APIResponse;
import com.ipsen2.api.models.Project;
import com.ipsen2.api.models.User;
import com.ipsen2.api.services.JacksonService;
import com.ipsen2.api.services.ProjectService;
import io.dropwizard.auth.Auth;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Resource class for checking requests revolving projects.
 *
 * @author TimvHal, Tim W
 * @version 03/11/2019
 */
@Path("/project")
public class ProjectResource {

    @GET
    @Path("/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProject(@Auth User user, @PathParam("projectId") String projectId) {
        APIResponse response = new APIResponse(ProjectService.getProject(projectId));
        return response.serialize();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProjects(@Auth User user) {
        APIResponse response = new APIResponse(ProjectService.getProjects());
        return response.serialize();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String postProject(@Auth User user, String projectData) {
        Project p = (Project) JacksonService.readValue(projectData, Project.class);
        APIResponse response = new APIResponse(ProjectService.postProject(p));
        return response.serialize();
    }

    @PUT
    @Path("/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateProject(@Auth User user, @PathParam("projectId") String projectId, String projectData) {
        Project p = (Project) JacksonService.readValue(projectData, Project.class);
        p.setProjectId(projectId);
        APIResponse response = new APIResponse(ProjectService.updateProject(p));
        return response.serialize();
    }

    @DELETE
    @Path("/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteProject(@Auth User user, @PathParam("projectId") String projectId) {
        APIResponse response = new APIResponse(ProjectService.deleteProject(projectId));
        return response.serialize();
    }
}
