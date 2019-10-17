package com.ipsen2.api.resources;

import com.ipsen2.api.APIResponse;
import com.ipsen2.api.models.User;
import com.ipsen2.api.services.JacksonService;
import com.ipsen2.api.services.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Resource class for checking requests revolving users.
 *
 * @author TimvHal, Tim W
 * @version 14/10/2019
 */
@Path("/user")
public class UserResource {

    @GET
    @Path("/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String GETUser() {
        APIResponse response = new APIResponse(UserService.GETUserList());
        return response.serialize();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String POSTUser(String userData) {
        ArrayList<Object> uList = JacksonService.readValue(userData, User.class);
        APIResponse response = new APIResponse(UserService.POSTUser(uList));
        return response.serialize();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String PUTUser() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String DELETEUser() {
        return "{'message': 'not implemented :('}".replace("'","\"");
    }
}
