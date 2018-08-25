/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ciphers;

/**
 * This class implements the variation of Vigenere cipher where the standard
 * alphabet is disrupted from the beginning by inserting an alphabet key which
 * contains only the standard 26 Latin alphabet characters and none of them are
 * repeated in the alphabet key.
 *
 * @author jpssilve
 */
public class KeyedVigenereCipher extends VigenereCipher {

    private int[] charMap;
    /**
     * The primeModulus is chosen to be 29 because since the ASCII code of each
     * of the characters maps to a unique index in the range 0 to 28 when the
     * calculation ASCII value mod primeModulus is performed, and also it is
     * very close to the actual alphabet size.
     *
     * Thus it is a simple hashing tool that aids to convert a particular
     * character into its right index in the modified alphabetical order of the
     * keyed Vigenere cipher.
     */
    private final int primeModulus;

    /**
     * The primeModulus is a prime number which acts as the modulus in a
     * de-facto hash function where the Unicode value of a character is mapped
     * to a table mod 29.
     */
    public KeyedVigenereCipher() {
        super();
        this.primeModulus = 29;
        this.charMap = new int[this.primeModulus];
    }

    /**
     *
     * @param alphabetKey The alphabet key should contain only the standard 26
     * Latin alphabet characters and none of them should be repeated in the
     * alphabet key because this key is used to break the standard pattern of
     * the alphabet in the standard Vigenere cipher.
     */
    public void setAlphabet(String alphabetKey) {
        String alphabet = buildAlphabet(alphabetKey.toLowerCase());
        super.setAlpahabet(alphabet.toCharArray());
        /**
         * If the alphabetKey was "kryptos" for example, then k maps to 0, r to
         * 1, y to 2, and so on, and the rest of the unused alphabetical
         * characters map to the remaining numbers 7 to 25 by their natural
         * alphabetical order. These character value pairs are stored in this
         * table using the hash function ASCII/Unicode value mod primeModulus,
         * which gives unique indexes to these 26 standard Latin alphabet
         * characters.
         */
        for (int i = 0; i < alphabet.length(); i++) {
            int index = alphabet.charAt(i) % this.primeModulus;
            this.charMap[index] = i;
        }
    }

    @Override
    protected int mapCharToIndex(char character) {
        if (character < 'a' || character > 'z') {
            return 0;
        }

        return this.charMap[character % this.primeModulus];
    }

    /**
     * This method simply builds the alphabet order based on the alphabet key.
     *
     * @param alphabetKey The alphabet key should contain only the standard 26
     * Latin alphabet characters in lowercase and none of them should be
     * repeated in the alphabet key because this key is used to break the
     * standard starting pattern of the alphabet in the standard Vigenere
     * cipher.
     * @return The newly ordered alphabet
     */
    protected String buildAlphabet(String alphabetKey) {
        int[] countingAlphabet = new int[26];
        for (int i = 0; i < 26; i++) {
            countingAlphabet[i] = 0;
        }

        String keyedAbc = "";
        for (int i = 0; i < alphabetKey.length(); i++) {
            char character = alphabetKey.charAt(i);
            if (character >= 'a' && character <= 'z') {
                if (countingAlphabet[character % 'a'] == 0) {
                    keyedAbc += character;
                }

                countingAlphabet[character % 'a'] = 1;
            }
        }

        String abc = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < countingAlphabet.length; i++) {
            if (countingAlphabet[i] == 0) {
                keyedAbc += Character.toString(abc.charAt(i));
            }
        }

        return keyedAbc;
    }
}
