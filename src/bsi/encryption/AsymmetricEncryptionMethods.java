package bsi.encryption;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;

/**
 * @author Norbert Leśniak
 * @author Artur Piszczatowski
 * Source: https://www.geeksforgeeks.org/asymmetric-encryption-cryptography-in-java/
 *
 * This class consists exclusively of static method that encrypt plain text using RSA algorithm
 *
 * @see Cipher
 * @see IvParameterSpec
 * @see SecretKey
 * @see String
 * @see NoSuchPaddingException
 * @see NoSuchAlgorithmException
 * @see BadPaddingException
 * @see IllegalBlockSizeException
 * @see InvalidKeyException
 * @see Cipher
 */

public class AsymmetricEncryptionMethods {

    /**
     *
     * @param plainText - text given to encrypt
     * @param privateKey - private encryption key generated for keypair
     * @return encrypted text using RSA algorithm
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static byte[] encryptRSA(String plainText, PrivateKey privateKey) throws NoSuchPaddingException,
            NoSuchAlgorithmException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(plainText.getBytes());
    }
}
