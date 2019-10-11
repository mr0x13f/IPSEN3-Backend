package com.ipsen2.api.controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/vehicle")
public class VehicleController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String GETVehicle() {
        return "{'message': 'not implemented :('}".replace("'","\"");
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
