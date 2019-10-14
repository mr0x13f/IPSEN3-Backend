package com.ipsen2.api.resources;

import com.ipsen2.api.APIResponse;
import com.ipsen2.api.services.JourneyService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/journey")
public class JourneyResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String GETJourney() {
        APIResponse response = new APIResponse(JourneyService.GETJourneyData());
        return response.serialize();
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
