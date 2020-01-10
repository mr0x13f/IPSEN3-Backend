package com.ipsen2.api.services;

import com.ipsen2.api.models.BasicAuth;
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
 * @author Tim W, TimvHal
 * @version 09-01-2020
 */
public class BasicAuthenticationService implements Authenticator<BasicCredentials, BasicAuth> {

    private static Base64.Encoder encoder = Base64.getEncoder().withoutPadding();
    private static Base64.Decoder decoder = Base64.getDecoder();

    @Override
    public Optional<BasicAuth> authenticate(BasicCredentials credentials) {

        Optional<User> optionalUser = UserService.getUserByCredentials(credentials);

        if (!optionalUser.isPresent()) return Optional.empty(); // No user with matching email found

        User user = optionalUser.get();
        String saltedHash = hashWithSalt(credentials.getPassword(), user.getSalt());

        if (!user.getPassword().equals(saltedHash)) return Optional.empty(); // Passwords don't match

        return Optional.of(new BasicAuth(user));

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
