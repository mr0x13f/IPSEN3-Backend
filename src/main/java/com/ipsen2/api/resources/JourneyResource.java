package com.ipsen2.api.resources;

import com.ipsen2.api.APIResponse;
import com.ipsen2.api.models.Journey;
import com.ipsen2.api.services.JacksonService;
import com.ipsen2.api.services.JourneyService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Resource class for checking requests revolving journeys.
 *
 * @author TimvHal, Tim W
 * @version 28/10/2019
 */
@Path("/journey")
public class JourneyResource {

    @GET
    @Path("/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJourney() {
        APIResponse response = new APIResponse(JourneyService.getJourney());
        return response.serialize();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String postJourney(String journeyData) {
        ArrayList<Object> jList = JacksonService.readValue(journeyData, Journey.class);
        APIResponse response = new APIResponse(JourneyService.postJourney(jList));
        return response.serialize();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String updateJourney() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteJourney() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }
}
