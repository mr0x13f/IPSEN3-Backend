package com.ipsen2.api.resources;

import com.ipsen2.api.APIResponse;
import com.ipsen2.api.services.ProjectService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Resource class for checking requests revolving projects.
 *
 * @author TimvHal, Tim W
 * @version 14/10/2019
 */
@Path("/project")
public class ProjectResource {

    @GET
    @Path("/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String GETProject() {
        APIResponse response = new APIResponse(ProjectService.GETProjectList());
        return response.serialize();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String POSTProject() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String PUTProject() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String DELETEProject() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }
}
