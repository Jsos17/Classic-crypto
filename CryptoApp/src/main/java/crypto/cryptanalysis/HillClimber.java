/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import crypto.ciphers.TranspositionCipher;
import crypto.datastructures.HashedSet;
import java.util.Random;

/**
 *
 * @author jpssilve
 */
public class HillClimber {

    private final Random rand;
    private final char[] alphabet;
    private final Ngrams ngrams;
    private final TranspositionCipher tCipher;
    private HashedSet<String> hashedSet;
    private double[] fitnesses;
    private String[] maybeKeys;

    public HillClimber(Ngrams ngrams) {
        this.rand = new Random();
        this.alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        this.ngrams = ngrams;
        this.tCipher = new TranspositionCipher();
        this.hashedSet = new HashedSet<>(100_000);
    }

    /**
     * This method simply loops over a mathematical optimization algorithm
     * climbAHill for the specified number of times trying to find the global
     * maximum among all the local maximums produced by the climbAHill
     * algorithm.
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
     * @param algoRestarts How many the times the algorithm attempts to find the
     * local maximum. In other words how many times the climbAHill algorithm is
     * run. The more restarts the likelier the algorithm is to find a true
     * global maximum among all the local maximums.
     * @param iterations How many times we try to find a "higher point on the
     * hill" i.e. to find a more optimal key by swapping two pairs of characters
     * in the key randomly.
     * @return The likeliest key based on the highest encountered fitness value
     * from all trial decryptions with random keys.
     */
    public String runToTheHills(int keyLen, String ciphertext, int algoRestarts, int iterations) {
        this.fitnesses = new double[algoRestarts];
        this.maybeKeys = new String[algoRestarts];
        double best = Double.NEGATIVE_INFINITY;
        String bestGuess = "";

        for (int i = 0; i < algoRestarts; i++) {
            climbAHill(keyLen, ciphertext, iterations, i);
            if (fitnesses[i] > best) {
                best = fitnesses[i];
                bestGuess = maybeKeys[i];
            }
        }

        return bestGuess;
    }

    /**
     * This is a mathematical optimization algorithm that tries to find a global
     * maximum for the "fitness value" of a plaintext by starting with a
     * randomly chosen key and then incrementally trying to find a key that
     * produces a higher fitness value for the plaintext when the original
     * ciphertext is decrypted with the key. The new keys are found by randomly
     * swapping two characters in the key and then if the fitness value produced
     * by this decryption is higher than the previous one, then the new key
     * becomes the basis for the next iteration.
     *
     * @param keyLen
     * @param ciphertext The ciphertext should be in uppercase and should be a
     * single block of text with no spaces etc
     * @param iterations How many times we try to find a "higher point on the
     * hill" i.e. to find a more optimal key by swapping two pairs of characters
     * in the key randomly.
     * @param index Allows the storing of all produced key candidates and their
     * corresponding fitness values in two separate array.
     */
    protected void climbAHill(int keyLen, String ciphertext, int iterations, int index) {
        char[] maybeKeyChars = new char[keyLen];
        System.arraycopy(this.alphabet, 0, maybeKeyChars, 0, keyLen);

        this.randomizeInPlace(maybeKeyChars);
        String maybeKey = new String(maybeKeyChars);
        double best = this.ngrams.fitness(this.tCipher.decryptSingleTransposition(maybeKey, ciphertext));
        this.hashedSet.insert(maybeKey);

        for (int i = 1; i <= iterations; i++) {
            maybeKey = swapRandom(maybeKeyChars);
            if (!this.hashedSet.contains(maybeKey)) {
                this.hashedSet.insert(maybeKey);
                double value = this.ngrams.fitness(this.tCipher.decryptSingleTransposition(maybeKey, ciphertext));

                if (value > best) {
                    best = value;
                    maybeKeyChars = maybeKey.toCharArray();
                }
            }
        }

        this.fitnesses[index] = best;
        this.maybeKeys[index] = new String(maybeKeyChars);
//        System.out.println("Current best: " + best + " current key: " + new String(maybeKeyChars));
    }

    protected String swapRandom(char[] keyChars) {
        char[] copy = new char[keyChars.length];
        System.arraycopy(keyChars, 0, copy, 0, keyChars.length);
        int idx1 = this.rand.nextInt(keyChars.length);
        int idx2 = this.rand.nextInt(keyChars.length);
        char temp = copy[idx1];
        copy[idx1] = copy[idx2];
        copy[idx2] = temp;

        return new String(copy);
    }

    protected char[] randomizeInPlace(char[] alphabet) {
        int n = alphabet.length;
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int rndNumber = random.ints(i, n).findFirst().getAsInt();
            char temp = alphabet[i];
            alphabet[i] = alphabet[rndNumber];
            alphabet[rndNumber] = temp;
        }

        return alphabet;
    }

}
