package com.ipsen2.api.controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String GETUser() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String POSTUser() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String PUTUser() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String DELETEUser() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }
}
