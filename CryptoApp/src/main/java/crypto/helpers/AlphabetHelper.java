/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.helpers;

import crypto.sorting.PrimitiveTypeSort;
import java.util.HashMap;

/**
 * A small helper class that contains methods related to alphabets that are used
 * in encryption.
 *
 * @author jpssilve
 */
public class AlphabetHelper {

    public AlphabetHelper() {

    }

    /**
     * A method which uses the character of the alphabet as the key and stores
     * the position of the character in the alphabet.
     *
     * @param alphabet The alphabet in use, usually abcdefghijklmnopqrstuvwxyz
     * @return a HashMap of character-index key-values
     */
    public HashMap<Character, Integer> hashAlphabet(String alphabet) {
        HashMap<Character, Integer> alphabetIndexes = new HashMap<>();
        for (int i = 0; i < alphabet.length(); i++) {
            alphabetIndexes.put(alphabet.charAt(i), i);
        }

        return alphabetIndexes;
    }
}
