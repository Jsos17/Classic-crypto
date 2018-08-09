/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import crypto.helpers.AlphabetHelper;
import java.util.HashMap;

/**
 *
 * @author jpssilve
 */
public class FrequencyAnalysis {

    private String alphabet;
    private double[] expectedLetterFrequencies;
    private HashMap<Character, Integer> alphabetIndexes;

    public FrequencyAnalysis() {
        this.alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.expectedLetterFrequencies = new double[]{0.08167, 0.01492, 0.02782, 0.04253, 0.12702,
            0.02228, 0.02015, 0.06094, 0.06966, 0.00153,
            0.00772, 0.04025, 0.02406, 0.06749, 0.07507,
            0.01929, 0.00095, 0.05987, 0.06327, 0.09056,
            0.02758, 0.00978, 0.02360, 0.00150, 0.01974, 0.00074};
        
        AlphabetHelper help = new AlphabetHelper();
        this.alphabetIndexes = help.hashAlphabet(this.alphabet);
    }

    public double[] getExpectedLetterFrequencies() {
        return this.expectedLetterFrequencies;
    }
    
    public String getAlphabet() {
        return this.alphabet;
    }

    public void setAlphabet(String alphabet, double[] expectedFrequencies) {
        this.alphabet = alphabet;
        this.expectedLetterFrequencies = expectedFrequencies;
    }

    public int[] countOccurrences(String text) {
        int[] occurrences = new int[this.alphabet.length()];
        for (int i = 0; i < text.length(); i++) {
            if (this.alphabetIndexes.containsKey(text.charAt(i))) {
                occurrences[this.alphabetIndexes.get(text.charAt(i))] += 1;
            }
        }

        return occurrences;
    }
}
