package com.ipsen2.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*

    Alleen ff voor testen van HTTP troep.
    localhost:8080/debug

 */

@Path("/debug")
public class DebugAPIResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String GETDebug() {
        APIResponse response = new APIResponse();
        return response.serialize();
    }

}
