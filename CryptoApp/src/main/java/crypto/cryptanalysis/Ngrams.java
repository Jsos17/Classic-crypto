/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class is an abstract class to facilitate statistical calculations that
 * relate to n-grams i.e. to substrings of a piece of text that is of length n.
 *
 * @author jpssilve
 */
public abstract class Ngrams {

    private final int n;
    private final String filename;
    private long sampleSize;
    private final HashMap<String, Long> ngramStats;

    public Ngrams(int n, String filename) {
        this.n = n;
        this.filename = filename;
        this.sampleSize = 0;
        this.ngramStats = new HashMap<>();
        readFile();
    }

    public int getN() {
        return n;
    }

    /**
     * Reads the n-gram statistical data from a text file and then stores it in
     * a hash table
     *
     * @return The sample size of the statistical data contained in the text
     * file
     */
    private long readFile() {
        try (Scanner scanner = new Scanner(new File(this.filename))) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" ");
                if (line.length >= 2) {
                    long frequency = 0;
                    try {
                        frequency = Long.parseLong(line[1]);
                    } catch (NumberFormatException ne) {
                        System.err.println("The file is corrupted");
                    }

                    this.ngramStats.put(line[0], frequency);
                    this.sampleSize += frequency;
                }
            }
        } catch (FileNotFoundException exc) {
            System.err.println("File not found");
        }

        return this.sampleSize;
    }

    /**
     * Calculates the base 10 logarithm of a "probability" that is associated
     * with a particular n-gram. The "probability" is an empirical observation
     * of the count of the frequency the n-gram in the sample size divided by
     * the sample size.
     *
     * So the frequency of the n-gram is used as a substitute for a real
     * probability
     *
     * @param ngram A substring of a text that has a length of n
     * @return The base 10 logarithm of the "probability" as a double
     */
    public double logProbability(String ngram) {
        long count = this.getNgramCount(ngram);
        double dblCount = (double) count;
        if (count == 0) {
            dblCount = 0.1;
        }
        double prob = dblCount / this.sampleSize;
        return Math.log10(prob);
    }

    /**
     * The total amount of n-grams in the sample size i.e. the sum of all n-gram
     * counts in the sample
     *
     * @return The sample size as a long value
     */
    public long getSampleSize() {
        return sampleSize;
    }

    /**
     * Retrieves the particular count of occurrences of the n-gram in the
     * sample.
     *
     * @param ngram A substring of a text that has a length of n
     * @return The count of occurrences of this n-gram in the sample
     */
    public long getNgramCount(String ngram) {
        return this.ngramStats.getOrDefault(ngram, 0l);
    }

    /**
     * Calculates the base 10 logarithm of the product of all the n-gram
     * "probabilities" in a given text.
     *
     * The higher the value the more likely it is to be a valid English language
     * text sample. Since probabilities are smaller than zero the fitness value
     * is always smaller or equal to zero
     *
     * @param text The text that is to be assessed
     * @return The "fitness" of the text as a double value, the higher the value
     * the better.
     */
    public double fitness(String text) {
        if (text.length() < this.n) {
            return Double.NEGATIVE_INFINITY;
        }

        double logProbSum = 0;
        int i = 0;
        while (i + this.n <= text.length()) {
            logProbSum += logProbability(text.substring(i, i + this.n));
            i++;
        }

        return logProbSum;
    }
}
