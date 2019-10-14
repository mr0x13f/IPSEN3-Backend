package com.ipsen2.api.resources;

import com.ipsen2.api.APIResponse;
import com.ipsen2.api.services.CompanyService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/company")
public class CompanyResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static String GETCompany () {
        APIResponse response = new APIResponse(CompanyService.GETCompanyData());
        return response.serialize();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public static String POSTCompany () {
        APIResponse response = new APIResponse(1, "Not implemented");
        return response.serialize();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public static String PUTCompany () {
        APIResponse response = new APIResponse(1, "Not implemented");
        return response.serialize();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public static String DELETECompany () {
        APIResponse response = new APIResponse(1, "Not implemented");
        return response.serialize();
    }

}
