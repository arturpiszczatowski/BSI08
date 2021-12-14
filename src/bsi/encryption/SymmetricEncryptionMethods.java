package bsi.encryption;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Norbert Leśniak
 * @author Artur Piszczatowski
 * Source: https://www.baeldung.com/java-aes-encryption-decryption
 *
 *This class consists exclusively of static methods that encrypt text files.
 * Algorithms used:
 * AES/CBC/PKCS5PADDING
 * TripleDES/CBC/PKCS5Padding
 * Blowfish
 *
 * @see Cipher
 * @see IvParameterSpec
 * @see SecretKey
 * @see String
 * @see NoSuchPaddingException
 * @see NoSuchAlgorithmException
 * @see InvalidAlgorithmParameterException
 * @see InvalidKeyException
 * @see FileInputStream
 * @see FileOutputStream
 *
 */
public class SymmetricEncryptionMethods {
    /**
     *
     * Method encrypts file using AES-CBC algorithm
     *
     * @param inputFile - input text file directory
     * @param outputFile - output encrypted text file directory
     * @param key - the encryption key
     * @param iv - the initialization vector
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws IOException
     */
    public static void encryptAES(String inputFile, String outputFile, SecretKey key,
                                  IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException, IOException {

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);

        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream outputStream = new FileOutputStream(outputFile);

        byte[] buffer = new byte[64];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byte[] output = cipher.update(buffer, 0, bytesRead);
            if (output != null) {
                outputStream.write(output);
            }
        }

        byte[] outputBytes = cipher.doFinal();
        if (outputBytes != null) {
            outputStream.write(outputBytes);
        }

        inputStream.close();
        outputStream.close();
    }
    /**
     *
     * Method encrypts file using 3DES algorithm
     *
     * @param inputFile - input text file directory
     * @param outputFile - output encrypted text file directory
     * @param key - the encryption key
     * @param iv - the initialization vector
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws IOException
     */
    public static void encrypt3DES(String inputFile, String outputFile, SecretKey key,
                                   IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
            IOException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, InvalidKeyException {

        Cipher cipher = Cipher.getInstance("TripleDES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);

        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream outputStream = new FileOutputStream(outputFile);

        byte[] buffer = new byte[64];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byte[] output = cipher.update(buffer, 0, bytesRead);
            if (output != null) {
                outputStream.write(output);
            }
        }

        byte[] outputBytes = cipher.doFinal();
        if (outputBytes != null) {
            outputStream.write(outputBytes);
        }

        inputStream.close();
        outputStream.close();
    }
    /**
     *
     * Method encrypts file using Blowfish algorithm
     *
     * @param inputFile - input text file directory
     * @param outputFile - output encrypted text file directory
     * @param key - the encryption key
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws IOException
     */
    public static void encryptBlowfish(String inputFile, String outputFile, SecretKey key)
            throws NoSuchPaddingException, NoSuchAlgorithmException,
            IOException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, InvalidKeyException {

        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream outputStream = new FileOutputStream(outputFile);

        byte[] buffer = new byte[64];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byte[] output = cipher.update(buffer, 0, bytesRead);
            if (output != null) {
                outputStream.write(output);
            }
        }

        byte[] outputBytes = cipher.doFinal();
        if (outputBytes != null) {
            outputStream.write(outputBytes);
        }

        inputStream.close();
        outputStream.close();
    }
}