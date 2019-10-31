package com.ipsen2.api.services;

import com.ipsen2.api.models.User;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.auth.Authenticator;

import java.util.Optional;

public class AuthenticationService implements Authenticator<BasicCredentials, User> {

    @Override
    public Optional<User> authenticate(BasicCredentials credentials) {

        return UserService.getUser(credentials);

    }
}
