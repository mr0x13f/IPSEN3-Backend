package com.ipsen2.api.services;

import com.ipsen2.api.models.User;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.auth.Authenticator;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Optional;

/**
 * Service used by DropWizard to resolve basic authentication.
 *
 * @author Tim W
 * @version 03/11/2019
 */
public class AuthenticationService implements Authenticator<BasicCredentials, User> {

    private static Base64.Encoder encoder = Base64.getEncoder().withoutPadding();
    private static Base64.Decoder decoder = Base64.getDecoder();

    @Override
    public Optional<User> authenticate(BasicCredentials credential) {

        return UserService.getUser(credential);

    }

    public static String generateSalt() {
        byte[] emptySalt = new byte[16];
        SecureRandom random = new SecureRandom();
        byte[] seed = random.generateSeed(20);
        random.setSeed(seed);

        random.nextBytes(seed);
        return encoder.encodeToString(seed);
    }

    public static String hashWithSalt(String salt, String password) {
        byte[] hashedPassword = null;
        try {
            PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray(), decoder.decode(salt), 65536, 128);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hashedPassword = secretKeyFactory.generateSecret(keySpec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return encoder.encodeToString(hashedPassword);
    }
}
