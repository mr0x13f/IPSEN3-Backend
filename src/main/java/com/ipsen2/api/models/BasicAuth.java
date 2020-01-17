package com.ipsen2.api.models;

/**
 * Model containing data about a certain user, retrieved from the BasicAuthenticationService.
 *
 * @author TimvHal, Tim W
 * @version 14/10/2019
 */
public class BasicAuth implements java.security.Principal {

    public User user;

    public BasicAuth(User user) {
        this.user = user;
    }

    @Override
    public String getName() {
        return user.getName();
    }

}