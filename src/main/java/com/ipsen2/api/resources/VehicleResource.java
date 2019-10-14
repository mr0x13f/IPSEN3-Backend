package com.ipsen2.api.resources;

import com.ipsen2.api.APIResponse;
import com.ipsen2.api.services.VehicleService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/vehicle")
public class VehicleResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String GETVehicles() {
        APIResponse response = new APIResponse(VehicleService.GETVehicleList());
        return response.serialize();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String POSTVehicles(){
        return "{'message': 'not implemented :('}".replace("'","\"");
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String PUTVehicles() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String DELETEVehicles() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }
}
