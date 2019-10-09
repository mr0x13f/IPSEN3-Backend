package com.ipsen2.api.controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public class VehicleController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/vehicle")
    public void GETVehicle() {

    }

    @POST
    @Path("/vehicle")
    public void POSTVehicle(){

    }

    @PUT
    @Path("/vehicle")
    public void PUTVehicle() {

    }

    @DELETE
    @Path("/vehicle")
    public void DELETEVehicle() {

    }
}
