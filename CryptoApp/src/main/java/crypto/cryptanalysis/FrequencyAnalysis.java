/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import crypto.helpers.AlphabetHelper;
import java.util.HashMap;

/**
 * This class performs basic frequency analysis of letters found in a text.
 *
 * @author jpssilve
 */
public class FrequencyAnalysis {

    private String alphabet;
    private double[] expectedLetterFrequencies;
    private HashMap<Character, Integer> alphabetIndexes;

    /**
     * The Latin 26 character alphabet is the default alphabet, the average
     * frequencies of letters in English texts are hard-coded.
     */
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

    /**
     *
     * @return The average frequencies of letters in English texts
     */
    public double[] getExpectedLetterFrequencies() {
        return this.expectedLetterFrequencies;
    }

    /**
     *
     * @return The alphabet that is currently in use
     */
    public String getAlphabet() {
        return this.alphabet;
    }

    /**
     * Provides the possibility to change the alphabet and provide average
     * letter frequencies.
     *
     * @param alphabet The desired alphabet
     * @param expectedFrequencies The corresponding average letter frequencies
     * in the language/alphabet chosen
     */
    public void setAlphabet(String alphabet, double[] expectedFrequencies) {
        this.alphabet = alphabet;
        this.expectedLetterFrequencies = expectedFrequencies;
    }

    /**
     * This method counts the occurrences of each letter of the alphabet in the
     * text which is provided as the parameter.
     *
     * @param text The text the user wishes to analyze
     * @return A table where every index contains the number of occurrences for
     * every corresponding letter. If the default alphabet is used then a:s
     * occurrence count is in position 0, b:s occurrence count is in position 1
     * and so on.
     */
    public long[] countOccurrences(String text) {
        long[] occurrences = new long[this.alphabet.length()];
        for (int i = 0; i < occurrences.length; i++) {
            occurrences[i] = 0l;
        }

        for (int i = 0; i < text.length(); i++) {
            if (this.alphabetIndexes.containsKey(text.charAt(i))) {
                occurrences[this.alphabetIndexes.get(text.charAt(i))] += 1;
            }
        }

        return occurrences;
    }
}
