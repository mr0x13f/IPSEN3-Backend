package com.ipsen2.api.resources;

import com.ipsen2.api.APIResponse;
import com.ipsen2.api.models.Company;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/company")
public class CompanyResource {

    public Company model;

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //                                         CONSTRUCTORS
    ///////////////////////////////////////////////////////////////////////////////////////////////

    /** Create controller with <b>new</b> model.
     *
     * @version 11/10/2019
     * @author Tim W
     */
    public CompanyResource() {
        this.model = new Company();
    }

    /** Create controller with <b>existing</b> model.
     *
     * @param model The model to control.
     *
     * @version 11/10/2019
     * @author Tim W
     */
    public CompanyResource(Company model) {
        this.model = model;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //                                         METHODS
    ///////////////////////////////////////////////////////////////////////////////////////////////



    ///////////////////////////////////////////////////////////////////////////////////////////////
    //                                         REST
    ///////////////////////////////////////////////////////////////////////////////////////////////

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static String GETCompany () {
        APIResponse response = new APIResponse(1, "Not implemented");
        return response.serialize();

        /*

        APIResponse response = new APIResponse(this.model)

         */
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
