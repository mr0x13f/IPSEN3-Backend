package com.ipsen2.api;

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
        // TODO: implement application
    }

}
