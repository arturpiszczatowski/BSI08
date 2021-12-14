package bsi.encryption;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

/**
 * @author Norbert Leśniak
 * @author Artur Piszczatowski
 * Source: https://www.geeksforgeeks.org/asymmetric-encryption-cryptography-in-java/
 *
 *This class consists exclusively of static method that decrypt RSA encrypted text
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

public class AsymmetricDecryptionMethods {

    /**
     *
     * @param cipherText - RSA encrypted text for decryption
     * @param publicKey - public decryption key generated for keypair
     * @return plain text decrypted from RSA encrypted text
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */

    public static String decryptRSA(byte[] cipherText, PublicKey publicKey) throws NoSuchPaddingException,
            NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        byte[] result = cipher.doFinal(cipherText);

        return new String(result);
    }
}
