package com.ipsen2.api.controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public class UserController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/user")
    public void GETUser() {

    }

    @POST
    @Path("/user")
    public void POSTUser() {

    }

    @PUT
    @Path("/user")
    public void PUTUser() {

    }

    @DELETE
    @Path("/user")
    public void DELETEUser() {

    }
}
