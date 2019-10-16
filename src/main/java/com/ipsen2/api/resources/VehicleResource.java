package com.ipsen2.api.resources;

import com.ipsen2.api.APIResponse;
import com.ipsen2.api.models.Vehicle;
import com.ipsen2.api.services.JacksonService;
import com.ipsen2.api.services.VehicleService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Resource class for checking requests revolving vehicles.
 *
 * @author TimvHal, Tim W
 * @version 16/10/2019
 */
@Path("/vehicle")
public class VehicleResource {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String GETVehicles() {
        APIResponse response = new APIResponse(VehicleService.GETVehicleList());
        return response.serialize();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String POSTVehicle(String vehicleData){
        ArrayList<Object> vList = JacksonService.readValue(vehicleData, Vehicle.class);
        APIResponse response = new APIResponse(VehicleService.POSTVehicle(vList));
        return response.serialize();
        //return "{'message': 'not implemented :('}".replace("'","\"");
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
