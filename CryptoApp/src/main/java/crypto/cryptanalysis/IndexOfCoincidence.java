package crypto.cryptanalysis;

import crypto.helpers.CharacterValue;
import crypto.ciphers.VigenereCipher;
import crypto.datastructures.HashTable;
import crypto.helpers.AlphabetHelper;
import crypto.sorting.GenericTypeSort;

/**
 * This class counts various statistics related to Index of coincidence.
 *
 * @author jpssilve
 */
public class IndexOfCoincidence {

    private FrequencyAnalysis freq;
    private int c;
    private double expectedIC;
    private HashTable<Character, Integer> alphabetIndexes;
    private String keyCandidate;

    /**
     *
     * @param freq An instance of FrequencyAnalysis class
     */
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
        this.keyCandidate = "";
    }

    /**
     * The method returns the likeliest but not necessary the correct key if the
     * method findKey has been run. If findKey has not been run then only an
     * empty String is returned.
     *
     * @return The likeliest key if the method findKey has been run
     */
    public String getKeyCandidate() {
        return keyCandidate;
    }

    protected String[] subSequences(String ciphertext, int keyLen) {
        String[] subsequences = new String[keyLen];
        if (keyLen == 1) {
            subsequences[0] = ciphertext;
            return subsequences;
        }

        for (int k = 0; k < keyLen; k++) {
            String newText = "";
            for (int i = k; i < ciphertext.length(); i += keyLen) {
                newText += ciphertext.charAt(i);
            }

            subsequences[k] = newText;
        }

        return subsequences;
    }

    /**
     * This method calculates the aggregate Index of coincidence values for
     * different key lengths.
     *
     * If the value is close to 1 (or lower) then it is an indicator of a poor
     * candidate for the key length. If the key length value is close to 1.7 or
     * higher then it is a good candidate for key length. Another indicator for
     * possible key length is when the multiples of the key length also produce
     * high IC-values.
     *
     * @param ciphertext The text which the user wishes to decrypt
     * @return The index of coincidence values for each key length, so that the
     * user can make an informed choice of what the likeliest key length is
     */
    public double[] allAggregateDeltaBarICs(String ciphertext) {
        double[] deltaBarICs = new double[ciphertext.length()];
        for (int keyLen = 1; keyLen <= ciphertext.length(); keyLen++) {
            deltaBarICs[keyLen - 1] = aggregateDeltaBarIC(ciphertext, keyLen);
        }

        return deltaBarICs;
    }

    protected double aggregateDeltaBarIC(String ciphertext, int keyLen) {
        double sum = 0;
        String[] subsequences = subSequences(ciphertext, keyLen);
        for (String subsequence : subsequences) {
            sum += deltaBarIC(subsequence);
        }

        return sum / keyLen;
    }

    protected double deltaBarIC(String ciphertext) {
        if (ciphertext.length() <= 1) {
            return 0.0;
        }

        long[] occurrences = this.freq.countOccurrences(ciphertext);
        long charOccurrencesSum = 0;
        double sum = 0;
        for (int i = 0; i < occurrences.length; i++) {
            sum += occurrences[i] * (occurrences[i] - 1);
            charOccurrencesSum += occurrences[i];
        }

        return this.c * sum / (charOccurrencesSum * (charOccurrencesSum - 1));
    }

    protected double chiSquared(long[] occurrences, double[] frequencies, int textLen) {
        double chiSum = 0;
        for (int i = 0; i < occurrences.length; i++) {
            double expected = textLen * frequencies[i];
            chiSum += Math.pow(occurrences[i] - expected, 2) / expected;
        }

        return chiSum;
    }

    /**
     * This method most likely finds the key that was used to produce the
     * ciphertext from the original plaintext, if it is possible.
     *
     * Once the cryptanalyst has found the likely length of the key that was
     * used, then the original ciphertext is divided to blocks of texts based on
     * the key length, and it is hypothesized that every one of these blocks was
     * encrypted using the same character. This character is then found by
     * trying all the 26 different possibilities and then the character
     * producing the lowest chi-squared value is chosen as the likeliest
     * character of the key.
     *
     * The whole process is repeated keyLen times i.e. if the suspected key
     * length is 5, then the corresponding 5 subsequences are each checked for
     * the 26 alphabetical characters by calculating the chi-squared value.
     *
     * @param ciphertext The ciphertext which the cryptanalyst wishes to decrypt
     * @param keyLen The suspected key length
     * @return A two-dimensional array where the characters are sorted based on
     * their chi-squared value for each position of the key. In other words, the
     * method returns keyLen sorted arrays of alphabets, where the first
     * character of the alphabet is the most likeliest corresponding character
     * of the key. For example, if key length is seven, and the first character
     * of the first alphabet is c, the first character of the second alphabet is
     * i etc for p, h, e, r and finally s, then the likeliest key is "ciphers".
     * It is possible that sometimes the first character of the alphabet is not
     * part of the key, but instead the second one, or the 3rd etc.
     */
    public CharacterValue[][] findKey(String ciphertext, int keyLen) {
        VigenereCipher vig = new VigenereCipher();
        String[] subsequences = subSequences(ciphertext, keyLen);

        String alphabet = this.freq.getAlphabet();
        CharacterValue[][] charValues = new CharacterValue[keyLen][alphabet.length()];

        for (int i = 0; i < subsequences.length; i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                long[] occurrences = this.freq.countOccurrences(vig.decrypt(Character.toString(alphabet.charAt(j)), subsequences[i]));
                double value = chiSquared(occurrences, this.freq.getExpectedLetterFrequencies(), subsequences[i].length());
                charValues[i][j] = new CharacterValue(alphabet.charAt(j), value);
            }
        }

        char[] keyCand = new char[keyLen];
        for (int i = 0; i < charValues.length; i++) {
            GenericTypeSort.iterativeMergeSort(charValues[i]);
            if (charValues[i].length > 0) {
                keyCand[i] = charValues[i][0].getCharacter();
            }
        }

        this.keyCandidate = new String(keyCand);

        return charValues;
    }

    /**
     * Once the likely key is found, this method is used to decrypt the message
     * using the standard decryption method of the Vigenere class.
     *
     * The cryptanalyst must analyze the resulting plaintext to see if the
     * result makes sense or not.
     *
     * @see #findKey(String ciphertext, int keyLen)
     *
     * @param keyCandidate The candidate key
     * @param ciphertext The message that the cryptanalyst wishes to decrypt
     * @return The suspected plaintext, if the plaintext makes no sense then
     * either the key candidate was wrong, the plaintext was encrypted using
     * some method other than the Vigenere cipher or the original plaintext was
     * just gibberish.
     */
    public String solve(String keyCandidate, String ciphertext) {
        VigenereCipher vig = new VigenereCipher();
        return vig.decrypt(keyCandidate, ciphertext);
    }

}
