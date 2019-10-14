package com.ipsen2.api.resources;

import com.ipsen2.api.APIResponse;
import com.ipsen2.api.services.RateService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/rate")
public class RateResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String GETRate() {
        APIResponse response = new APIResponse(RateService.GETRateData());
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
