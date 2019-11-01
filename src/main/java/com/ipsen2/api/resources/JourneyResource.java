package com.ipsen2.api.resources;

import com.ipsen2.api.APIResponse;
import com.ipsen2.api.models.Journey;
import com.ipsen2.api.models.User;
import com.ipsen2.api.services.JacksonService;
import com.ipsen2.api.services.JourneyService;
import io.dropwizard.auth.Auth;

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
    @Path("/{creatorId}/{journeyId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJourney(@PathParam("creatorId") String creatorId, @PathParam("journeyId") String journeyId) {
        APIResponse response = new APIResponse(JourneyService.getJourney(creatorId, journeyId));
        return response.serialize();
    }

    @GET
    @Path("/{creatorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJourneys(@PathParam("creatorId") String creatorId) {
        APIResponse response = new APIResponse(JourneyService.getJourneys(creatorId));
        return response.serialize();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String postJourney(String journeyData) {
        Object j = JacksonService.readValue(journeyData, Journey.class);
        APIResponse response = new APIResponse(JourneyService.postJourney(j));
        return response.serialize();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateJourney(String journeyData) {
        Object j = JacksonService.readValue(journeyData, Journey.class);
        APIResponse response = new APIResponse(JourneyService.updateJourney(j));
        return response.serialize();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteJourney(String journeyId) {
        APIResponse response = new APIResponse(JourneyService.deleteJourney(journeyId));
        return response.serialize();
    }
}
