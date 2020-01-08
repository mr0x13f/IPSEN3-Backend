package com.ipsen2.api.services;

import com.ipsen2.api.models.BasicAuth;
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
public class BasicAuthenticationService implements Authenticator<BasicCredentials, BasicAuth> {

    @Override
    public Optional<BasicAuth> authenticate(BasicCredentials credential) {

        Optional<User> optionalUser = UserService.getUserByCredentials(credential);

        if (!optionalUser.isPresent()) return Optional.empty(); // No user with matching email found

        User user = optionalUser.get();

        return Optional.of(new BasicAuth(user));

    }
}
