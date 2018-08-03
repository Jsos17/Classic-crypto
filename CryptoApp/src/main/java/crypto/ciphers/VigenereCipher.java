/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ciphers;

import java.util.HashMap;

/**
 * This class implements the basic Vigenere cipher that uses the latin 26
 * character alphabet.
 *
 * @author jpssilve
 */
public class VigenereCipher {

    private char[] alphabet;
    private HashMap<Character, Integer> abcNumbers;
    private int modulus;

    /**
     * The constructor takes no arguments
     */
    public VigenereCipher() {
        this.alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        this.abcNumbers = new HashMap<>();
        this.modulus = this.alphabet.length;
        hashAlphabet();
    }

    protected void scrambleAlphabet(String alphabet) {
        String abc = alphabet.trim().toLowerCase();
        this.alphabet = abc.toCharArray();
        this.modulus = this.alphabet.length;
        this.abcNumbers.clear();
        hashAlphabet();
    }

    private void hashAlphabet() {
        for (int i = 0; i < this.alphabet.length; i++) {
            this.abcNumbers.put(this.alphabet[i], i);
        }
    }

    /**
     * A simple method to lengthen the encryption key so that its length will
     * match the message length.
     *
     * @param key The encryption key. The key should only contain the standard
     * 26 Latin alphabet characters
     * @param textLen The length of the plaintext
     * @return The key in lengthened form
     */
    protected String lengthenKey(String key, int textLen) {
        if (key.length() >= textLen) {
            return key;
        }

        String keyMultiple = key;
        int rounds = (int) (textLen / key.length()) - 1;

        while (rounds > 0) {
            keyMultiple += key;
            rounds--;
        }

        if (textLen > keyMultiple.length()) {
            keyMultiple += key.substring(0, textLen - keyMultiple.length());
        }

        return keyMultiple;
    }

    /**
     * This method iterates over the plaintext once using some (Java-type)
     * modular arithmetic to assign a new corresponding character to every
     * character in the plaintext. So essentially the encryption is a
     * mathematical bijective function.
     *
     * If the key is shorter than the message then it is lengthened until it
     * matches the message length. This key is then used to choose the
     * appropriate alphabet from the 26 different shifted alphabets for every
     * single character until the whole message is encrypted. The character of
     * the key tells the row, an the character of the plaintext tells the
     * column, and the ciphertext character can be read from the corresponding
     * (row, column) place in the matrix. This would be the manual process,
     * however a faster method is used for the algorithm, mainly modular
     * arithmetic.
     *
     * Important thing to note is that all text is converted to lowercase to
     * help reading of the text, unlike the classical application which used
     * uppercase. Additionally, only the standard Latin 26 character alphabet is
     * available so the plaintext should only contain these characters
     *
     * @param key The keyword which is used to perform the encryption. The key
     * should only contain the standard 26 Latin alphabet characters
     * @param plaintext The message to be encrypted. The message should only
     * contain the standard 26 Latin alphabet characters
     * @return The original message in encrypted form
     */
    public String encrypt(String key, String plaintext) {
        if (key.length() == 0) {
            return plaintext.toLowerCase();
        }

        String plaintextLowerCase = plaintext.toLowerCase();
        String encryptKey = lengthenKey(key.toLowerCase(), plaintextLowerCase.length());
        char[] encryptedChars = new char[plaintextLowerCase.length()];

        for (int i = 0; i < plaintextLowerCase.length(); i++) {
            int keyAlphabetNum = this.abcNumbers.getOrDefault(encryptKey.charAt(i), 0);
            int plaintextAlphabetNum = this.abcNumbers.getOrDefault(plaintextLowerCase.charAt(i), 0);

            encryptedChars[i] = this.alphabet[(keyAlphabetNum + plaintextAlphabetNum) % this.modulus];
        }

        return new String(encryptedChars);
    }

    /**
     * This method iterates over the ciphertext using (Java-type)
     * modular-arithmetic to find the original corresponding character from the
     * alphabet.
     *
     * The key is used to effectively execute a reverse operation to the
     * encryption process, only this time the character found on the plaintext
     * is found by choosing the appropriate row based on the current character
     * of the key and then traversing the row until the corresponding ciphertext
     * character is found. Then the actual plaintext character is found in the
     * top row in the same column. This would be the manual operation, but the
     * algorithm uses modular arithmetic to simply calculate the right value and
     * thus saving the the time to traverse any row.
     *
     *
     * @param key The same key that was used to encrypt the message. The key
     * should only contain the standard 26 Latin alphabet characters
     * @param ciphertext The ciphertext which the user wishes to decrypt
     * @return The original message in plaintext. The message should only
     * contain the standard 26 Latin alphabet characters
     */
    public String decrypt(String key, String ciphertext) {
        if (key.length() == 0) {
            return ciphertext.toLowerCase();
        }

        String ciphertextLowerCase = ciphertext.toLowerCase();
        String decryptKey = lengthenKey(key.toLowerCase(), ciphertextLowerCase.length());
        char[] decryptedChars = new char[ciphertextLowerCase.length()];

        for (int i = 0; i < ciphertextLowerCase.length(); i++) {
            int keyAlphabetNum = abcNumbers.getOrDefault(decryptKey.charAt(i), 0);
            int ciphertextAlphabetNum = abcNumbers.getOrDefault(ciphertextLowerCase.charAt(i), 0);

            decryptedChars[i] = alphabet[(((ciphertextAlphabetNum - keyAlphabetNum) % modulus) + modulus) % modulus];
        }

        return new String(decryptedChars);
    }
}
