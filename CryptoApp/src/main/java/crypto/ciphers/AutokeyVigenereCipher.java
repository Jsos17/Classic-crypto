/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ciphers;

/**
 * This class provides a variation of the classic Vigenere cipher, namely using
 * the encryption key only once and then appending the plaintext to the key to
 * lengthen the key. The standard Vigenere cipher is used as a superclass for
 * this class.
 *
 * @author jpssilve
 */
public class AutokeyVigenereCipher extends VigenereCipher {

    /**
     * No parameters
     */
    public AutokeyVigenereCipher() {
        super();
    }

    /**
     * In Autokey Vigenere cipher the key is formed by using a primer key once
     * and then appending it with the plaintext, and thus the resulting
     * encryption key will not form any cycles making the work of the
     * cryptanalyst more difficult.
     *
     * @param primer A normal encryption key that is only used once and is not
     * lengthened unlike in the standard Vigenere cipher. The key should only
     * contain the standard 26 Latin alphabet characters.
     * @param plaintext The message to be encrypted. The message should only
     * contain the standard 26 Latin alphabet characters.
     * @return The original message in encrypted form
     */
    @Override
    public String encrypt(String primer, String plaintext) {
        String autokey = primer + plaintext;
        return super.encrypt(autokey, plaintext);
    }

    /**
     * This method reverses the encryption process. Since the plaintext is used
     * to encrypt the message, the primer only reveals a bit of plaintext that
     * is the length of the primer. However, the decrypted portion of the
     * message can then be used to repeat the decryption and this whole process
     * is repeated until the whole ciphertext is decrypted.
     *
     * @param primer A normal encryption key that is only used once and is not
     * lengthened unlike in the standard Vigenere cipher. The key should only
     * contain the standard 26 Latin alphabet characters.
     * @param ciphertext The message to be decrypted. The message should only
     * contain the standard 26 Latin alphabet characters.
     * @return The original message in plaintext
     */
    @Override
    public String decrypt(String primer, String ciphertext) {
        int n = primer.length();
        if (n == 0) {
            return super.decrypt(ciphertext, ciphertext);
        } else if (n > ciphertext.length()) {
            return super.decrypt(primer, ciphertext);
        }

        int remainder = ciphertext.length() % n;
        String plaintext = "";
        String decryptedPart = primer;
        int start = 0;

        while (n <= ciphertext.length()) {
            decryptedPart = super.decrypt(decryptedPart, ciphertext.substring(start, n));
            plaintext += decryptedPart;
            start = n;
            n += decryptedPart.length();
        }

        plaintext += super.decrypt(decryptedPart, ciphertext.substring(start, start + remainder));
        return plaintext;
    }
}
