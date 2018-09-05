/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import crypto.datastructures.HashTable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class facilitates statistical calculations that relate to n-grams i.e.
 * to substrings of a piece of text that are of length n.
 *
 * @author jpssilve
 */
public class Ngrams {

    private final int n;
    private final String filename;
    private long sampleSize;
    public final HashTable<String, Long> ngramStats;

    /**
     *
     * @param n The desired n-gram substring length i.e. monogram is 1-gram and
     * is related to frequencies of single letter in a text, bigram (2-gram) is
     * related to frequencies of letter pairs in a text etc.
     * @param filename A text file which contains data related to the specified
     * n-gram. For each row the file should have the n-gram string, then a
     * single space and finally the count of said n-grams in sample text. If the
     * file violates this rule, then the results most likely will not be
     * accurate.
     */
    public Ngrams(int n, String filename) {
        this.n = n;
        this.filename = filename;
        this.sampleSize = 0;
        this.ngramStats = new HashTable<>();
        readFile();
    }

    public int getN() {
        return n;
    }

    /**
     * Reads the n-gram statistical data from a text file and then stores it in
     * a hash table. The text file is provided as a constructor parameter.
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
                        this.ngramStats.hashInsert(line[0], frequency);
                        this.sampleSize += frequency;
                    } catch (NumberFormatException ne) {
                        System.err.println("The file is corrupted");
                    }
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
     * @param ngram A substring of a text that has a length of n and is in upper case
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
     * @param ngram A substring of a text that has a length of n and is in upper case
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
     * @param text The text (in upper case) that is to be assessed
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
