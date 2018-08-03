/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ciphers;

import java.util.HashMap;

/**
 * This class implements the variation of Vigenere cipher where the standard
 * alphabet is disrupted from the beginning by inserting an alphabet key which
 * contains only the standard 26 Latin alphabet characters and none of them are
 * repeated in the alphabet key.
 *
 * @author jpssilve
 */
public class KeyedVigenereCipher extends VigenereCipher {

    /**
     *
     * @param alphabetKey The alphabet key should contain only the standard 26
     * Latin alphabet characters and none of them should be repeated in the
     * alphabet key because this key is used to break the standard pattern of
     * the alphabet in the standard Vigenere cipher.
     */
    public KeyedVigenereCipher(String alphabetKey) {
        super();
        super.scrambleAlphabet(buildAlphabet(alphabetKey.toLowerCase(), hashAlphabet("abcdefghijklmnopqrstuvwxyz".toCharArray())));
    }

    private HashMap<Character, Integer> hashAlphabet(char[] alphabet) {
        HashMap<Character, Integer> abcNums = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            abcNums.put(alphabet[i], i);
        }

        return abcNums;
    }

    /**
     * This method simply builds the alphabet order based on the alphabet key.
     *
     * @param alphabetKey The alphabet key should contain only the standard 26
     * Latin alphabet characters and none of them should be repeated in the
     * alphabet key because this key is used to break the standard starting
     * pattern of the alphabet in the standard Vigenere cipher.
     * @param regAbcNums A HashMap containing the corresponding order number for
     * each alphabet character when the the alphabet is in regular order
     * abcdef... etc
     * @return The newly ordered alphabet
     */
    private String buildAlphabet(String alphabetKey, HashMap<Character, Integer> regAbcNums) {
        int[] countingAlphabet = new int[26];
        for (int i = 0; i < 26; i++) {
            countingAlphabet[i] = 0;
        }

        for (int i = 0; i < alphabetKey.length(); i++) {
            countingAlphabet[regAbcNums.get(alphabetKey.charAt(i))] = 1;
        }

        String abc = "abcdefghijklmnopqrstuvwxyz";
        String keyedAbc = alphabetKey;
        for (int i = 0; i < countingAlphabet.length; i++) {
            if (countingAlphabet[i] == 0) {
                keyedAbc += abc.substring(i, i + 1);
            }
        }

        return keyedAbc;
    }
}
