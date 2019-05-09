/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import crypto.ciphers.TranspositionCipher;

/**
 * The preliminary version of attacking transposition ciphers
 *
 * @author jpssilve
 */
public class AttackTranspositionCipher {

    private byte[] nums;
    private boolean[] used;
    private double benchmark;
    private String ciphertext;
    private String keyCandidate;

    private Combinatorics combi;
    private String alphabet;
    private TranspositionCipher ciph;
    private Ngrams quad;
    private HillClimber hillClimber;

    public AttackTranspositionCipher() {
        this.combi = new Combinatorics();
        this.alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.ciph = new TranspositionCipher();
        this.quad = new Ngrams(4);
        this.quad.readInputStream(getClass().getResourceAsStream("/english_quadgrams.txt"));
        this.hillClimber = new HillClimber(this.quad);
    }

    /**
     * A basic version of going through all possible transposition keys of
     * length 1 to 8. This method works as a benchmark for correctness, since
     * the algorithm producing the permutations has been tested exactly as it
     * is.
     *
     * @see #attackShortKeyWordsDynamic(String)
     *
     * Note that the actual characters of the key are not important. Only the
     * alphabetical order of the characters in the key are important, hence only
     * the alphabetical letters abcdefghi are used. If the original key
     * contained multiple same characters, then the result might be ambiguous
     * since only non-repeating characters should have been used in the key.
     *
     * This method does not always produce the right answer if the ciphertext is
     * short.
     *
     * @param ciphertext2 The ciphertext the cryptanalyst wishes to decrypt
     * @return The likeliest alphabetical order of the characters in the
     * original key as a keyword. Note that this is not necessarily the actual
     * key that was used to encrypt the text, but instead the alphabetical order
     * of the characters should correspond exactly to the returned key, which is
     * the only thing needed to decrypt the ciphertext. In other words, the
     * actual key is irrelevant in a transposition cipher, only the alphabetical
     * order of characters matters.
     */
    // Current limit set to 8 to speed up tests
    public String attackShortKeyWordsPreGenerated(String ciphertext2) {
        String keyCandidate2 = "a";
        double benchmark2 = this.quad.fitness(this.ciph.decryptSingleTransposition(keyCandidate2, ciphertext2));

        for (byte i = 2; i <= 8; i++) {
            byte[][] p = combi.permutations(i);
            for (byte[] p1 : p) {
                String maybeKey = "";
                for (int k = 0; k < p1.length; k++) {
                    maybeKey += this.alphabet.charAt(p1[k]);
                }
                double comparison = this.quad.fitness(this.ciph.decryptSingleTransposition(maybeKey, ciphertext2));
                if (comparison > benchmark2) {
                    benchmark2 = comparison;
                    keyCandidate2 = maybeKey;
                }
            }
        }

        return keyCandidate2;
    }

    /**
     * A different version of going through all possible transposition keys of
     * length 1 to 8 that calculates values while generating permutations. This
     * version does not build a two dimensional array to store all the possible
     * permutations, and instead once a permutation has been generated, then the
     * fitness value produced by the trial decryption with that particular
     * permutation of the key is calculated and, if it is the highest value thus
     * far, it becomes the new benchmark.
     *
     * @see #attackShortKeyWordsPreGenerated(String)
     *
     * This method does not always produce the right answer if the ciphertext is
     * short.
     *
     * @param ciphertext1 The ciphertext the cryptanalyst wishes to decrypt
     * @return The likeliest alphabetical order of the characters in the
     * original key as a keyword. Note that this is not necessarily the actual
     * key that was used to encrypt the text, but instead the alphabetical order
     * of the characters should correspond exactly to the returned key, which is
     * the only thing needed to decrypt the ciphertext. In other words, the
     * actual key is irrelevant in a transposition cipher, only the alphabetical
     * order of characters matters.
     */
    // Current limit set to 8 to speed up tests
    public String attackShortKeyWordsDynamic(String ciphertext1) {
        this.ciphertext = ciphertext1;
        this.keyCandidate = "a";
        this.benchmark = this.quad.fitness(this.ciph.decryptSingleTransposition(keyCandidate, this.ciphertext));

        for (int i = 2; i <= 8; i++) {
            attackPermutations(i);
        }

        return keyCandidate;
    }

    private void attackPermutations(int n) {
        this.nums = new byte[n];
        this.used = new boolean[n];
        generateDuringAttack(0);
    }

    private void generateDuringAttack(int k) {
        if (k >= this.nums.length) {
            char[] keyChars = new char[this.nums.length];
            for (int j = 0; j < this.nums.length; j++) {
                keyChars[j] = this.alphabet.charAt(this.nums[j]);
            }

            String maybeKey = new String(keyChars);
            double comparison = this.quad.fitness(this.ciph.decryptSingleTransposition(maybeKey, this.ciphertext));
            if (comparison > this.benchmark) {
                this.benchmark = comparison;
                this.keyCandidate = maybeKey;
            }
        } else {
            for (byte i = 0; i < this.nums.length; i++) {
                if (this.used[i] == false) {
                    this.used[i] = true;
                    this.nums[k] = i;
                    generateDuringAttack(k + 1);
                    this.used[i] = false;
                }
            }
        }
    }

    /**
     *
     * @param keyCandidate The suspected key, where the actual characters don't
     * matter, only the order of those characters
     * @param ciphertext The ciphertext the cryptanalyst wishes to deccrypt
     * @return The plaintext candidate
     */
    public String crackWithKey(String keyCandidate, String ciphertext) {
        return this.ciph.decryptSingleTransposition(keyCandidate, ciphertext);
    }

}
