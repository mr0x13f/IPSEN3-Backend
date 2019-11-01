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
    @Path("/{journeyId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJourney(@Auth User user, @PathParam("journeyId") String journeyId) {
        APIResponse response = new APIResponse(JourneyService.getJourney(user.getUserId(), journeyId));
        return response.serialize();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJourneys(@Auth User user) {
        APIResponse response = new APIResponse(JourneyService.getJourneys(user.getUserId()));
        return response.serialize();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String postJourney(@Auth User user,String journeyData) {
        Journey j = (Journey) JacksonService.readValue(journeyData, Journey.class);
        j.setCreatorId(user.getUserId());
        APIResponse response = new APIResponse(JourneyService.postJourney(j));
        return response.serialize();
    }

    @PUT
    @Path("/{journeyId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateJourney(@Auth User user, @PathParam("journeyId") String journeyId, String journeyData) {
        Journey j = (Journey) JacksonService.readValue(journeyData, Journey.class);
        j.setCreatorId(user.getUserId());
        j.setJourneyId(journeyId);
        APIResponse response = new APIResponse(JourneyService.updateJourney(j));
        return response.serialize();
    }

    @DELETE
    @Path("/{journeyId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteJourney(@Auth User user, @PathParam("journeyId") String journeyId) {
        APIResponse response = new APIResponse(JourneyService.deleteJourney(user.getUserId(), journeyId));
        return response.serialize();
    }
}
