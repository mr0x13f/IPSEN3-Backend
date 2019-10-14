package com.ipsen2.api.resources;

import com.ipsen2.api.APIResponse;
import com.ipsen2.api.services.VehicleService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/vehicle")
public class VehicleResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String GETVehicle() {
        APIResponse response = new APIResponse(VehicleService.GETVehicleData());
        return response.serialize();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String POSTVehicle(){
        return "{'message': 'not implemented :('}".replace("'","\"");
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String PUTVehicle() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String DELETEVehicle() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }
}
