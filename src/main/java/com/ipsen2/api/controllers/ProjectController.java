package com.ipsen2.api.controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/project")
public class ProjectController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String GETProject() {
        return "{'message': 'not implemented :('}".replace("'","\"");
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
