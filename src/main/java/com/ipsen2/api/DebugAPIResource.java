package com.ipsen2.api;

import com.ipsen2.api.models.User;
import com.ipsen2.api.services.DatabaseService;
import io.dropwizard.auth.Auth;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*

    Alleen ff voor testen van HTTP troep.
    localhost:8080/debug

 */

@Path("/debug")
public class DebugAPIResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String GETDebug() {
        APIResponse response = new APIResponse("1 1");
        return response.serialize();
    }

    @GET
    @Path("/testtable")
    @Produces(MediaType.APPLICATION_JSON)
    public String GETTest() {
        PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM test");
        ResultSet rs = DatabaseService.executeQuery(ps);
        String id = "pannenkoek";
        try {
            rs.next();
            id = rs.getString("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @GET
    @Path("/testusers")
    @Produces(MediaType.TEXT_PLAIN)
    public String testusers() {
        PreparedStatement ps = DatabaseService.prepareQuery("SELECT * FROM users");
        ResultSet rs = DatabaseService.executeQuery(ps);
        String str = "";
        try {
            rs.next();
            str += rs.getString("user_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }

    @GET
    @Path("/authtest")
    @Produces(MediaType.TEXT_PLAIN)
    public String authtest(@Auth User user) {
        return "Hello secured world!";
    }


}
