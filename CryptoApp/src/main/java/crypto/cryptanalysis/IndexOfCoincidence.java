/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import crypto.ciphers.VigenereCipher;
import crypto.helpers.AlphabetHelper;
import java.util.HashMap;

/**
 *
 * @author jpssilve
 */
public class IndexOfCoincidence {

    private FrequencyAnalysis freq;
    private int c;
    private double expectedIC;
    private HashMap<Character, Integer> alphabetIndexes;

    public IndexOfCoincidence(FrequencyAnalysis freq) {
        this.freq = freq;
        this.c = this.freq.getAlphabet().length();
        double sum_powers_of_2 = 0;
        for (int i = 0; i < this.freq.getExpectedLetterFrequencies().length; i++) {
            sum_powers_of_2 += this.freq.getExpectedLetterFrequencies()[i] * this.freq.getExpectedLetterFrequencies()[i];
        }

        this.expectedIC = c * sum_powers_of_2;
        AlphabetHelper help = new AlphabetHelper();
        this.alphabetIndexes = help.hashAlphabet(this.freq.getAlphabet());
    }

    private String[] subSequences(String ciphertext, int keyLen) {
        String[] subsequences = new String[keyLen];

        for (int k = 0; k < keyLen; k++) {
            String newText = "";
            for (int i = k; i < ciphertext.length(); i += keyLen) {
                newText += ciphertext.charAt(i);
            }

            subsequences[k] = newText;
        }

        return subsequences;
    }

    public double[] allDeltaBarICs(String ciphertext) {
        double[] deltaBarICs = new double[ciphertext.length()];
        for (int keyLen = 1; keyLen <= ciphertext.length(); keyLen++) {
            deltaBarICs[keyLen - 1] = aggregateDeltaBarIC(ciphertext, keyLen);
        }

        return deltaBarICs;
    }

    private double aggregateDeltaBarIC(String ciphertext, int keyLen) {
        double sum = 0;

        for (int k = 0; k < keyLen; k++) {
            String newText = "";
            for (int i = k; i < ciphertext.length(); i += keyLen) {
                newText += ciphertext.charAt(i);
            }

            sum += deltaBarIC(newText);
        }

        return sum / keyLen;
    }

    public double deltaBarIC(String ciphertext) {
        if (ciphertext.length() <= 1) {
            return 0.0;
        }

        int[] occurrences = this.freq.countOccurrences(ciphertext);
        double sum = 0;
        for (int i = 0; i < occurrences.length; i++) {
            sum += occurrences[i] * (occurrences[i] - 1);
        }

        return this.c * sum / (ciphertext.length() * (ciphertext.length() - 1));
    }

    private double chiSquared(int[] occurrences, double[] frequencies, int textLen) {
        double chiSum = 0;
        for (int i = 0; i < occurrences.length; i++) {
            double expected = textLen * frequencies[i];
            chiSum += Math.pow(occurrences[i] - expected, 2) / expected;
        }

        return chiSum;
    }

    public String findKey(String ciphertext, int keyLen) {
        VigenereCipher vig = new VigenereCipher();
        String[] subsequences = subSequences(ciphertext, keyLen);

        String alphabet = this.freq.getAlphabet();
        double smallest = Double.POSITIVE_INFINITY;
        int keyIndex = -1;
        String key = "";
        for (int i = 0; i < subsequences.length; i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                int[] occurrences = this.freq.countOccurrences(vig.decrypt(alphabet.substring(j, j + 1), subsequences[i]));
                double value = chiSquared(occurrences, this.freq.getExpectedLetterFrequencies(), subsequences[i].length());

                if (value < smallest) {
                    smallest = value;
                    keyIndex = j;
                }
            }

            key += alphabet.substring(keyIndex, keyIndex + 1);
            smallest = Double.POSITIVE_INFINITY;
        }

        return key;
    }

    public String solve(String keyCandidate, String ciphertext) {
        VigenereCipher vig = new VigenereCipher();
        return vig.decrypt(keyCandidate, ciphertext);
    }

}
