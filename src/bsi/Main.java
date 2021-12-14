package bsi;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Main {

    /**
     *
     * Method generatres random secret key
     *
     * @param n - algorithm-specific metric,
     *  specified in number of bits.
     * @param algorithm - algorithm name
     * @return randomly generated secret key
     * @throws NoSuchAlgorithmException
     * @throws NoSuchAlgorithmException
     */
    public static SecretKey generateKey(int n, String algorithm) throws NoSuchAlgorithmException, NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        keyGenerator.init(n);
        SecretKey key = keyGenerator.generateKey();
        return key;
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
    public static void main(String[] args){

        IvParameterSpec iv = generateIv(16);
        try {
            SecretKey key = generateKey(128, "AES");
            for(int i = 1; i<=10;i++) {
                String input = "text_files\\file" + i + ".txt";
                String output = "encrypted_files\\file" + i + "AES.txt";
                try {
                    EncryptionMethods.encryptAES(input, output, key, iv);
                    System.out.println(input + " encryption was successful.");
                } catch(NoSuchAlgorithmException |
                        IllegalBlockSizeException | InvalidKeyException | BadPaddingException |
                        InvalidAlgorithmParameterException | NoSuchPaddingException |  IOException e){
                    e.printStackTrace();
                }
            }
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

    }
}
