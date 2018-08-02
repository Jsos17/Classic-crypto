/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ciphers;

import java.util.HashMap;

/**
 *
 * @author jpssilve
 */
public class KeyedVigenereCipher extends VigenereCipher {

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
