package com.ipsen2.api;

import com.github.toastshaman.dropwizard.auth.jwt.JwtAuthFilter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.ipsen2.api.models.BasicAuth;
import com.ipsen2.api.services.BasicAuthenticationService;
import com.ipsen2.api.models.User;
import com.ipsen2.api.resources.*;
import com.ipsen2.api.services.JwtAuthenticationService;
import io.dropwizard.Application;
import io.dropwizard.auth.*;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.jwt.consumer.JwtContext;
import org.jose4j.keys.HmacKey;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.security.NoSuchAlgorithmException;
import java.util.EnumSet;

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
                    final Environment environment) throws NoSuchAlgorithmException {

        // Registreer de controllers zodat DropWizard weet welke klasse de API calls verwerken.
        // We gebruiken een bulkRegister() zodat we niet knikker vaak environment.jersey().register() hoeven te callen.
        bulkRegister(environment,
                //new DebugResource(), // TODO: Comment out in production!! ヽ(⁎˃ᆺ˂)ﾉ
                new CompanyResource(),
                new JourneyResource(),
                new ProjectResource(),
                new UserResource()
        );

        // Authenticator
        BasicAuthenticationService basicAuthenticationService = new BasicAuthenticationService();
        BasicCredentialAuthFilter<BasicAuth> basicFilter = new BasicCredentialAuthFilter.Builder<BasicAuth>().setAuthenticator(basicAuthenticationService).setPrefix("Basic").buildAuthFilter();

        JwtAuthenticationService jwtAuthenticationService = new JwtAuthenticationService();
        final JwtConsumer consumer = new JwtConsumerBuilder().setAllowedClockSkewInSeconds(300).setRequireSubject()
                .setVerificationKey(new HmacKey(JwtAuthenticationService.getSecretKey())).build();
        AuthFilter<JwtContext, User> jwtFilter = new JwtAuthFilter.Builder<User>().setJwtConsumer(consumer).setRealm("realm").setPrefix("Bearer")
                .setAuthenticator(jwtAuthenticationService).buildAuthFilter();

        final PolymorphicAuthDynamicFeature feature = new PolymorphicAuthDynamicFeature<>(
                ImmutableMap.of(BasicAuth.class, basicFilter, User.class, jwtFilter));
        final AbstractBinder binder = new PolymorphicAuthValueFactoryProvider.Binder<>(
                ImmutableSet.of(BasicAuth.class, User.class));

        environment.jersey().register(feature);
        environment.jersey().register(binder);
        environment.jersey().register(RolesAllowedDynamicFeature.class);;

        // CORS headers
        final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "*");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

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
