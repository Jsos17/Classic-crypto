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
     * In Autokey Vigenere cipher the key is formed by using a primer key once
     * and then appending it with the plaintext, and thus the resulting
     * encryption key will not form any cycles making the work of the
     * cryptanalyst more difficult.
     *
     * @param primer A normal encryption key that is only used once and is not
     * lengthened unlike in the standard Vigenere cipher. The key should only
     * contain the standard 26 Latin alphabet characters and should not be
     * empty, although this is not enforced in any way.
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
     * An empty primer would make the simple decryption process into a
     * cryptanalytic process of guessing the plaintext since for instance both b
     * encrypted with b and o encrypted with o produce c as the output. Hence,
     * no such cryptanalysis is performed, since decryption should be a
     * straightforward deterministic process, and therefore the ciphertext is
     * returned (which is not the original plaintext).
     *
     * @param primer A normal encryption key that is only used once and is not
     * lengthened unlike in the standard Vigenere cipher. The key should only
     * contain the standard 26 Latin alphabet characters. If the primer is
     * empty, it implies that only the plaintext was used to encrypt the
     * plaintext and this makes it impossible to decrypt the key since the
     * original plaintext should be known but encrypting a plaintext using the
     * exactly same plaintext as the key produces a different ciphertext and
     * since the primer is empty the plaintext cannot be known
     * deterministically. Therefore an empty primer returns the ciphertext
     * (which is the wrong answer) and thus an empty primer should not be
     * provided.
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
