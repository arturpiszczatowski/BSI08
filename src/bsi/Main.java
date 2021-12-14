package bsi;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

public class Main {
    /**
     *
     * Method encrypts 10 plan text files with given algorithm.
     * User is supposed to manually change program settings:
     * - initialization vector size:
     *      ( AES and Blowfish -> 16 )
     *      ( 3DES -> 8 )
     * - secret key size:
     *      ( Blowfish -> Keysize must be multiple of 8, and can only range from 32 to 448)
     *      ( AES -> Keysize must be equal to 128, 192 or 256)
     *      ( 3DES -> Keysize must be equal to 112 or 168)
     * - algorithm name:
     *      ( "AES" / "Blowfish" / "TripleDES" )
     * - input text file path
     * - output encrypted text file path
     *
     * @throws NoSuchAlgorithmException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws InvalidAlgorithmParameterException
     * @throws NoSuchPaddingException
     * @throws IOException
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {

        KeyPair key = KeyGenerators.generateAsymmetricKeyPair(2048, "RSA");

        var encryptedText = AsymmetricEncryptionMethods.encryptRSA("Czcimy pana", key.getPrivate());
        var text = AsymmetricDecryptionMethods.decryptRSA(encryptedText, key.getPublic());

        System.out.println(text);
    }
}
