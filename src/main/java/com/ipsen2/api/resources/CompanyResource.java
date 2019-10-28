package com.ipsen2.api.resources;

import com.ipsen2.api.APIResponse;
import com.ipsen2.api.models.Company;
import com.ipsen2.api.services.CompanyService;
import com.ipsen2.api.services.JacksonService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Resource class for handling requests revolving companies.
 *
 * @author TimvHal, Tim W
 * @version 28/10/2019
 */
@Path("/company")
public class CompanyResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public static String getCompany(String companyData) {
        ArrayList<Object> companyIdList = JacksonService.readValue(companyData, String.class);
        APIResponse response = new APIResponse(CompanyService.getCompany(companyIdList));
        return response.serialize();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public static String getAllCompanies() {
        APIResponse response = new APIResponse(CompanyService.getCompany());
        return response.serialize();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public static String postCompany(String companyData) {
        ArrayList<Object> cList = JacksonService.readValue(companyData, Company.class);
        APIResponse response = new APIResponse(CompanyService.postCompany(cList));
        return response.serialize();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public static String updateCompany(String companyData) {
        ArrayList<Object> cList = JacksonService.readValue(companyData, Company.class);
        APIResponse response = new APIResponse(CompanyService.updateCompany(cList));
        return response.serialize();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public static String deleteCompany(String companyData) {
        ArrayList<Object> cList = JacksonService.readValue(companyData, Company.class);
        APIResponse response = new APIResponse(CompanyService.deleteCompany(cList));
        return response.serialize();
    }

}
