/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import crypto.ciphers.TranspositionCipher;
import crypto.datastructures.HashedSet;
import crypto.datastructures.LehmerRandomNumberGenerator;

/**
 *
 * @author jpssilve
 */
public class HillClimber {

    private final LehmerRandomNumberGenerator generator;
    private final char[] alphabet;
    private final Ngrams ngrams;
    private final TranspositionCipher tCipher;
    private double[] fitnesses;
    private String[] maybeKeys;

    public HillClimber(Ngrams ngrams) {
        this.generator = new LehmerRandomNumberGenerator();
        this.alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        this.ngrams = ngrams;
        this.tCipher = new TranspositionCipher();
    }

    /**
     * This method simply loops over the algorithm climbARandomHill (which
     * probably could be classified as a type of stochastic optimization
     * algorithm) for the specified number of times trying to find the global
     * maximum among all the local maximums (or close approximations of the
     * local maximum) produced by the climbARandomHill algorithm.
     *
     * This algorithm is not deterministic and no guarantees can be made that it
     * finds the right key. However, the more times the algorithm is run and the
     * more iterations each run consists of, the higher the chance that the
     * right decryption is found or at least a decryption that is close to the
     * right one.
     *
     * @param keyLen The trial length of the key used in the Singular
     * Transposition encryption
     * @param ciphertext The text we are trying to crack
     * @param algoRuns How many the times the algorithm attempts to find the
     * local maximum. In other words how many times the climbARandomHill
     * algorithm is run. The more restarts, the likelier the algorithm is to
     * find a true global maximum among all the local (pseudo-)maximums.
     * @param iterations How many times we try to find a "higher point on the
     * hill" i.e. to find a more optimal key by swapping two pairs of characters
     * in the key randomly.
     * @return The likeliest key based on the highest encountered fitness value
     * from all trial decryptions with random keys.
     */
    public String runToTheHills(int keyLen, String ciphertext, int algoRuns, int iterations) {
        this.fitnesses = new double[algoRuns];
        this.maybeKeys = new String[algoRuns];
        double best = Double.NEGATIVE_INFINITY;
        String bestGuess = "";

        String ciphertTextUpperCase = ciphertext.toUpperCase();
        for (int i = 0; i < algoRuns; i++) {
            climbARandomHill(keyLen, ciphertTextUpperCase, iterations, i);
            if (fitnesses[i] > best) {
                best = fitnesses[i];
                bestGuess = maybeKeys[i];
            }
        }

        return bestGuess;
    }

    /**
     * This method could probably be classified as a stochastic optimization
     * algorithm that tries to find a global maximum for the "fitness value" of
     * a plaintext by starting with a randomly chosen key and then incrementally
     * trying to find a key that produces a higher fitness value for the
     * plaintext when the original ciphertext is decrypted with the key. The new
     * keys are found by randomly swapping two characters in the key and then if
     * the fitness value produced by this decryption is higher than the previous
     * one, then the new key becomes the basis for the next iteration.
     *
     * @param keyLen The suspected key length
     * @param ciphertextUppercase The ciphertext should be in uppercase and
     * should be a single block of text with no spaces, commas, dots etc
     * @param iterations How many times we try to find a "higher point on the
     * hill" i.e. to find a more optimal key by swapping two pairs of characters
     * in the key randomly.
     * @param index Allows the storing of all produced key candidates and their
     * corresponding fitness values in two separate arrays.
     */
    protected void climbARandomHill(int keyLen, String ciphertextUppercase, int iterations, int index) {
        HashedSet hashedSet = new HashedSet<>(2 * iterations);
        char[] maybeKeyChars = new char[keyLen];
        System.arraycopy(this.alphabet, 0, maybeKeyChars, 0, keyLen);

        this.randomizeInPlace(maybeKeyChars);
        String maybeKey = new String(maybeKeyChars);
        double best = this.ngrams.fitness(this.tCipher.decryptSingleTransposition(maybeKey, ciphertextUppercase));
        hashedSet.insert(maybeKey);

        for (int i = 1; i <= iterations; i++) {
            maybeKey = swapRandomly(maybeKeyChars);
            if (!hashedSet.contains(maybeKey)) {
                hashedSet.insert(maybeKey);
                double value = this.ngrams.fitness(this.tCipher.decryptSingleTransposition(maybeKey, ciphertextUppercase));

                if (value > best) {
                    best = value;
                    maybeKeyChars = maybeKey.toCharArray();
                }
            }
        }

        this.fitnesses[index] = best;
        this.maybeKeys[index] = new String(maybeKeyChars);
    }

    /**
     * This method swaps two characters in a char array choosing the swapped
     * characters randomly. It is possible that no swap is done if the random
     * number is the same for both sampling draws.
     *
     * @param keyChars A char array
     * @return A new String formed after the swap
     */
    protected String swapRandomly(char[] keyChars) {
        char[] copy = new char[keyChars.length];
        System.arraycopy(keyChars, 0, copy, 0, keyChars.length);
        int idx1 = this.generator.nextInt(keyChars.length);
        int idx2 = this.generator.nextInt(keyChars.length);
        char temp = copy[idx1];
        copy[idx1] = copy[idx2];
        copy[idx2] = temp;

        return new String(copy);
    }

    /**
     * Code based on the pseudocode for Randomize-In-Place(A) method found in
     * the book Introduction to Algorithms, 3rd edition. It is meant to produce
     * a pseudo-random permutation of the alphabet, so that it can be used as
     * the starting point in the climbARandomHill algorithm.
     *
     * @param alphabet The alphabet that is pseudo-randomly permuted
     */
    protected void randomizeInPlace(char[] alphabet) {
        int n = alphabet.length;
        for (int i = 0; i < n; i++) {
            int rndNumber = this.generator.ints(i, n);
            char temp = alphabet[i];
            alphabet[i] = alphabet[rndNumber];
            alphabet[rndNumber] = temp;
        }
    }
}
