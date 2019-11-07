package com.ipsen2.api;

import com.ipsen2.api.services.AuthenticationService;
import com.ipsen2.api.models.User;
import com.ipsen2.api.resources.*;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
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
        bootstrap.setConfigurationSourceProvider(
            new ResourceConfigurationSourceProvider());
    }

    @Override
    public void run(final IPSEN2_APIConfiguration configuration,
                    final Environment environment) {

        // Registreer de controllers zodat DropWizard weet welke klasse de API calls verwerken.
        // We gebruiken een bulkRegister() zodat we niet knikker vaak environment.jersey().register() hoeven te callen.
        bulkRegister(environment,
                //new DebugResource(), // TODO: Comment out in production!! ヽ(⁎˃ᆺ˂)ﾉ
                new CompanyResource(),
                new JourneyResource(),
                new ProjectResource(),
                new UserResource()
        );

        // Registreer authenticator
        environment.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(new AuthenticationService())
                .setRealm("SECURITY REALM")
                .buildAuthFilter()
        ));
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));

    }

    /** Register API resources in bulk.
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
