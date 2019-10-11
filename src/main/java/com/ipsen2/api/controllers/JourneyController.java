package com.ipsen2.api.controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Path("/journey")
public class JourneyController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String GETJourney() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String POSTJourney() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String PUTJourney() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String DELETEJourney() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }
}
