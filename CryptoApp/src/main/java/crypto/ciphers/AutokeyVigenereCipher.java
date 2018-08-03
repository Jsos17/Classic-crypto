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
     * An empty primer makes it impossible to decrypt the message since no
     * information about the key (which was the original plaintext) can be
     * gained by using the ciphertext only. Therefore the ciphertext is returned
     * (which is not the original plaintext).
     *
     * @param primer A normal encryption key that is only used once and is not
     * lengthened unlike in the standard Vigenere cipher. The key should only
     * contain the standard 26 Latin alphabet characters. If the primer is
     * empty, it implies that only the plaintext was used to encrypt the
     * plaintext and this makes it impossible to decrypt the key since the
     * original plaintext should be known but encrypting a plaintext using the
     * exactly same plaintext as the key produces a different ciphertext and
     * since the primer is empty the plaintext cannot be known. Therefore an
     * empty primer returns the ciphertext (which is the wrong answer) and thus
     * an empty primer should not be provided since then all information of the
     * encryption key is lost.
     * @param ciphertext The message to be decrypted. The message should only
     * contain the standard 26 Latin alphabet characters.
     * @return The original message in plaintext
     */
    @Override
    public String decrypt(String primer, String ciphertext) {
        int n = primer.length();
        if (n == 0) {
            return ciphertext;
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
