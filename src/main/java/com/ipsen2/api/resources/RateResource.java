package com.ipsen2.api.resources;

import com.ipsen2.api.APIResponse;
import com.ipsen2.api.services.RateService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Resource class for checking requests revolving rates.
 *
 * @author TimvHal, Tim W
 * @version 14/10/2019
 */
@Path("/rate")
public class RateResource {

    @GET
    @Path("/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String GETRate() {
        APIResponse response = new APIResponse(RateService.GETRateList());
        return response.serialize();
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
