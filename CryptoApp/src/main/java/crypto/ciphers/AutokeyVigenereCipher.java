/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ciphers;

/**
 *
 * @author jpssilve
 */
public class AutokeyVigenereCipher extends VigenereCipher {

    public AutokeyVigenereCipher() {
        super();
    }

    @Override
    public String encrypt(String primer, String plaintext) {
        String autokey = primer + plaintext;
        return super.encrypt(autokey, plaintext);
    }

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
