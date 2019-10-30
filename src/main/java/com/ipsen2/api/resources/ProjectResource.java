package com.ipsen2.api.resources;

import com.ipsen2.api.APIResponse;
import com.ipsen2.api.models.Project;
import com.ipsen2.api.services.JacksonService;
import com.ipsen2.api.services.ProjectService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Resource class for checking requests revolving projects.
 *
 * @author TimvHal, Tim W
 * @version 28/10/2019
 */
@Path("/project")
public class ProjectResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProject() {
        APIResponse response = new APIResponse(ProjectService.getProject());
        return response.serialize();
    }

    @GET
    @Path("/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProject(@PathParam("projectId") String projectId) {
        APIResponse response = new APIResponse(ProjectService.getProject(projectId));
        return response.serialize();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String postProject(String projectData) {
        ArrayList<Object> pList = JacksonService.readValue(projectData, Project.class);
        APIResponse response = new APIResponse(ProjectService.postProject(pList));
        return response.serialize();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateProject(String projectData) {
        ArrayList<Object> pList = JacksonService.readValue(projectData, Project.class);
        APIResponse response = new APIResponse(ProjectService.updateProject(pList));
        return response.serialize();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteProject(String projectData) {
        ArrayList<Object> pList = JacksonService.readValue(projectData, Project.class);
        APIResponse response = new APIResponse(ProjectService.deleteProject(pList));
        return response.serialize();
    }
}
