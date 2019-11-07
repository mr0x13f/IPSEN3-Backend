package com.ipsen2.api.services;

import com.ipsen2.api.models.User;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.auth.Authenticator;

import java.util.Optional;

/**
 * Service used by DropWizard to resolve basic authentication.
 *
 * @author Tim W
 * @version 03/11/2019
 */
public class AuthenticationService implements Authenticator<BasicCredentials, User> {

    @Override
    public Optional<User> authenticate(BasicCredentials credential) {

        return UserService.getUser(credential);

    }
}
