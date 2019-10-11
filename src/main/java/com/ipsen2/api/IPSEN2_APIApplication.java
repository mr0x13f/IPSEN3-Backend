package com.ipsen2.api;

import com.ipsen2.api.controllers.*;
import com.ipsen2.api.models.Journey;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class IPSEN2_APIApplication extends Application<IPSEN2_APIConfiguration> {

    public static void main(final String[] args) throws Exception {
        new IPSEN2_APIApplication().run(args);
    }

    @Override
    public String getName() {
        return "IPSEN2_API";
    }

    @Override
    public void initialize(final Bootstrap<IPSEN2_APIConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final IPSEN2_APIConfiguration configuration,
                    final Environment environment) {

        // Registreer de controllers zodat DropWizard weet welke klasse de API calls verwerken
        // We gebruiken een bulkRegister() zodat we niet knikker vaak environment.jersey().register() hoeven te callen
        bulkRegister(environment,
                new DebugAPIResource(), // TODO: Comment out in production!! ヽ(⁎˃ᆺ˂)ﾉ
                new CompanyController(),
                new JourneyController(),
                new ProjectController(),
                new RateController(),
                new UserController(),
                new VehicleController()
        );

    }

    /** Register API resources in bulk
     *
     * @param environment The DropWizard environment to register the resources to
     * @param resources The resources to register
     *
     * @version 11/10/2019
     * @author Tim W
     */
    private static void bulkRegister(Environment environment, Object ... resources) {

        // Register alle meegegeven resources
        for (Object resource : resources) {
            environment.jersey().register(resource);
        }

    }

}
