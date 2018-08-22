/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ciphers;

/**
 * This class implements the basic Vigenere cipher that uses the latin 26
 * character alphabet.
 *
 * @author jpssilve
 */
public class VigenereCipher {

    private char[] alphabet;
    private int modulus;

    /**
     * The constructor takes no arguments
     */
    public VigenereCipher() {
        this.alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        this.modulus = this.alphabet.length;
    }

    protected void setAlpahabet(char[] alphabet) {
        this.alphabet = alphabet;
        this.modulus = alphabet.length;
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
     * This method maps the standard Latin alphabet abcdefghijklmnopqrstuvwxyz
     * to the respective indexes 012345678910111213141516171819202122232425. It
     * takes advantage of the ASCII/Unicode value of the corresponding lowercase
     * characters, and the fact that, all the lowercase Latin alphabet
     * characters are in consecutive order in ASCII/Unicode, and thus we can use
     * the value of 'a' as the modulus and calculate the right index based on
     * that.
     *
     * @param character Any character in the string abcdefghijklmnopqrstuvwxyz,
     * any other character defaults to 0
     * @return 0 for a, 1 for b, 2, c and so on for the standard Latin alphabet
     * characters, any other character defaults to 0
     */
    protected int mapCharToIndex(char character) {
        if (character < 'a' || character > 'z') {
            return 0;
        }

        int m = (int) 'a';
        return character % m;
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
            int keyAlphabetNum = mapCharToIndex(encryptKey.charAt(i));
            int plaintextAlphabetNum = mapCharToIndex(plaintextLowerCase.charAt(i));

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
            int keyAlphabetNum = mapCharToIndex(decryptKey.charAt(i));
            int ciphertextAlphabetNum = mapCharToIndex(ciphertextLowerCase.charAt(i));
            decryptedChars[i] = alphabet[(((ciphertextAlphabetNum - keyAlphabetNum) % modulus) + modulus) % modulus];
        }

        return new String(decryptedChars);
    }
}
