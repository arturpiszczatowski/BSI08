package bsi;

import bsi.encryption.AsymmetricDecryptionMethods;
import bsi.encryption.AsymmetricEncryptionMethods;
import bsi.encryption.KeyGenerators;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {

        KeyPair key = KeyGenerators.generateAsymmetricKeyPair(2048, "RSA");

        var encryptedText = AsymmetricEncryptionMethods.encryptRSA("Czcimy pana", key.getPrivate());
        var text = AsymmetricDecryptionMethods.decryptRSA(encryptedText, key.getPublic());

        System.out.println(text);
    }
}
