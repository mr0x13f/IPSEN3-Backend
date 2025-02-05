package com.ipsen2.api.services;

import com.ipsen2.api.models.User;
import io.dropwizard.auth.Authenticator;

import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.JwtContext;
import org.jose4j.keys.HmacKey;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Optional;

import static org.jose4j.jws.AlgorithmIdentifiers.HMAC_SHA256;

/**
 * Service used by DropWizard to resolve JWT authentication.
 *
 * @author Tim W
 * @version 08/01/2020
 */
public class JwtAuthenticationService implements Authenticator<JwtContext, User> {

    private static byte[] secretKey;

    /**
     * Retrieve User object from JWT token
     *
     * @param context
     * @return User
     * @author Tim W
     * @version 08/01/2020
     */
    @Override
    public Optional<User> authenticate(JwtContext context) {
        try {
            JwtClaims claims = context.getJwtClaims();

            String userId = (String) claims.getClaimValue("userId");

            return UserService.getUserById(userId);

        } catch (Exception e) {
            return Optional.empty();
        }
    }

    /**
     * Build JWT token from User
     *
     * @param user
     * @return JsonWebSignature
     * @author Tim W
     * @version 08/01/2020
     */
    public static JsonWebSignature buildToken(User user) throws NoSuchAlgorithmException {

        final JwtClaims claims = new JwtClaims();
        claims.setSubject("1");
        claims.setStringClaim("userId", user.getUserId());
        claims.setIssuedAtToNow();
        claims.setGeneratedJwtId();

        final JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(claims.toJson());
        jws.setAlgorithmHeaderValue(HMAC_SHA256);
        jws.setKey(new HmacKey(getSecretKey()));
        return jws;
    }

    /**
     * Get the JWT secret key, or generate one if it hasn't been generated yet
     *
     * @return JWT secret key
     * @author Tim W
     * @version 08/01/2020
     */
    public static byte[] getSecretKey() throws NoSuchAlgorithmException {
        if (secretKey != null) return secretKey;

        secretKey = new byte[32];
        SecureRandom.getInstanceStrong().nextBytes(secretKey);
        return secretKey;
    }
}
