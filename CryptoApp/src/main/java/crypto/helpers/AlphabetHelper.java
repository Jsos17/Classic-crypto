/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.helpers;

import java.util.HashMap;

/**
 *
 * @author jpssilve
 */
public class AlphabetHelper {
    
    public AlphabetHelper() {
        
    }
    
    public HashMap<Character, Integer> hashAlphabet(String alphabet) {
        HashMap<Character, Integer> alphabetIndexes = new HashMap<>();
        for (int i = 0; i < alphabet.length(); i++) {
            alphabetIndexes.put(alphabet.charAt(i), i);
        }
        
        return alphabetIndexes;
    }
}
