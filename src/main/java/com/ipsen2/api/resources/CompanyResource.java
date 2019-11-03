package com.ipsen2.api.resources;

import com.ipsen2.api.APIResponse;
import com.ipsen2.api.models.Company;
import com.ipsen2.api.models.User;
import com.ipsen2.api.services.CompanyService;
import com.ipsen2.api.services.JacksonService;
import io.dropwizard.auth.Auth;

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
    @Path("/{companyId}")
    @Produces(MediaType.APPLICATION_JSON)
    public static String getCompany(@Auth User user, @PathParam("companyId") String companyId) {
        APIResponse response = new APIResponse(CompanyService.getCompany(companyId));
        return response.serialize();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static String getCompanies(@Auth User user) {
        APIResponse response = new APIResponse(CompanyService.getCompanies());
        return response.serialize();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public static String postCompany(@Auth User user, String companyData) {
        Company c = (Company) JacksonService.readValue(companyData, Company.class);
        APIResponse response = new APIResponse(CompanyService.postCompany(c));
        return response.serialize();
    }

    @PUT
    @Path("/{companyId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public static String updateCompany(@Auth User user, @PathParam("companyId") String companyId, String companyData) {
        Company c = (Company) JacksonService.readValue(companyData, Company.class);
        c.setCompanyId(companyId);
        APIResponse response = new APIResponse(CompanyService.updateCompany(c));
        return response.serialize();
    }

    @DELETE
    @Path("/{companyId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public static String deleteCompany(@Auth User user, @PathParam("companyId") String companyId) {
        APIResponse response = new APIResponse(CompanyService.deleteCompany(companyId));
        return response.serialize();
    }

}
