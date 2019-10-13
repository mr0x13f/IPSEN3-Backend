package com.ipsen2.api.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/rate")
public class RateResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String GETRate() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String POSTRate() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String PUTRate() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String DELETERate() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }
}
