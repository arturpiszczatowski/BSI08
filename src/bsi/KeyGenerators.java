package bsi;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author Norbert Leśniak
 * @author Artur Piszczatowski
 * Source: https://www.baeldung.com/java-aes-encryption-decryption
 * Source: https://www.geeksforgeeks.org/asymmetric-encryption-cryptography-in-java/
 *
 *This class consists exclusively of static methods that generate keys.
 *
 * @see IvParameterSpec
 * @see SecretKey
 * @see KeyPair
 * @see String
 * @see NoSuchAlgorithmException
 */

public class KeyGenerators {

    /**
     *
     * Method generates random secret symmetric key
     *
     * @param n - algorithm-specific metric,
     *  specified in number of bits.
     * @param algorithm - algorithm name
     * @return randomly generated secret key
     * @throws NoSuchAlgorithmException
     */
    public static SecretKey generateSymmetricKey(int n, String algorithm) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        keyGenerator.init(n);
        SecretKey key = keyGenerator.generateKey();
        return key;
    }

    /**
     *
     * Method generates random secret asymmetric key pair
     *
     * @param n algorithm-specific metric,
     *  specified in number of bits.
     * @param algorithm - algorithm name
     * @return randomly generated secret key pair
     * @throws NoSuchAlgorithmException
     */
    public static KeyPair generateAsymmetricKeyPair(int n, String algorithm) throws NoSuchAlgorithmException {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        SecureRandom secureRandom = new SecureRandom();

        keyPairGenerator.initialize(n, secureRandom);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        return keyPair;
    }

    /**
     *
     * Method generates random initialization vector
     *
     * @see IvParameterSpec
     * @param size - initialization vector size in bytes
     * @return randomly generated initialization vector
     */
    public static IvParameterSpec generateIv(int size) {
        byte[] iv = new byte[size];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }
}
