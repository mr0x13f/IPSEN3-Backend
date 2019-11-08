package com.ipsen2.api.resources;

import com.ipsen2.api.APIResponse;
import com.ipsen2.api.models.User;
import com.ipsen2.api.services.CompanyService;
import com.ipsen2.api.services.JacksonService;
import com.ipsen2.api.services.UserService;
import io.dropwizard.auth.Auth;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Resource class for checking requests revolving users.
 *
 * @author TimvHal, Tim W
 * @version 28/10/2019
 */
@Path("/user")
public class UserResource {

    @GET
    @Path("/authenticate")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@Auth User user) {
        APIResponse response = new APIResponse(user);
        return response.serialize();
    }

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String registerUser(String registerData) {

        boolean success = UserService.registerUser(registerData);
        APIResponse response;
        if (success) {
            response = new APIResponse("200 OK");
        } else {
            response = new APIResponse("500 SERVER ERROR");
        }
        return response.serialize();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteUser(@Auth User user) {

        UserService.deleteUser(user);
        APIResponse response = new APIResponse("200 OK");
        return response.serialize();

    }

}
