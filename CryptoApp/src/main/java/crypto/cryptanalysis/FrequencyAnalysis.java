/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import java.util.HashMap;

/**
 *
 * @author jpssilve
 */
public class FrequencyAnalysis {

    private String alphabet;
    private int[] occurrences;
    private HashMap<Character, Integer> alphabetIndexes;

    public FrequencyAnalysis() {
        this.alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.occurrences = new int[this.alphabet.length()];
        this.alphabetIndexes = new HashMap<>();
        hashAlphabet();
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
        this.occurrences = new int[this.alphabet.length()];
    }

    private void hashAlphabet() {
        for (int i = 0; i < this.alphabet.length(); i++) {
            this.alphabetIndexes.put(this.alphabet.charAt(i), i);
        }
    }

    public int[] getOccurrences() {
        return this.occurrences;
    }

    public int[] countOccurrences(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (this.alphabetIndexes.containsKey(text.charAt(i))) {
                this.occurrences[this.alphabetIndexes.get(text.charAt(i))] += 1;
            }
        }
        
        return this.occurrences;
    }
}
